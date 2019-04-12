package StudentManager;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

 
public class StudentManagement extends JFrame implements ActionListener{
	ArrayList<Student> arry = new ArrayList<>();
 
	JTabbedPane dbTabPane;
	JPanel inputPanel;      //添加面板
	JPanel viewPanel;      //输出面板
	JPanel checkPanel;      //查找面板
	JPanel deletePanel;      //删除面板
	
	
	StudentPanel inputInnerPanel;//添加
	JButton inputBtn;
	JButton clearBtn1;
	
	JTextArea viewArea;     //输出
	JButton viewBtn;
	
	   //查找
	JLabel checkNameLabel;
	JTextField checkNameField;
	JButton checkBtn;
	
	
	//删除
	JLabel deleteNameLabel;
	JTextField deleteNameField;
	JButton deleteBtn;
	
	
	
	public StudentManagement(){
		super("学生基本信息管理系统");
		serGUIComponent();
	}
	
	public void serGUIComponent() {
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		 
		dbTabPane = new JTabbedPane();
		
		
		
		
		
		
		
		//定义添加面板
		 inputPanel = new JPanel();
		 inputPanel.setPreferredSize(new Dimension(300,300));
		inputPanel.setLayout(null);
		 inputBtn = new JButton("添加");
		 clearBtn1 = new JButton("清除");
		inputBtn.setBounds(80,160,60,30);
		clearBtn1.setBounds(180,160,60,30);
		
		inputBtn.addActionListener(this);
		clearBtn1.addActionListener(this);
		inputInnerPanel = new StudentPanel();
		inputPanel.add(inputInnerPanel);
		inputPanel.add(inputBtn);
		inputPanel.add(clearBtn1);
		dbTabPane.add("添加数据", inputPanel);
		
		
		
		//定义删除面板
	
		       deletePanel = new JPanel();
		       deleteNameLabel = new JLabel("输入姓名");
		       deleteNameField = new JTextField(10);
				deleteBtn = new JButton("删除");
				deleteBtn.addActionListener(this);
				deletePanel = new JPanel();
				
				deletePanel.add(deleteNameLabel);
				deletePanel.add(deleteNameField);
				deletePanel.add(deleteBtn);
				dbTabPane.add("删除数据", deletePanel);
		
		//定义查找面板
				checkPanel = new JPanel();
				checkNameLabel = new JLabel("输入姓名");
				checkNameField = new JTextField(10);
				checkBtn = new JButton("查找");
				checkBtn.addActionListener(this);
				checkPanel = new JPanel();
				
				checkPanel.add(checkNameLabel);
				checkPanel.add(checkNameField);
				checkPanel.add(checkBtn);
				dbTabPane.add("查找", checkPanel);
		

		
		//定义查看所有学生面板
				viewPanel = new JPanel();
				viewPanel.setLayout(null);
				//viewPanel.setLayout(new BorderLayout());
				viewArea = new JTextArea(6,35);
				viewBtn = new JButton("输出");
				viewBtn.setBounds(20,10,60,40);
				viewPanel.add(new JScrollPane(viewArea), BorderLayout.CENTER);
				viewPanel.add(viewBtn,BorderLayout.SOUTH);
				viewBtn.addActionListener(this);
				dbTabPane.addTab("输出", viewPanel);
		
		
		c.add(BorderLayout.NORTH,dbTabPane);
		
	}
	
	
	
	//查找所有学生信息
		public static void viewRecords(ArrayList<Student> arry) {
			if(arry.size()==0) {
				System.out.println("目前还没有学生的信息可供查询");
				return;
			}
			System.out.println("所有学生信息：");
			System.out.println("学号\t姓名\t性别\t出生年月");
			for(int i=0;i<arry.size();i++) {
				Student s = arry.get(i);
				System.out.println(s.getStdId()+"\t"+s.getName()+"\t"+s.getGender()+"\t"+s.getBirth());
			}
		}
	
	
	
	
		 //添加学生信息
	public void inputRecords(ArrayList<Student> arry){     
		String no = inputInnerPanel.getNo();
		String name = inputInnerPanel.getName();
		String gender = inputInnerPanel.getGender();
		String birth = inputInnerPanel.getBirth();
		
			
			if(arry.size()==0) {
				Student s = new Student();
				s.setStdId(no);
				s.setName(name);
				s.setBirth(birth);
				s.setGender(gender);
				//把学生对象添加到集合
				arry.add(s);
				System.out.println("添加成功");
			}
			else {
				
				boolean flag = false;
				for(int i=0;i<arry.size();i++) {
					Student s = arry.get(i);
					if(s.getStdId().equals(no)) {		
						flag = true;			
						break;
					}
				}
				if(flag) {
					System.out.println("此学生的ID已存在！");
				}else {
					Student s = new Student();
					s.setStdId(no);
					s.setName(name);
					s.setBirth(birth);
					s.setGender(gender);
					//把学生对象添加到集合
					arry.add(s);
					System.out.println("添加成功");
				}
			}
		
		
		
		
		
	}
	
	
	//删除学生信息
		public static void deleteRecord(String name,ArrayList<Student> arry) {	 
			boolean flag = false;
			for(int i=0;i<arry.size();i++) {
				
				  Student s = arry.get(i);
				  if(s.getName().equals(name)) {		
					  arry.remove(i);
					  flag = false;
					  System.out.println("删除学生"+s.getName()+"成功！");
			    	  break;
					}else {
						 flag = true;
						
					}	
				}
			if(flag==true) {
				System.out.println("您要删除的学生不存在！");
			}
		}
		
		
		//查找学生信息
				public static void checkRecord(String name,ArrayList<Student> arry) {
								
					boolean flag = false;
					for(int i=0;i<arry.size();i++) {
						
					  Student s = arry.get(i);
					  if(s.getName().equals(name)) {
						System.out.println("查找结果：");  
						System.out.println("学号\t姓名\t性别\t出生年月");
				    	System.out.println(s.getStdId()+"\t"+s.getName()+"\t"+s.getGender()+"\t"+s.getBirth());
				    	flag=false;
				    	break;
						}else {
							flag=true;
							
						}	
					}
					if(flag==true) {
						System.out.println("此学生不存在！");
					}
					
					 
				}
	
 
	public static void main(String[] args) {
		
		StudentManagement app = new StudentManagement();
		app.setSize(500,260);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		
	}
 
 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == inputBtn){
			//添加学生信息
			inputRecords(arry);
		}else if(e.getSource() == viewBtn){
			//查看所有学生信息
			viewRecords(arry);
		}else if(e.getSource() ==checkBtn){
			//查看某个学生
			checkRecord(checkNameField.getText(),arry);
		}else if(e.getSource() == deleteBtn){
			//删除学生信息
			deleteRecord(deleteNameField.getText(),arry);
	
		}else if(e.getSource() == clearBtn1){
			inputInnerPanel.clearContent();
		}
	}
 
}

