package StudentManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class test  extends Frame implements ActionListener{
	
	//����Ĺ��캯��
     public test() {
    	 this.setSize(600,600);
    	 this.setTitle("�ҵĴ���");
    	 Button button1=new Button("��ť");
    	 //����ť��ӵ����¼�
    	 button1.addActionListener(this);
    	 //��������������Բ��֣�������
    	 FlowLayout flowLayout=new FlowLayout();
    	 this.setLayout(flowLayout);
    	 
    	 //��������ӹر��¼�
    	 this.addWindowListener(new WindowAdapter() {
    		 @Override 
    		 public void windowClosing(WindowEvent e) {
    			 super.windowClosing(e);
    			
				System.exit(0);
    		 }
    	 });
    	 
    	 //�Ѱ�ť��ӵ�������
    	 this.add(button1);    	 
    	 //�����������ʾ����
    	 this.setVisible(true);
     }
     //�����¼�����ķ���
     @Override 
     public void actionPerformed(ActionEvent e) {
    	 System.out.println("��������Ϣ");
     }
     
     public static void main(String[] args) {
    	 new test();
     }
   
}
