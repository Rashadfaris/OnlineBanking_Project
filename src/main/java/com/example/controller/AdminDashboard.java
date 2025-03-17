package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.UserDetails;
import com.example.util.DBConnection;

@WebServlet("/adminDashboard")
public class AdminDashboard extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM users");
             ResultSet rs = pst.executeQuery()) {

            List<UserDetails> userList = new ArrayList<>();

            while (rs.next()) {
                String account = rs.getString("uaccount");
                String name = rs.getString("uname");
                String email = rs.getString("uemail");
                String username = rs.getString("username");
                String password = rs.getString("upwd");
                String mobile = rs.getString("umobile");

                UserDetails user = new UserDetails(account, name, email, username, password, mobile, null);
                userList.add(user);
            }

            request.setAttribute("userList", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}
