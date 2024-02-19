package forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.Attachments;

public class AttachmentsForm implements ActionListener{

	JFrame frame;
	JLabel Attachment_id_lb=new JLabel("Id");
	JLabel File_name_lb=new JLabel("File_name");
	JLabel File_type_lb=new JLabel("File_type");
	
	JLabel File_size_lb=new JLabel("File_size");
	JLabel date_uploaded_lb=new JLabel("date_uploaded");

	JTextField Attachment_id_txf=new JTextField();
	JTextField File_name_txf=new JTextField();
	JTextField File_type_txf=new JTextField();
	JTextField File_size_txf=new JTextField();
	JTextField date_uploaded_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
    JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public AttachmentsForm() {
		createForm();
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         Attachments FORM            ");
		frame.setBounds(0, 0, 600, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
	}
	private void setLocationandSize() {
		Attachment_id_lb.setBounds(10, 10, 150, 30);
		File_name_lb.setBounds(10, 50, 150, 30);
		File_type_lb.setBounds(10, 90, 150, 30);
		File_size_lb.setBounds(10, 130, 150, 30);
		date_uploaded_lb.setBounds(10, 170, 150, 30);
		
		Attachment_id_txf.setBounds(160, 10, 200, 30);
		File_name_txf.setBounds(160, 50, 200, 30);
		File_type_txf.setBounds(160, 90, 200, 30);
		File_size_txf.setBounds(160, 130, 200, 30);
		date_uploaded_txf.setBounds(160,170 ,200 , 30);
		
		insert_btn.setBounds(10,290, 100, 30);
		Read_btn.setBounds(100,290, 100, 30);
		update_btn.setBounds(190,290, 100, 30);
		delete_btn.setBounds(280,290, 100, 30);
		table.setBounds(400, 10, 400, 300);
		setFontforall();	
		
	}
	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		Attachment_id_lb.setFont(font);
		File_name_lb.setFont(font);
		File_type_lb.setFont(font);
		File_size_lb.setFont(font);
		date_uploaded_lb.setFont(font);
		
		Attachment_id_txf.setFont(font);
		File_name_txf.setFont(font);
		File_type_txf.setFont(font);
		File_size_txf.setFont(font);
		date_uploaded_txf.setFont(font);

		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		
		addcomponentforFrame();
		
	}
	private void addcomponentforFrame() {
		frame.add(Attachment_id_lb);
		frame.add(File_name_lb);
		frame.add(File_type_lb);
		frame.add(File_size_lb);
		frame.add(date_uploaded_lb);
		frame.add(Attachment_id_txf);
		frame.add(File_name_txf);
		frame.add(File_type_txf);
		frame.add(File_size_txf);
		frame.add(date_uploaded_txf);
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add( table);
		ActionEvent();	
		
	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
			
		
	}
	public static void main(String[] args) {
		AttachmentsForm af=new AttachmentsForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Attachments a=new Attachments();
		if (e.getSource()==insert_btn) {
			a.setFile_name(File_name_txf.getText());
			a.setFile_type(File_type_txf.getText());
			a.setFile_size(File_size_txf.getText());
			a.setDate_uploaded(date_uploaded_txf.getText());
			
		
	}else if ((e.getSource()==Read_btn)) {
		 
		DefaultTableModel tableModel=a.populateTable();
		table.setModel(tableModel);
		
		}else if (e.getSource()==update_btn) {
		int Attachment_id=Integer.parseInt(Attachment_id_txf.getText());
		a.setFile_name(File_name_txf.getText());
		a.setFile_type(File_type_txf.getText());
		a.setFile_size(File_size_txf.getText());
		a.setDate_uploaded(date_uploaded_txf.getText());
		
		a.update(Attachment_id);
		}
		else {
			int Attachment_id=Integer.parseInt(Attachment_id_txf.getText());
			a.delete(Attachment_id);
		}
		
}}


