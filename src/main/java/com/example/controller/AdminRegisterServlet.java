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


import com.example.util.DBConnection;


@WebServlet("/adminreg")
public class AdminRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("aid");
        String aname = request.getParameter("adminName");
        String ausername = request.getParameter("auserName");
        String apassword = request.getParameter("aPassword");

        RequestDispatcher dispatcher = null;

        if (aname == null || aname.equals("") || ausername == null || ausername.equals("") || apassword == null || apassword.equals("")) {
            request.setAttribute("status", "invalidInput");
            dispatcher = request.getRequestDispatcher("adminReg.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO admin (id, aname, ausername, apassword) VALUES (?, ?, ?, ?)");
            
            pst.setString(1, id);
            pst.setString(2, aname);
            pst.setString(3, ausername);
            pst.setString(4, apassword);

            int rowCount = pst.executeUpdate();
            
            if (rowCount > 0) {
                request.setAttribute("status", "success");
                dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("status", "failure");
                dispatcher = request.getRequestDispatcher("adminReg.jsp");
                dispatcher.forward(request, response);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("status", "failure");
            dispatcher = request.getRequestDispatcher("adminReg.jsp");
            dispatcher.forward(request, response);
        }
    }
}
