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
	JPanel inputPanel;      //������
	JPanel viewPanel;      //������
	JPanel checkPanel;      //�������
	JPanel deletePanel;      //ɾ�����
	
	
	StudentPanel inputInnerPanel;//���
	JButton inputBtn;
	JButton clearBtn1;
	
	JTextArea viewArea;     //���
	JButton viewBtn;
	
	   //����
	JLabel checkNameLabel;
	JTextField checkNameField;
	JButton checkBtn;
	
	
	//ɾ��
	JLabel deleteNameLabel;
	JTextField deleteNameField;
	JButton deleteBtn;
	
	
	
	public StudentManagement(){
		super("ѧ��������Ϣ����ϵͳ");
		serGUIComponent();
	}
	
	public void serGUIComponent() {
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		 
		dbTabPane = new JTabbedPane();
		
		
		
		
		
		
		
		//����������
		 inputPanel = new JPanel();
		 inputPanel.setPreferredSize(new Dimension(300,300));
		inputPanel.setLayout(null);
		 inputBtn = new JButton("���");
		 clearBtn1 = new JButton("���");
		inputBtn.setBounds(80,160,60,30);
		clearBtn1.setBounds(180,160,60,30);
		
		inputBtn.addActionListener(this);
		clearBtn1.addActionListener(this);
		inputInnerPanel = new StudentPanel();
		inputPanel.add(inputInnerPanel);
		inputPanel.add(inputBtn);
		inputPanel.add(clearBtn1);
		dbTabPane.add("�������", inputPanel);
		
		
		
		//����ɾ�����
	
		       deletePanel = new JPanel();
		       deleteNameLabel = new JLabel("��������");
		       deleteNameField = new JTextField(10);
				deleteBtn = new JButton("ɾ��");
				deleteBtn.addActionListener(this);
				deletePanel = new JPanel();
				
				deletePanel.add(deleteNameLabel);
				deletePanel.add(deleteNameField);
				deletePanel.add(deleteBtn);
				dbTabPane.add("ɾ������", deletePanel);
		
		//����������
				checkPanel = new JPanel();
				checkNameLabel = new JLabel("��������");
				checkNameField = new JTextField(10);
				checkBtn = new JButton("����");
				checkBtn.addActionListener(this);
				checkPanel = new JPanel();
				
				checkPanel.add(checkNameLabel);
				checkPanel.add(checkNameField);
				checkPanel.add(checkBtn);
				dbTabPane.add("����", checkPanel);
		

		
		//����鿴����ѧ�����
				viewPanel = new JPanel();
				viewPanel.setLayout(null);
				//viewPanel.setLayout(new BorderLayout());
				viewArea = new JTextArea(6,35);
				viewBtn = new JButton("���");
				viewBtn.setBounds(20,10,60,40);
				viewPanel.add(new JScrollPane(viewArea), BorderLayout.CENTER);
				viewPanel.add(viewBtn,BorderLayout.SOUTH);
				viewBtn.addActionListener(this);
				dbTabPane.addTab("���", viewPanel);
		
		
		c.add(BorderLayout.NORTH,dbTabPane);
		
	}
	
	
	
	//��������ѧ����Ϣ
		public static void viewRecords(ArrayList<Student> arry) {
			if(arry.size()==0) {
				System.out.println("Ŀǰ��û��ѧ������Ϣ�ɹ���ѯ");
				return;
			}
			System.out.println("����ѧ����Ϣ��");
			System.out.println("ѧ��\t����\t�Ա�\t��������");
			for(int i=0;i<arry.size();i++) {
				Student s = arry.get(i);
				System.out.println(s.getStdId()+"\t"+s.getName()+"\t"+s.getGender()+"\t"+s.getBirth());
			}
		}
	
	
	
	
		 //���ѧ����Ϣ
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
				//��ѧ��������ӵ�����
				arry.add(s);
				System.out.println("��ӳɹ�");
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
					System.out.println("��ѧ����ID�Ѵ��ڣ�");
				}else {
					Student s = new Student();
					s.setStdId(no);
					s.setName(name);
					s.setBirth(birth);
					s.setGender(gender);
					//��ѧ��������ӵ�����
					arry.add(s);
					System.out.println("��ӳɹ�");
				}
			}
		
		
		
		
		
	}
	
	
	//ɾ��ѧ����Ϣ
		public static void deleteRecord(String name,ArrayList<Student> arry) {	 
			boolean flag = false;
			for(int i=0;i<arry.size();i++) {
				
				  Student s = arry.get(i);
				  if(s.getName().equals(name)) {		
					  arry.remove(i);
					  flag = false;
					  System.out.println("ɾ��ѧ��"+s.getName()+"�ɹ���");
			    	  break;
					}else {
						 flag = true;
						
					}	
				}
			if(flag==true) {
				System.out.println("��Ҫɾ����ѧ�������ڣ�");
			}
		}
		
		
		//����ѧ����Ϣ
				public static void checkRecord(String name,ArrayList<Student> arry) {
								
					boolean flag = false;
					for(int i=0;i<arry.size();i++) {
						
					  Student s = arry.get(i);
					  if(s.getName().equals(name)) {
						System.out.println("���ҽ����");  
						System.out.println("ѧ��\t����\t�Ա�\t��������");
				    	System.out.println(s.getStdId()+"\t"+s.getName()+"\t"+s.getGender()+"\t"+s.getBirth());
				    	flag=false;
				    	break;
						}else {
							flag=true;
							
						}	
					}
					if(flag==true) {
						System.out.println("��ѧ�������ڣ�");
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
			//���ѧ����Ϣ
			inputRecords(arry);
		}else if(e.getSource() == viewBtn){
			//�鿴����ѧ����Ϣ
			viewRecords(arry);
		}else if(e.getSource() ==checkBtn){
			//�鿴ĳ��ѧ��
			checkRecord(checkNameField.getText(),arry);
		}else if(e.getSource() == deleteBtn){
			//ɾ��ѧ����Ϣ
			deleteRecord(deleteNameField.getText(),arry);
	
		}else if(e.getSource() == clearBtn1){
			inputInnerPanel.clearContent();
		}
	}
 
}

