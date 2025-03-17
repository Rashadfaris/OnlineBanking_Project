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

import com.example.model.Biller;
import com.example.util.DBConnection;

@WebServlet("/biller")
public class BillerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String uaccount = request.getParameter("baccount");
    	String BillerName = request.getParameter("bname");
        String BillerReference = request.getParameter("bref");
        String MobileNo = request.getParameter("bnumber");
        
     
        	try {
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement("INSERT INTO Biller (uaccount, BillerName, BillerReference, MobileNo) VALUES (?, ?, ?, ?)");


            
            pst.setString(1, uaccount);
            pst.setString(2, BillerName);
            pst.setString(3, BillerReference);
            pst.setString(4, MobileNo);

            int rowsInserted = pst.executeUpdate();
            
            if (rowsInserted > 0) {
                // Commit the transaction
            	 // Values inserted successfully, now fetch all transactions for this user
                List<Biller> biller = getBillerByUser(uaccount);
                // Store data in session
                HttpSession session = request.getSession();
                session.setAttribute("biller", biller);
               
                // Forward to savedbiller.jsp
                request.getRequestDispatcher("savedbiller.jsp");
            } else {
                response.getWriter().println("Failed to insert data into database.");
            }
        } catch (Exception e) {
            // Print stack trace or log the exception for troubleshooting
                e.printStackTrace();
            }
  
    	}



// Method to retrieve all transactions for a specific user
private List<Biller> getBillerByUser(String uaccount) {
    List<Biller> biller = new ArrayList<>();
    
    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM Biller WHERE uaccount = ?");
        pst.setString(1, uaccount);
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            int bid = rs.getInt("BillerID");
            String account = rs.getString("uaccount");
            String bname = rs.getString("BillerName");
            String breference = rs.getString("BillerReference");
            String bmobile = rs.getString("MobileNo");
         
           
            
            
         
            
            // Create Transfer object for each transaction
            Biller biller1 = new Biller( bid,bname,breference,bmobile, account);
            
            // Add transaction to list
            biller.add(biller1);
        }
        
        rs.close();
        pst.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return biller;
}
}