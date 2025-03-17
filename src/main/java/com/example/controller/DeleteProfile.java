package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.util.DBUtil;


@WebServlet("/DeleteProfile")
public class DeleteProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the account number of the user to be deleted
        String account = (String) request.getSession().getAttribute("account");

        // Call the deleteUserProfile method to delete the user's profile from the database
        boolean deleteSuccess = DBUtil.deleteUserProfile(account);
        if (!deleteSuccess) {
            // Handle the case where the deletion was not successful
        }

        // Invalidate the session to log the user out
        request.getSession().invalidate();

        // Redirect to a page indicating successful deletion or back to the login page
        response.sendRedirect("login.jsp");
    }
}