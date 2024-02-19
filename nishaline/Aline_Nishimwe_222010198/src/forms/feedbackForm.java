package forms;

import java.awt.Color;
import java.awt.Component;
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

import entities.feedback;

public class feedbackForm implements ActionListener {

	JFrame frame;
	JLabel feedback_id_lb=new JLabel("feedback_Id");
	JLabel Reply_lb=new JLabel("Reply");
	JLabel feedback_text_lb=new JLabel("feedback_text");
	JLabel replymanager_lb=new JLabel("replymanager");
	

	JTextField feedback_id_txf=new JTextField();
	JTextField Reply_txf=new JTextField();
	JTextField feedback_text_txf=new JTextField();
	JTextField replymanager_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public feedbackForm() {
		createForm();
	}
		
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         Feedback FORM           ");
		frame.setBounds(30, 20, 600, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
		
	}

	private void setLocationandSize() {
		feedback_id_lb.setBounds(10, 10, 150, 30);
		Reply_lb.setBounds(10, 50, 150, 30);
		feedback_text_lb.setBounds(10, 90, 150, 30);
		replymanager_lb.setBounds(10, 130, 150, 30);
		
		feedback_id_txf.setBounds(160, 10, 200, 30);
		Reply_txf.setBounds(160, 50, 200, 30);
		feedback_text_txf.setBounds(160, 90, 200, 30);
		replymanager_txf.setBounds(160, 130, 200, 30);
	
		insert_btn.setBounds(10,290, 100, 30);
		Read_btn.setBounds(100,290, 100, 30);
		update_btn.setBounds(190,290, 100, 30);
		delete_btn.setBounds(280,290, 100, 30);
		table.setBounds(400, 10, 400, 300);
		setFontforall();	
		
		
		
	}

	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		feedback_id_lb.setFont(font);
		Reply_lb.setFont(font);
		feedback_text_lb.setFont(font);
		replymanager_lb.setFont(font);
		
		
		feedback_id_txf.setFont(font);
		Reply_txf.setFont(font);
		feedback_text_txf.setFont(font);
		replymanager_txf.setFont(font);
		

		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		// TODO Auto-generated method stub
		
	}

	private void addcomponentforFrame() {
		frame.add(feedback_id_lb);
		frame.add(Reply_lb);
		frame.add(feedback_text_lb);
		frame.add(replymanager_lb);
		
		frame.add(feedback_id_txf);
		frame.add(Reply_txf);
		frame.add(feedback_text_txf);
		frame.add(replymanager_txf);
		
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
		feedbackForm ff= new feedbackForm();
		
	}
	public void actionPerformed(ActionEvent e) {
   feedback f=new feedback();
		if(e.getSource() == insert_btn) {
			
			f.setReply(replymanager_txf.getText());
			f.setFeedback_text(feedback_id_txf.getName());
			f.setReplymanager(replymanager_txf.getName());
			f.insertData();
		}
	
	
else if ((e.getSource()==Read_btn)) {
	DefaultTableModel tableModel=f.populateTable();
	table.setModel(tableModel);
}
else if (e.getSource()==update_btn) {
	int feedback_id=Integer.parseInt(feedback_id_txf.getText());
	f.setReply(Reply_txf.getText());
	f.setFeedback_text(feedback_text_txf.getText());
	f.setReplymanager(replymanager_txf.getText());
	
	f.update(feedback_id);
}
	else {
		int feedback_id=Integer.parseInt(feedback_id_txf.getText());
		f.delete(feedback_id);
	}
	 } 
	    }


