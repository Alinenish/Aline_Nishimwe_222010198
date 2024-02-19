package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class manager {
	private int manager_id;
	private String username;
	private String password_hash;
	private String Email;
	private String Role;
	public manager() {}
	public manager(int manager_id, String username, String password_hash, String email, String role) {
		super();
		this.manager_id = manager_id;
		this.username = username;
		this.password_hash = password_hash;
		Email = email;
		Role = role;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword_hash() {
		return password_hash;
	}
	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {

		Email = email;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
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
				    String sql="INSERT INTO manager(Username,password_hash,Email,Role)VALUES ( ?, ?, ?,?)";
				    try {
				    	Connection con = DriverManager.getConnection(host, user, password);
				      	 PreparedStatement stm= con.prepareStatement(sql);
				      	 stm.setString(1, username);
				           stm.setString(2, password_hash);
				           stm.setString(3, Email);
				           stm.setString(4, Role);
				           
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
   String query= "SELECT * FROM manager";
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
public void update(int manager_id2) {
	 String url = "jdbc:mysql://localhost:3306/customer_feedback_management";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE manager SET  Username= ?,password_hash= ?, Email= ?,Role=? WHERE manager_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getUsername());
	          stm.setString(2, this.getPassword_hash());
	          stm.setString(3, this.getEmail());
	          stm.setString(4, this.getRole()); 
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, manager_id2);
	       
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

public void delete(int manager_id2) {
	String url = "jdbc:mysql://localhost:3306/customer_feedback_management";
	String user = "root";
	String password = "";

	// SQL query to delete data
	String sql = "DELETE FROM manager WHERE  manager_id = ?";{

	try (
	    
	    Connection con= DriverManager.getConnection(url, user, password);

	    
	    PreparedStatement ps= con.prepareStatement(sql);
	) {
	    
	    ps.setInt(1,manager_id2); // Assuming there is a column named 'id' for the WHERE clause

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

	
