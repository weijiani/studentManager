package StudentManager;



/**
 * ���ܼ�飺ʵ��"¼��","�޸�","���","ɾ��"ѧ��������Ϣ�����
 */
 
import java.awt.*;
import javax.swing.*;
 
public class StudentPanel extends JPanel{
	JLabel nolabel;       //ѧ�ű�ǩ
	JLabel namelabel;     //������ǩ
	JLabel genderlabel;   //�Ա��ǩ
	JLabel birthlabel;    //�������±�ǩ
	
	
	JTextField nofield;     //ѧ�������
	JTextField namefield;   //���������
	JTextField genderfield; //�Ա������
	JTextField birthfield;  //�������������
	
	
	public StudentPanel(){
		setGUIComponent();
	}
	
	public void setGUIComponent() {
		
		//��ʼ�����
		nolabel = new JLabel("ѧ��");
		nofield = new JTextField(10);
		namelabel = new JLabel("����");
		namefield = new JTextField(10);
		genderlabel = new JLabel("�Ա�");
		genderfield = new JTextField(10);
		birthlabel = new JLabel("��������");
		birthfield = new JTextField(10);
		
		
		//�������
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
	
	//����ı��������
	public void clearContent(){
		nofield.setText("");
		namefield.setText("");
		genderfield.setText("");
		birthfield.setText("");
		
	}
	
	//����
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
	
	
	//�õ��ı�������
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

