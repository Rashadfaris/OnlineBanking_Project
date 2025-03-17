package com.example.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Transfer;
import com.example.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transfer")
public class transferServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uaccount = request.getParameter("accountj");
        String RecieverAccountNo = request.getParameter("recipientj");
        String RecieverAccountName = request.getParameter("recipientnamej");
        String Purpose = request.getParameter("purposej");
        double Amount = Double.parseDouble(request.getParameter("amountj"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO transaction (uaccount, RecieverAccountNo, RecieverAccountName, Purpose, Amount) VALUES (?, ?, ?, ?, ?)");

            // Set parameters directly from request parameters
            pst.setString(1, uaccount);
            pst.setString(2, RecieverAccountNo);
            pst.setString(3, RecieverAccountName);
            pst.setString(4, Purpose);
            pst.setDouble(5, Amount);

            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                // Values inserted successfully, now fetch all transactions for this user
                List<Transfer> transactions = getTransactionsByUser(uaccount);
                
                // Store transactions in session
                HttpSession session = request.getSession();
                session.setAttribute("transactions", transactions);
                
                // Redirect to pending.jsp
                response.sendRedirect("pendingTransaction.jsp");
            } else {
                // Failed
                // Handle failure scenario
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Method to retrieve all transactions for a specific user
    private List<Transfer> getTransactionsByUser(String uaccount) {
        List<Transfer> transactions = new ArrayList<>();
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM transaction WHERE uaccount = ?");
            pst.setString(1, uaccount);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                int tid = rs.getInt("TransactionID");
                String account = rs.getString("uaccount");
                String recAccountNo = rs.getString("RecieverAccountNo");
                String recAccountName = rs.getString("RecieverAccountName");
                String purpose = rs.getString("Purpose");
                double amount = rs.getDouble("Amount");
                
                // Create Transfer object for each transaction
                Transfer transaction = new Transfer(tid, account, recAccountNo, recAccountName, purpose, amount);
                
                // Add transaction to list
                transactions.add(transaction);
            }
            
            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return transactions;
    }
}
