package Myrooms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class rooms {
	private int roomId ;
	private String 	hotelID ;
	private String roomNumber ;
	private String roomType;
	private String price;
public rooms (int roomId,String hotelID,String roomNumber,String roomType,String price) {
	super();
	this.roomId= roomId;
	this.hotelID= hotelID;
	this.roomNumber= roomNumber;
	this.roomType= roomType;
	this.price=price;
}
public rooms() {
	// TODO Auto-generated constructor stub
}
public int getRoomId() {
	return roomId;
}
public void setRoomId(int roomId) {
	this.roomId = roomId;
}
public String getHotelID() {
	return hotelID;
}
public void setHotelID(String hotelID) {
	this.hotelID = hotelID;
}
public String getRoomNumber() {
	return roomNumber;
}
public void setRoomNumber(String roomNumber) {
	this.roomNumber = roomNumber;
}
public String getRoomType() {
	return roomType;
}
public void setRoomType(String roomType) {
	this.roomType = roomType;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO rooms (hotelID, roomNumber,roomType,price) VALUES (?,?,?,?)";
  
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
    	
       preparedStatement.setString(1, this.hotelID);
       preparedStatement.setString(2, this.roomNumber);
       preparedStatement.setString(3, this.roomType);
       preparedStatement.setString(4, this.price);
      

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

	        String sql = "SELECT * FROM rooms";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputroomId) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE rooms SET  hotelID= ? ,roomNumber= ? ,roomType= ? ,price= ?   WHERE roomId = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stn = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
    	stn.setString(1, this.hotelID);
    	stn.setString(2, this.roomNumber);
    	stn.setString(3, this.roomType);
    	stn.setString(4, this.price);
          
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
    	stn.setInt(5,inputroomId );
       
        // Execute the update
        int rowsAffected = stn.executeUpdate();

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
public void delete(int inputroomId) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM rooms WHERE  room_id =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputroomId); // Assuming there is a column named 'id' for the WHERE clause

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





