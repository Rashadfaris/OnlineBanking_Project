package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.util.DBUtil;

public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Update session attributes with new values
        request.getSession().setAttribute("name", request.getParameter("name"));
        request.getSession().setAttribute("email", request.getParameter("email"));
        request.getSession().setAttribute("userName", request.getParameter("userName"));
        request.getSession().setAttribute("contact", request.getParameter("contact"));

        // Call the updateUserDetails method to update the database
        String account = (String) request.getSession().getAttribute("account");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String mobile = request.getParameter("contact");
        
        boolean updateSuccess = DBUtil.updateUserDetails(account, name, email, userName, mobile);
        if (!updateSuccess) {
            // Handle the case where the update was not successful
        }

        // Redirect back to viewProfile.jsp
        response.sendRedirect("viewProfile.jsp");
    }
}