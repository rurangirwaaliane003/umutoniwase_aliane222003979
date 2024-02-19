package Myreservations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class reservations {
	private int reservationid;
	private String 	guestId ;
	private String roomId ;
	private String checkInDate;
	private String checkOutDate;
public reservations (int reservationid,String guestId,String roomId,String checkInDate,String checkOutDate) {
	super();
	this.reservationid= reservationid;
	this.guestId= guestId;
	this.roomId= roomId;
	this.checkInDate= checkInDate;
	this.checkOutDate=checkOutDate;
}
public reservations() {
	// TODO Auto-generated constructor stub
}
public int getReservationid() {
	return reservationid;
}
public void setReservationid(int reservationid) {
	this.reservationid = reservationid;
}
public String getGuestId() {
	return guestId;
}
public void setGuestId(String guestId) {
	this.guestId = guestId;
}
public String getRoomId() {
	return roomId;
}
public void setRoomId(String roomId) {
	this.roomId = roomId;
}
public String getCheckInDate() {
	return checkInDate;
}
public void setCheckInDate(String checkInDate) {
	this.checkInDate = checkInDate;
}
public String getCheckOutDate() {
	return checkOutDate;
}
public void setCheckOutDate(String checkOutDate) {
	this.checkOutDate = checkOutDate;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO reservations (guestId,roomId,checkInDate,checkOutDate) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
    	
       preparedStatement.setString(1, this.guestId);
       preparedStatement.setString(2, this.roomId);
       preparedStatement.setString(3, this.checkInDate);
       preparedStatement.setString(4, this.checkOutDate);
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

	        String sql = "SELECT * FROM reservations";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputreservationid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE reservations SET  guestId= ? ,roomId= ? ,checkInDate= ? ,checkOutDate= ?  WHERE reservationid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getGuestId());
          stm.setString(2, this.getRoomId());
          stm.setString(3, this.getCheckInDate());
          stm.setString(4, this.getCheckOutDate());
          
          
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(5, inputreservationid);
       
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
public void delete(int inputreservationid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM reservations WHERE  reservationsid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputreservationid); // Assuming there is a column named 'id' for the WHERE clause

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




