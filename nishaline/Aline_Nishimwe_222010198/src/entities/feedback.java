package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class feedback {
	private int feedback_id;
	private String Reply;
	private String feedback_text;
	private String replymanager;
	public feedback() {}
	public feedback(int feedback_id, String reply, String feedback_text, String replymanager) {
		super();
		this.feedback_id = feedback_id;
		this.Reply = reply;
		this.feedback_text = feedback_text;
		this.replymanager = replymanager;
	}
	public int getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public String getReply() {
		return Reply;
	}
	public void setReply(String reply) {
		Reply = reply;
	}
	public String getFeedback_text() {
		return feedback_text;
	}
	public void setFeedback_text(String feedback_text) {
		this.feedback_text = feedback_text;
	}
	public String getReplymanager() {
		return replymanager;
	}
	public void setReplymanager(String replymanager) {
		this.replymanager = replymanager;
	}
	public void makeconnection() {
		 String host = "jdbc:mysql://localhost/ customer_feedback_management";
		    String user = "root";
		    String password = "";
		    }
	public void insertData() {
		// TODO Auto-generated method stub
		
	
	

		String host = "jdbc:mysql://localhost/ customer_feedback_management";
	    String user = "root";
	    String password = "";
	    String sql="INSERT INTO feedback(Reply,feedback_text,replymanager)VALUES (?, ?,?)";

	    try {
	    	Connection con = DriverManager.getConnection(host, user, password);
	    	 PreparedStatement stm= con.prepareStatement(sql);
	    	 stm.setString(1, Reply);
	         stm.setString(2, feedback_text);
	         stm.setString(3, replymanager);
	        
	         int rowsAffected = stm.executeUpdate();
	         if (rowsAffected > 0) {
	        	 System.out.println("Data inserted successfully!");
	             JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	         } else {
                 System.out.println("Failed to insert data.");
                 JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);
                 }
		} catch (Exception e) {
			// TODO: handle exception
		}
}
	         
	    
public DefaultTableModel populateTable() {
	 String host = "jdbc:mysql://localhost/customer_feedback_management";
  String user = "root";
  String password = "";
  String query= "SELECT * FROM feedback";
  DefaultTableModel tableModel = null;

  try {
      Connection con = DriverManager.getConnection(host, user, password);
      PreparedStatement stm = con.prepareStatement(query);
      ResultSet resultSet = stm.executeQuery();

      int columnCount = resultSet.getMetaData().getColumnCount();
      Vector<String> columnNames = new Vector<>();
      for (int i = 1; i <= columnCount; i++) {
          columnNames.add(resultSet.getMetaData().getColumnName(i));
      }

      Vector<Vector<Object>> data = new Vector<>();
      while (resultSet.next()) {
          Vector<Object> row = new Vector<>();
          for (int i = 1; i <= columnCount; i++) {
              row.add(resultSet.getObject(i));
          }
          data.add(row);
      }

      tableModel = new DefaultTableModel(data, columnNames);
      con.close(); // Close the connection when done to release resources
  } catch (Exception e) {
      e.printStackTrace(); // Print the exception details for debugging purposes
  }
  return tableModel;
}

  public void update(int feedback_id2) {	
	 
			 String url = "jdbc:mysql://localhost:3306/customer_feedback_management";
			    String user = "root";
			    String password = "";

			    // SQL query to update data
			    String sql = "UPDATE feedback SET  Reply= ?,feedback_text= ?, replymanager= ? WHERE feedback_id = ?";

			    try (
			        // Establish the con
			        Connection con = DriverManager.getConnection(url, user, password);

			        // Create a prepared statement
			        PreparedStatement stm = con.prepareStatement(sql);
			    ) {
			        // Set the new values for the update
			    	  stm.setString(1, this.getReply());
			          stm.setString(2, this.getFeedback_text());
			          stm.setString(3, this.getReplymanager()); 
			          // Assuming there is a column named 'id' for the WHERE clause
			       
			          stm.setInt(4, feedback_id2);
			       
			        // Execute the update
			        int rowsAffected = stm.executeUpdate();

			        // Check the result
			        if (rowsAffected > 0) {
			            System.out.println("Data updated successfully!");
			            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
			        } else {
			            System.out.println("Failed to update data. No matching record found.");
			            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }   
				
}
public void delete(int feedback_id2) {
	String url = "jdbc:mysql://localhost:3306/customer_feedback_management";
	String user = "root";
	String password = "";

	// SQL query to delete data
	String sql = "DELETE FROM feedback WHERE  feedback_id = ?";{

	try (
	    
	    Connection con= DriverManager.getConnection(url, user, password);

	    
	    PreparedStatement ps= con.prepareStatement(sql);
	) {
	    
	    ps.setInt(1,feedback_id2); // Assuming there is a column named 'id' for the WHERE clause

	    // Execute the delete
	    int rowsAffected = ps.executeUpdate();

	    // Check the result
	    if (rowsAffected > 0) {
	        System.out.println("Data deleted successfully!");
	        JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        System.out.println("Failed to delete data. No matching record found.");
	        JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	}
	// TODO Auto-generated method stub
	
}

}
	   
	
	
	
	
	
	

