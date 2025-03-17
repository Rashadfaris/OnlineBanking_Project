package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("aid");
		String apassword = request.getParameter("aPassword");
		
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher =null;
		
		if(id == null || id.equals("")) {
			request.setAttribute("status", "invalidID");
			dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.forward(request, response);

			
		}
		if(apassword == null || apassword.equals("")) {
			request.setAttribute("status", "invalidApassword");
			dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.forward(request, response);

			
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_banking?useSSL=false","root","root12345");
			PreparedStatement pst = con.prepareStatement("select * from admin where id = ? and apassword = ?");
			pst.setString(1, id);
			pst.setString(2, apassword);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				session.setAttribute("aid", rs.getString("id"));
				session.setAttribute("adminName", rs.getString("aname"));
				session.setAttribute("auserName", rs.getString("ausername"));
				session.setAttribute("aPassword", rs.getString("apassword"));
		
				
				dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
			}else {
				request.setAttribute("status","failed");
				dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
				
			}
			dispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
