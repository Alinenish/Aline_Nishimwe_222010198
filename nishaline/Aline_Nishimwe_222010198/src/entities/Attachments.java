
package entities;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Attachments {
	private int Attachment_id;
	private String File_name;
	private String File_type;
	private String File_size;
	private String date_uploaded;
	
	public Attachments() {
		
	}

	public Attachments(int attachment_id, String file_name, String file_type, String file_size, String date_uploaded) {
		super();
		Attachment_id = attachment_id;
		File_name = file_name;
		File_type = file_type;
		File_size = file_size;
		this.date_uploaded = date_uploaded;
	}

	public int getAttachment_id() {
		return Attachment_id;
	}

	public void setAttachment_id(int attachment_id) {
		Attachment_id = attachment_id;
	}

	public String getFile_name() {
		return File_name;
	}

	public void setFile_name(String file_name) {
		File_name = file_name;
	}

	public String getFile_type() {
		return File_type;
	}

	public void setFile_type(String file_type) {
		File_type = file_type;
	}

	public String getFile_size() {
		return File_size;
	}

	public void setFile_size(String file_size) {
		File_size = file_size;
	}

	public String getDate_uploaded() {
		return date_uploaded;
	}

	public void setDate_uploaded(String date_uploaded) {
		this.date_uploaded = date_uploaded;
	}
	public void makeconnection() {
		 String host = "jdbc:mysql://localhost/ customer_feedback_management";
		    String user = "root";
		    String password = "";
		    
		    }
	public void insertData() {
		 String host = "jdbc:mysql://localhost/ customer_feedback_management";
		    String user = "root";
		    String password = "";
		    String sql="INSERT INTO attachments(File_name ,File_type ,File_size,date_uploaded)VALUES ( ?, ?, ?,?)";
		    try {
		    	 Connection con = DriverManager.getConnection(host, user, password);
		    	 PreparedStatement stm= con.prepareStatement(sql);
		    	 stm.setString(1, File_name);
		         stm.setString(2, File_type);
		         stm.setString(3, File_size);
		         stm.setString(4, date_uploaded);
		        
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
	     String query= "SELECT * FROM attachments";
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

	public void update(int attachment_id2) {
		String url = "jdbc:mysql://localhost:3306/customer_feedback_management";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE attachments SET  File_name= ?,File_type= ?,File_size= ?,date_uploaded=? WHERE Attachment_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getFile_name());
	          stm.setString(2, this.getFile_type());
	          stm.setString(3, this.getFile_size());
	          stm.setString(4, this.getDate_uploaded()); 
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, attachment_id2);
	       
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
	    

	public void delete(int attachment_id2) {
		
		String url = "jdbc:mysql://localhostt:3306/customer_feedback_management";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Attachments WHERE  Attachment_id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, attachment_id2); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

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
		
	}

	

