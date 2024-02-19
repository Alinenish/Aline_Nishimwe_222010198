package forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.manager;

public class managerForm implements ActionListener {
	JFrame frame;
	JLabel manager_id_lb=new JLabel("manager_Id");
	JLabel username_lb=new JLabel("username");
	JLabel password_hash_lb=new JLabel("password_hash");
	JLabel Email_lb=new JLabel("Email");
	JLabel Role_lb=new JLabel("Role");
			
	JTextField manager_id_txf=new JTextField();
	JTextField username_txf=new JTextField();
	JTextField password_hash_txf=new JTextField();
	JTextField Email_txf=new JTextField();
	JTextField Role_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public managerForm() {
		createForm();
	}
	

	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         Manager FORM           ");
		frame.setBounds(0, 0, 600, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.darkGray);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
		// TODO Auto-generated method stub 
		
	}


	private void setLocationandSize() {
		manager_id_lb.setBounds(10, 10, 150, 30);
		username_lb.setBounds(10, 50, 150, 30);
		password_hash_lb.setBounds(10, 90, 150, 30);
		Email_lb.setBounds(10, 130, 150, 30);
		Role_lb.setBounds(10, 160, 170, 30);
		
		manager_id_txf.setBounds(160, 10, 200, 30);
		username_txf.setBounds(160, 50, 200, 30);
		password_hash_txf.setBounds(160, 90, 200, 30);
		Email_txf.setBounds(160, 130, 200, 30);
		Role_txf.setBounds(160, 170, 200, 30);
	
		insert_btn.setBounds(10,290, 100, 30);
		Read_btn.setBounds(100,290, 100, 30);
		update_btn.setBounds(190,290, 100, 30);
		delete_btn.setBounds(280,290, 100, 30);
		table.setBounds(400, 10, 400, 300);
		setFontforall();
		// TODO Auto-generated method stub
		
	}


	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		manager_id_lb.setFont(font);
		username_lb.setFont(font);
		password_hash_lb.setFont(font);
		Email_lb.setFont(font);
		Role_lb.setFont(font);
		
		
		manager_id_txf.setFont(font);
		username_txf.setFont(font);
		password_hash_txf.setFont(font);
		Email_txf.setFont(font);
		Role_txf.setFont(font);
		
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		// TODO Auto-generated method stub
		
	}


	private void addcomponentforFrame() {
		frame.add(manager_id_lb);
		frame.add(username_lb);
		frame.add(password_hash_lb);
		frame.add(Email_lb);
		frame.add(Role_lb);
		
		frame.add(manager_id_txf);
		frame.add(username_txf);
		frame.add(password_hash_txf);
		frame.add(Email_txf);
		frame.add(Role_txf);
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add( table);
		ActionEvent();	
		// TODO Auto-generated method stub
		
	}


	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		
		// TODO Auto-generated method stub
		
	}


	
		// TODO Auto-generated method stub

	
	public static void main(String[] args) {
	managerForm mF =new managerForm();
	
	}
public void actionPerformed(ActionEvent e) {
		manager m=new manager();
		if  (e.getSource()==insert_btn) {
			m.setUsername(username_txf.getText());
			m.setPassword_hash(password_hash_txf.getText());
			m.setEmail(Email_txf.getText());
			m.setRole(Role_txf.getText());
			m.insertData();	
	}
else if ((e.getSource()==Read_btn)) {
	DefaultTableModel tableModel=m.populateTable();
	table.setModel(tableModel);

}else if (e.getSource()==update_btn) {
	int manager_id=Integer.parseInt(manager_id_txf.getText());
	m.setUsername(username_txf.getText());
	m.setPassword_hash(password_hash_txf.getText());
	m.setEmail(Email_txf.getText());
	m.setRole(Role_txf.getText());
	m.update(manager_id);
}
else {
	int manager_id=Integer.parseInt(manager_id_txf.getText());
	m.delete(manager_id);
}
}
}




 
	
	


	
	
		
		// TODO Auto-generated method stub

		
	


	
			
		
	// TODO Auto-generated method stub
	






		


		
	
