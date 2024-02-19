package Myhotels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class hotels {
	private int hotelID;
	private String hotelName;
	private String location;
	private String password;
	private String emailId;
public hotels (int hotelID,String hotelName,String location,String password,String emailLd) {
	super();
	this.hotelID= hotelID;
	this.hotelName= hotelName;
	this.location= location;
	this.password= password;
	this.emailId= emailId;
}
public hotels() {
	// TODO Auto-generated constructor stub
}
public int getHotelID() {
	return hotelID;
}
public void setHotelID(int hotelID) {
	this.hotelID = hotelID;
}
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmailld() {
	return emailId;
}
public void setEmailld(String emailld) {
	this.emailId = emailId;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO hotels ( hotelName,location, password,emailId) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
    	
       preparedStatement.setString(1, this.hotelName);
       preparedStatement.setString(2, this.location);
       preparedStatement.setString(3, this.password);
       preparedStatement.setString(4, this.emailId);
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

	        String sql = "SELECT * FROM hotels";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputhotelID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE hotels SET  hotelName=? , location=? , password=? ,emailId=?  WHERE hotelID = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getHotelName());
          stm.setString(2, this.getLocation());
          stm.setString(3, this.getPassword());
          stm.setString(4, this.getEmailld());
          
          
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(5, inputhotelID);
       
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
public void delete(int inputhotelID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM hotels WHERE  hotelID=?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputhotelID); // Assuming there is a column named 'id' for the WHERE clause

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



