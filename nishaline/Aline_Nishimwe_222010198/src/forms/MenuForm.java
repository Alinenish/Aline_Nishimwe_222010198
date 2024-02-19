package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import entities.Attachments;
import forms.AttachmentsForm;

public class MenuForm implements ActionListener{
	JFrame frame;
	JMenu home,  attachments, manager, feedback, services,  more;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,AttachmentsDelete,AttachmentsUpdate,AttachmentsRead;
	JMenuItem managerDelete,managerUpdate,managerRead;
	JMenuItem feedbackDelete,feedbackUpdate,feedbackRead;
	JMenuItem servicesDelete,servicesUpdate,servicesRead;
	

	MenuForm(){
		createWindow();
	}
	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		attachments= new JMenu("Attachments");
		manager= new JMenu("manager");
		feedback = new JMenu("feedback");
		services=new JMenu("services");
		

		more = new JMenu("More");
		i1 = new JMenuItem("Insert");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		AttachmentsRead = new JMenuItem("Read");
		AttachmentsUpdate = new JMenuItem("Update");
		AttachmentsDelete = new JMenuItem("Delete");
	attachments.add(AttachmentsRead);
		attachments.add(AttachmentsUpdate);
		attachments.add(AttachmentsDelete);

		managerRead =new JMenuItem("Read");
		managerUpdate =new JMenuItem("Update");
		managerDelete =new JMenuItem("Delete");
		
		manager.add(managerRead);
		manager.add(managerUpdate);
		manager.add(managerDelete);
		
		feedbackRead =new JMenuItem("Read");
		feedbackUpdate =new JMenuItem("Update");
		feedbackDelete =new JMenuItem("Delete");
		feedback.add(feedbackRead);
		feedback.add(feedbackUpdate);
		feedback.add(feedbackDelete);
		
		servicesRead =new JMenuItem("Read");
		servicesUpdate =new JMenuItem("Update");
		servicesDelete =new JMenuItem("Delete");
		services.add(servicesRead);
		services.add(servicesUpdate);
		services.add(servicesDelete);
		

		mb.add(home);
		mb.add(attachments);
		mb.add(manager);
		mb.add(feedback);
		mb.add(services);
		frame.setJMenuBar(mb);// Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentsOnFrame();

	}
	private void componentsOnFrame() {
		home = new JMenu("Home");
		attachments = new JMenu("Attachments");
		manager = new JMenu("manager");
		feedback =new JMenu("feedback");
		services =new JMenu("services");
		
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		attachments.add(i2);
		attachments.add(i3);
		attachments.add(i4);
		manager.add(i2);
		manager.add(i3);
		manager.add(i4);
		feedback.add(i2);
		feedback.add(i3);
		feedback.add(i4);
		services.add(i2);
		services.add(i3);
		services.add(i4);
		addactionEvent();

		
		
	}
	private void addactionEvent() {
		AttachmentsRead.addActionListener(this);
		managerRead.addActionListener(this);
		feedbackRead.addActionListener(this);
		servicesRead.addActionListener(this);
			
	}
	public static void main(String[] args) {
		new MenuForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==AttachmentsRead) {
			AttachmentsForm af=new AttachmentsForm();
			frame.dispose();
		}else if (e.getSource()==managerRead) {
			managerForm mf=new managerForm();
			frame.dispose();
		}else if (e.getSource()==feedbackRead) {
			feedbackForm nf=new feedbackForm();
			frame.dispose();
		}else if (e.getSource()==servicesRead) {
			servicesForm cf=new servicesForm();
			frame.dispose();
			}
	}

}
	
		
