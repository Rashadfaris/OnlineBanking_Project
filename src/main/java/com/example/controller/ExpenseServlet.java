package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Expense;
import com.example.util.DBConnection;

@WebServlet("/expense")
public class ExpenseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uaccount = request.getParameter("account");
        String Type = request.getParameter("type");
        String ItemName = request.getParameter("item");
        double Amount = Double.parseDouble(request.getParameter("amount"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO expenses (uaccount, Type, ItemName, Amount) VALUES (?, ?, ?, ?)");

            pst.setString(1, uaccount);
            pst.setString(2, Type);
            pst.setString(3, ItemName);
            pst.setDouble(4, Amount);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                // Values inserted successfully, now fetch all transactions for this user
                List<Expense> expense = getExpenseByUser(uaccount);
                // Store data in session
                HttpSession session = request.getSession();
                session.setAttribute("expense", expense);

                // Forward to saveExpense.jsp
                request.getRequestDispatcher("savedExpense.jsp").forward(request, response); // Forward the request and response objects
            } else {
                response.getWriter().println("Failed to insert data into database.");
            }
            } catch (Exception e) {
            // Print stack trace or log the exception for troubleshooting
            e.printStackTrace();
        }
    }


    // Method to retrieve all transactions for a specific user
    private List<Expense> getExpenseByUser(String uaccount) {
        List<Expense> expense = new ArrayList<>();
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM expenses WHERE uaccount = ?");
            pst.setString(1, uaccount);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("eid");
                String eaccount = rs.getString("uaccount");
                String type = rs.getString("Type");
                String itemname = rs.getString("ItemName");
                double amount = rs.getDouble("Amount");

                // Create Expense object for each transaction
                Expense expense1 = new Expense(id, eaccount, type, itemname, amount);

                // Add transaction to list
                expense.add(expense1);
            }
            
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return expense;
    }
}
