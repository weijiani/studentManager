package StudentManager;



/**
 * 功能简介：实现"录入","修改","浏览","删除"学生基本信息的面板
 */
 
import java.awt.*;
import javax.swing.*;
 
public class StudentPanel extends JPanel{
	JLabel nolabel;       //学号标签
	JLabel namelabel;     //姓名标签
	JLabel genderlabel;   //性别标签
	JLabel birthlabel;    //出生年月标签
	
	
	JTextField nofield;     //学号输入框
	JTextField namefield;   //姓名输入框
	JTextField genderfield; //性别输入框
	JTextField birthfield;  //出生年月输入框
	
	
	public StudentPanel(){
		setGUIComponent();
	}
	
	public void setGUIComponent() {
		
		//初始化组件
		nolabel = new JLabel("学号");
		nofield = new JTextField(10);
		namelabel = new JLabel("姓名");
		namefield = new JTextField(10);
		genderlabel = new JLabel("性别");
		genderfield = new JTextField(10);
		birthlabel = new JLabel("出生年月");
		birthfield = new JTextField(10);
		
		
		//设置组件
		this.setLayout(null);
		nolabel.setBounds(20,20,40,30);
		nofield.setBounds(90,20,100,20);
		namelabel.setBounds(20,50,40,30);
		namefield.setBounds(90,50,100,20);
		genderlabel.setBounds(20,80,40,30);
		genderfield.setBounds(90,80,100,20);
		birthlabel.setBounds(20,110,60,30);
		birthfield.setBounds(90,110,100,20);
		this.add(nolabel);
		this.add(nofield);
		this.add(namelabel);
		this.add(namefield);
		this.add(genderlabel);
		this.add(genderfield);
		this.add(birthlabel);
		this.add(birthfield);
		
		this.setVisible(true);
		this.setSize(300,150);
		
	}
	
	//清除文本框的内容
	public void clearContent(){
		nofield.setText("");
		namefield.setText("");
		genderfield.setText("");
		birthfield.setText("");
		
	}
	
	//输入
	public void setNo(String n){
		nofield.setText(n);
	}
	public void setName(String n){
		namefield.setText(n);
	}
	public void setGender(String n){
		genderfield.setText(n);
	}
	public void setBirth(String n){
		birthfield.setText(n);
	}
	
	
	//得到文本框内容
	public String getNo(){
		return nofield.getText();
	}
	public String getName(){
		return namefield.getText();
	}
	public String getGender(){
		return genderfield.getText();
	}
	public String getBirth(){
		return birthfield.getText();
	}
	
	
}

