package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class services {
private int service_id;
private String date;
private String duration;
private String type_of_service;
private String availability;
public services() {}
public services(int service_id, String date, String duration, String type_of_service, String availability) {
	super();
	this.service_id = service_id;
	this.date = date;
	this.duration = duration;
	this.type_of_service = type_of_service;
	this.availability = availability;
}
public int getService_id() {
	return service_id;
}
public void setService_id(int service_id) {
	this.service_id = service_id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public String getType_of_service() {
	return type_of_service;
}
public void setType_of_service(String type_of_service) {
	this.type_of_service = type_of_service;
}
public String getAvailability() {
	return availability;
}
public void setAvailability(String availability) {
	this.availability = availability;
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
	    String sql="INSERT INTO services( data,duration,type_of_service,availability)VALUES ( ?, ?, ?,?)";
	    try {

Connection con = DriverManager.getConnection(host,user,password);
	 PreparedStatement stm= con.prepareStatement(sql);
	 stm.setString(1,date);
  stm.setString(2, duration);
  stm.setString(3,type_of_service);
  stm.setString(4,availability);
        
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
    String query= "SELECT * FROM services";
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
public void update(int service_id2) {
	 String url = "jdbc:mysql://localhost:3306/customer_feedback_management";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE services SET  date= ?,duration= ?, type_of_service= ?,availability=? WHERE service_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getDate());
	          stm.setString(2, this.getDuration());
	          stm.setString(3, this.getType_of_service());
	          stm.setString(4, this.getAvailability()); 
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, 23);
	       
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
public void delete(int service_id2) {
	String url = "jdbc:mysql://localhost:3306/customer_feedback_management";
	String user = "root";
	String password = "";

	// SQL query to delete data
	String sql = "DELETE FROM services WHERE  service_id = ?";{

	try (
	    
	    Connection con= DriverManager.getConnection(url, user, password);

	    
	    PreparedStatement ps= con.prepareStatement(sql);
	) {
	    
	    ps.setInt(1,service_id2); // Assuming there is a column named 'id' for the WHERE clause

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
}
	
	// TODO Auto-generated method stub
	
}
	// TODO Auto-generated method stub
	
