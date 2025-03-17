package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/deletetransfer")
public class DeleteTransaction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String URL = "jdbc:mysql://localhost/online_banking";
        final String USER = "root";
        final String PASSWORD = "12345";
        
        // Get the transaction ID parameter from the request
        int tid = Integer.parseInt(request.getParameter("tid"));

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Establish a connection to the database
             con = DriverManager.getConnection(URL, USER, PASSWORD);
             
            // Prepare SQL statement to delete the transaction
            String deleteQuery = "DELETE FROM transaction WHERE TransactionID = ?";
            pstmt = con.prepareStatement(deleteQuery);
            pstmt.setInt(1, tid);

            
            // Execute the delete statement
            int rowsDeleted = pstmt.executeUpdate();
            
            // Check if the transaction was deleted successfully
            if (rowsDeleted > 0) {
                // Redirect to success page
                response.sendRedirect("pendingTransaction.jsp");
            } else {
                // Redirect to error page if no rows were deleted
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            // Close PreparedStatement and Connection
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
