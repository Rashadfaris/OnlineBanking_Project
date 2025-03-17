package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.example.model.Transfer;

public class TransferDBUtil {

	// JDBC URL, username, and password of MySQL server
	private static final String URL = "jdbc:mysql://localhost/online_banking";
    private static final String USER = "root";
    private static final String PASSWORD = "root12345";
    		
    // JDBC variables for opening, closing and managing connection
    private static Connection con;
    private static PreparedStatement preparedStatement;

    // Update user's details in the database
    public static boolean editTransaction(int tid, String purpose, double amount) {
        boolean success = false;
        Connection con =null;
        PreparedStatement preparedStatement = null;
        
        try {
            // Establish a connection to the database
            con = DriverManager.getConnection(URL, USER, PASSWORD);
          
            // Prepare an SQL update statement
            String updateQuery = "UPDATE transaction SET Purpose = ?, Amount = ? WHERE TransactionID = ?";
            preparedStatement = con.prepareStatement(updateQuery);
            preparedStatement.setString(1, purpose);
            preparedStatement.setDouble(2, amount);
            preparedStatement.setInt(3, tid);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }
    
    
    
 // Method to delete the user's profile from the database
 // Method to delete a transaction from the database
    public static boolean deleteTransaction(int tid) {
    	boolean success = false;
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            String deleteQuery = "DELETE FROM transaction WHERE TransactionID = ?";
            preparedStatement = con.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, tid);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                success = true;
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
		return success;     
		}
}