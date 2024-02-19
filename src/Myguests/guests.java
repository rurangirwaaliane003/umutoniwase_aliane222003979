package Myguests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class guests {
	private int guestId;
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private String password;
public guests (int guestId,String firstname,String lastname,String email,String phonenumber,String password) {
	super();
	this.guestId= guestId;
	this.firstname= firstname;
	this.lastname= lastname;
	this.email= email;
	this.phonenumber= phonenumber;
	this.password=  password;
}
public guests() {
	// TODO Auto-generated constructor stub
}
public int getGuestId() {
	return guestId;
}
public void setGuestId(int guestId) {
	this.guestId = guestId;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO guests ( firstname,lastname, email,phonenumber,password) VALUES (?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
    	
       preparedStatement.setString(1, this.firstname);
       preparedStatement.setString(2, this.lastname);
       preparedStatement.setString(3, this.email);
       preparedStatement.setString(4, this.phonenumber);
       preparedStatement.setString(5, this.password);
       //preparedStatement.setString(6, this.gender);
       
          
        
        // Execute the query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data insert successfully!");
            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }}
 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/umutoniwasea_222003979";
	        String user = "root";
	        String password = "";

	        String sql = "SELECT * FROM guests";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputguestId) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE guests SET  firstname=?,lastname=? ,email=? ,phonenumber=? ,password=? WHERE guestId = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getFirstname());
          stm.setString(2, this.getLastname());
          stm.setString(3, this.getEmail());
          stm.setString(4, this.getPhonenumber());
          stm.setString(5, this.getPassword());
          
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(6, inputguestId);
       
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
public void delete(int inputguestId) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM guests WHERE  guestId  =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputguestId); // Assuming there is a column named 'id' for the WHERE clause

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


