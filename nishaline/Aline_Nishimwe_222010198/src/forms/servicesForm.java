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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.services;

public class servicesForm implements ActionListener{
	
	JFrame frame;
	JLabel service_id_lb=new JLabel("service_Id");
	JLabel date_lb=new JLabel("date");
	JLabel duration_lb=new JLabel("duration");
	JLabel type_of_service_lb=new JLabel("type_of_service");
	JLabel availability_lb=new JLabel("availability");

	JTextField service_id_txf=new JTextField();
	JTextField date_txf=new JTextField();
	JTextField duration_txf=new JTextField();
	JTextField type_of_service_txf=new JTextField();
	JTextField availability_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public servicesForm() {
		createForm();
	}

	private void createForm() {
		
			frame=new JFrame();
			frame.setTitle("                         Services FORM            ");
			frame.setBounds(20, 20, 600, 600);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			setLocationandSize();
			
		// TODO Auto-generated method stub
		
	}

	private void setLocationandSize() {
		service_id_lb.setBounds(10, 10, 150, 30);
		date_lb.setBounds(10, 50, 150, 30);
		duration_lb.setBounds(10, 90, 150, 30);
		type_of_service_lb.setBounds(10, 130, 150, 30);
		availability_lb.setBounds(10, 170, 150, 30);
		
		service_id_txf.setBounds(160, 10, 200, 30);
		date_txf.setBounds(160, 50, 200, 30);
		duration_txf.setBounds(160, 90, 200, 30);
		type_of_service_txf.setBounds(160, 130, 200, 30);
		availability_txf.setBounds(160,170 ,200 , 30);
		
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
		service_id_lb.setFont(font);
		date_lb.setFont(font);
		duration_lb.setFont(font);
		type_of_service_lb.setFont(font);
		availability_lb.setFont(font);
		
		service_id_txf.setFont(font);
		date_txf.setFont(font);
		duration_txf.setFont(font);
		type_of_service_txf.setFont(font);
		availability_txf.setFont(font);

		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		// TODO Auto-generated method stub
		
	}

	private void addcomponentforFrame() {
		frame.add(service_id_lb);
		frame.add(date_lb);
		frame.add(duration_lb);
		frame.add(type_of_service_lb);
		frame.add(availability_lb);
		
		frame.add(service_id_txf);
		frame.add(date_txf);
		frame.add(duration_txf);
		frame.add(type_of_service_txf);
		frame.add(availability_txf);
		
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

	public static void main(String[] args) {
		servicesForm sf= new servicesForm();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
services s=new services();
		if(e.getSource() == insert_btn) {
			
			s.setDate(date_txf.getText());
			s.setDuration(duration_txf.getText());
			s.setType_of_service(type_of_service_txf.getText());
			s.setAvailability(availability_txf.getText());
			s.insertData();
		}
	
	else if ((e.getSource()==Read_btn)) {
		DefaultTableModel tableModel=s.populateTable();
		table.setModel(tableModel);

}  
	else if (e.getSource()==update_btn) {
		int service_id=Integer.parseInt(service_id_txf.getText());
		s.setDate(date_txf.getText());
		s.setDuration(duration_txf.getText());
		s.setType_of_service(type_of_service_txf.getText());
		s.setAvailability(availability_txf.getText());
		
		s.update(service_id);
	}
	else {
	int service_id=Integer.parseInt(service_id_txf.getText());
	s.delete(service_id);
}}
}
		
			


