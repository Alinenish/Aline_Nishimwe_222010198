package forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PasswordView;

import org.w3c.dom.css.RGBColor;

import entities.Registration;

public class RegistrationForm implements ActionListener {

	JFrame frame;
	JLabel customer_id_lb= new JLabel("customer_id");
	JLabel password_lb=new JLabel("password");
	JLabel NAME_lb=new JLabel("NAME");
	JLabel COUNTRY_lb=new JLabel("COUNTRY");
	JLabel DISTRICT_lb=new JLabel("DISTRICT");
	JLabel AGE_lb=new JLabel("AGE");
	JLabel GENDER_lb=new JLabel("GENDER");
	JLabel Email_lb=new JLabel("Email");
	
	
	JTextField customer_id_txf=new JTextField();
	 JTextField password_txf=new JTextField();
 JTextField NAME_txf=new JTextField();
	JTextField COUNTRY_txf=new JTextField();
	JTextField DISTRICT_txf=new JTextField();
	JTextField AGE_txf=new JTextField();
	String []GENDER={"Male","Female"};
	JComboBox<String> GENDERBox = new JComboBox<>(GENDER);
	JTextField Email_txf=new JTextField();
	
	
	
	JButton sign_up_btn=new JButton("sign_up");
	JButton cancel_btn=new JButton("cancel");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public RegistrationForm() {
		createForm();
	}
	

	private void createForm( ) {
		
		frame=new JFrame();
		frame.setTitle("                         Registration FORM            ");
		
		frame.setBounds(0, 0,w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
	}
			
		// TODO Auto-generated method stub
		


	private void setLocationandSize() {
		
	customer_id_lb.setBounds(10, 10, 150, 30);
		password_lb.setBounds(10, 40, 150, 30);
		NAME_lb.setBounds(10, 80, 150, 30);
		COUNTRY_lb.setBounds(10, 130, 150, 30);
		DISTRICT_lb.setBounds(10, 180, 150, 30);
		AGE_lb.setBounds(10, 220, 150, 30);
		GENDER_lb.setBounds(10,300 , 200, 30);
		Email_lb.setBounds(10,260,200,30);
		
		
		customer_id_txf.setBounds(160, 10, 150, 30);
		password_txf.setBounds(160, 40, 200, 30);
		NAME_txf.setBounds(160, 80, 200, 30);
		COUNTRY_txf.setBounds(160, 130, 200, 30);
		DISTRICT_txf.setBounds(160, 180, 200, 30);
		AGE_txf.setBounds(160,220 ,200 , 30);
		GENDERBox.setBounds(160, 300, 200, 30);
		Email_txf.setBounds(160,260,200,30);
		
		sign_up_btn.setBounds(170,360, 120, 30);
		cancel_btn.setBounds(290,360, 120, 30);
		setFontforall();
		
		
	}


	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		customer_id_lb.setFont(font);
		password_lb.setFont(font);
		NAME_lb.setFont(font);
		COUNTRY_lb.setFont(font);
		DISTRICT_lb.setFont(font);
		AGE_lb.setFont(font);
		GENDER_lb.setFont(font);
		Email_lb.setFont(font);
		
		
		customer_id_txf.setFont(font);
		password_txf.setFont(font);
		NAME_txf.setFont(font);
		COUNTRY_txf.setFont(font);
		DISTRICT_txf.setFont(font);
		AGE_txf.setFont(font);
		GENDERBox.setFont(font);
		Email_txf.setFont(font);
		
		
		
		sign_up_btn.setFont(font);
		cancel_btn.setFont(font);
		addcomponentforFrame();

			
			
		}


	private void addcomponentforFrame() {
		frame.add(customer_id_lb);
		frame.add(password_lb);
		frame.add(NAME_lb);
		frame.add(COUNTRY_lb);
		frame.add(DISTRICT_lb);
		frame.add(AGE_lb);
		frame.add(GENDER_lb);
		frame.add(Email_lb);
		
		
		frame.add(customer_id_lb);
		frame.add(password_txf);
		frame.add(NAME_txf);
		frame.add(COUNTRY_txf);
		frame.add(DISTRICT_txf);
		frame.add(AGE_txf);
		frame.add(GENDERBox);
		frame.add(Email_txf);
		
		
	
		frame.add(sign_up_btn);
		frame.add(cancel_btn);
		ActionEvent();
	}

	private void ActionEvent() {
		
		sign_up_btn.addActionListener(this);
		cancel_btn.addActionListener(this);
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {
RegistrationForm rg =  new RegistrationForm();
	
	
		}
		public void actionPerformed(java.awt.event.ActionEvent e) {
			Registration r = new Registration();
			if(e.getSource() == sign_up_btn){
				r.setPassword(password_txf.getText());
				r.setNAME(NAME_txf.getText());
				r.setCOUNTRY(COUNTRY_txf.getText());
				r.setDISTRICT(DISTRICT_txf.getText());
				r.setAGE(AGE_txf.getText());
				r.setGENDER(GENDERBox.getToolTipText());
				r.setEmail(Email_txf.getText());
				r.insertData();
				}
		

	
		}


		public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			
		}
		

	

	}
	
	
		
		
	

