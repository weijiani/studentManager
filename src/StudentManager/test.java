package StudentManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class test  extends Frame implements ActionListener{
	
	//窗体的构造函数
     public test() {
    	 this.setSize(600,600);
    	 this.setTitle("我的窗体");
    	 Button button1=new Button("按钮");
    	 //给按钮添加单击事件
    	 button1.addActionListener(this);
    	 //让这个窗体是线性布局，从左到右
    	 FlowLayout flowLayout=new FlowLayout();
    	 this.setLayout(flowLayout);
    	 
    	 //给窗体添加关闭事件
    	 this.addWindowListener(new WindowAdapter() {
    		 @Override 
    		 public void windowClosing(WindowEvent e) {
    			 super.windowClosing(e);
    			
				System.exit(0);
    		 }
    	 });
    	 
    	 //把按钮添加到窗体上
    	 this.add(button1);    	 
    	 //让这个窗体显示出来
    	 this.setVisible(true);
     }
     //单击事件处理的方法
     @Override 
     public void actionPerformed(ActionEvent e) {
    	 System.out.println("弹出的信息");
     }
     
     public static void main(String[] args) {
    	 new test();
     }
   
}
