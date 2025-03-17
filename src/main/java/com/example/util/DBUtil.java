package com.example.util;

import java.sql.*;

public class DBUtil {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost/online_banking";
    private static final String USER = "root";
    private static final String PASSWORD = "root12345";

    // JDBC variables for opening, closing and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    // Update user's details in the database
    public static boolean updateUserDetails(String account, String name, String email, String userName, String mobile) {
        boolean success = false;
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Prepare an SQL update statement
            String updateQuery = "UPDATE users SET uname = ?, uemail = ?, username = ?, umobile = ? WHERE uaccount = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, mobile);
            preparedStatement.setString(5, account);
            
            // Execute the update statement
            int rowsUpdated = preparedStatement.executeUpdate();
            
            // Check if the update was successful
            if (rowsUpdated > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection and prepared statement
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }
    
    
    
 // Method to delete the user's profile from the database
    public static boolean deleteUserProfile(String account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean success = false;
        
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare the SQL statement
            String sql = "DELETE FROM users WHERE uaccount = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);

            // Execute the delete statement
            int rowsDeleted = preparedStatement.executeUpdate();

            // Check if the deletion was successful
            if (rowsDeleted > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the prepared statement and connection
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }
}

