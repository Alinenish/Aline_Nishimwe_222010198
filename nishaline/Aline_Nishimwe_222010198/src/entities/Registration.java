package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Registration {
	private int customer_id;
	private String Password;
	private String NAME;
	private String COUNTRY;
	private String DISTRICT;
	private String AGE;
	private String GENDER;
	private String Email;
	public Registration() {}
public Registration(Integer customer_id,String password, String NAME, String COUNTRY, String DISTRICT, String AGE, String GENDER,
			String Email) {
		super();
		this.customer_id= customer_id;
	this.Password = password;
	this.NAME = NAME;
	this.COUNTRY = COUNTRY;
	this.DISTRICT = DISTRICT;
	this.AGE = AGE;
	this.GENDER = GENDER;
	this.Email = Email;
	}

public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer) {
	this.customer_id = customer;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getNAME() {
	return NAME;
}
public void setNAME(String nAME) {
	NAME = nAME;
}
public String getCOUNTRY() {
	return COUNTRY;
}
public void setCOUNTRY(String cOUNTRY) {
	COUNTRY = cOUNTRY;
}
public String getDISTRICT() {
	return DISTRICT;
}
public void setDISTRICT(String dISTRICT) {
	DISTRICT = dISTRICT;
}
public String getAGE() {
	return AGE;
}
public void setAGE(String aGE) {
	AGE = aGE;
}
public String getGENDER() {
	return GENDER;
}
public void setGENDER(String gENDER) {
	GENDER = gENDER;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public void insertData() {
	String host = "jdbc:mysql://localhost/customer_feedback_management";
	String user = "root";
	String password = "";
	String sql = "INSERT INTO Customer (customer_id,NAME, COUNTRY, DISTRICT, AGE, GENDER, password, Email) VALUES (?,?, ?, ?, ?, ?, ?, ?)";

	String sqlQuery = "SELECT name FROM customer";
	
	try (Connection con = DriverManager.getConnection(host, user, password);
			PreparedStatement pstmCheck = con.prepareStatement(sqlQuery);
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet resultSet = pstmCheck.executeQuery()) {

		ArrayList<String> existingUsernames = new ArrayList<>();
		
		while (resultSet.next()) {
			String existingUsername = resultSet.getString("NAME");
			existingUsernames.add(existingUsername);
}
		
		// Check if the entered username already exists
					if (existingUsernames.contains(this.NAME)) {
						System.out.println("The username you entered is already in use.");
						
					} else {
						pstm.setInt(1,this.customer_id);
						pstm.setString(2, this.NAME);
						pstm.setString(3, this.COUNTRY);
						pstm.setString(4, this.DISTRICT);
						pstm.setString(5, this.AGE);
						pstm.setString(6, this.GENDER);
						pstm.setString(7, this.Password);
						pstm.setString(8 , this.Email);
						

						int rowsAffected = pstm.executeUpdate();

						if (rowsAffected > 0) {
							JOptionPane.showMessageDialog(null, "Data inserted successfully!");
						} else {
							JOptionPane.showMessageDialog(null, "Failed to insert data.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
}
	
}

	
	
	
	
	


