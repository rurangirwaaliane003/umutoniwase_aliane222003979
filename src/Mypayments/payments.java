package Mypayments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class payments {
	private int paymentid;
	private String reservationid;
	private String amount;
	private String paymentdate;
public payments (int paymentid,String reservationid,String amount,String paymentdate) {
	super();
	this.paymentid= paymentid;
	this.reservationid= reservationid;
	this.amount= amount;
	this.paymentdate= paymentdate;
	
}
public payments() {
	// TODO Auto-generated constructor stub
}
public int getPaymentid() {
	return paymentid;
}
public void setPaymentid(int paymentid) {
	this.paymentid = paymentid;
}
public String getReservationid() {
	return reservationid;
}
public void setReservationid(String reservationid) {
	this.reservationid = reservationid;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amout) {
	this.amount = amout;
}
public String getPaymentdate() {
	return paymentdate;
}
public void setPaymentdate(String paymentdate) {
	this.paymentdate = paymentdate;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO payments ( reservationid,amount, paymentdate) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
    	
       preparedStatement.setString(1, this.reservationid);
       preparedStatement.setString(2, this.amount);
       preparedStatement.setString(3, this.paymentdate);

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

	        String sql = "SELECT * FROM payments";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputpaymentid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE payments SET  reservationid=? ,amount=? ,paymentdate=?   WHERE paymentid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getReservationid());
          stm.setString(2, this.getAmount());
          stm.setString(3, this.getPaymentdate());
          
          
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4, inputpaymentid);
       
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
public void delete(int inputpaymentid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/umutoniwasea_222003979";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM payments WHERE  paymentid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputpaymentid); // Assuming there is a column named 'id' for the WHERE clause

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




