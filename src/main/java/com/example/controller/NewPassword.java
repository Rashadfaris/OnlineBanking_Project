package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.example.util.DBConnection;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        String email = (String) session.getAttribute("email");
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");

        if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement pst = con.prepareStatement("UPDATE users SET upwd = ? WHERE uemail = ?")) {

                pst.setString(1, newPassword);
                pst.setString(2, email);
                int rowCount = pst.executeUpdate();

                if (rowCount > 0) {
                    request.setAttribute("status", "resetSuccess");
                } else {
                    request.setAttribute("status", "resetFailed");
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("status", "resetFailed");
            }
        } else {
            request.setAttribute("status", "invalidInput");
        }

        dispatcher.forward(request, response);
    }
}