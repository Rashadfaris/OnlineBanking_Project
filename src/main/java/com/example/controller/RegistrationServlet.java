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

import com.example.dao.UserListManager;
import com.example.model.UserDetails;
import com.example.util.DBConnection;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uaccount = request.getParameter("account");//db name uname | jsp name("name")
    	String uname = request.getParameter("name");//db name uname | jsp name("name")
        String uemail = request.getParameter("email");//db name uname | jsp name("name")
        String username = request.getParameter("userName");//db name uname | jsp name("name")
        String upwd = request.getParameter("pass");//db name uname | jsp name("name")
        String Reupwd = request.getParameter("re_pass");//db name uname | jsp name("name")
        String umobile = request.getParameter("contact");
        
        
        
        

        RequestDispatcher dispatcher = null; //this part is not wanted
        
        if (uaccount == null || uaccount.equals("")) {
            request.setAttribute("status", "invalidAccountNumber");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (uname == null || uname.equals("")) {
            request.setAttribute("status", "invalidName");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (uemail == null || uemail.equals("")) {
            request.setAttribute("status", "invalidEmail");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (username == null || username.equals("")) {
            request.setAttribute("status", "invalidUserName");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (upwd == null || upwd.equals("")) {
            request.setAttribute("status", "invalidUpwd");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
            return;
        } else if (!upwd.equals(Reupwd)) {
            request.setAttribute("status", "invalidConfirmPassword");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (umobile == null || umobile.equals("")) {
            request.setAttribute("status", "invalidMobile");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
            return;
        } else if (umobile.length() > 10) {
            request.setAttribute("status", "InvalidMobileLength");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
            return;
        }

		    UserDetails newUser = new UserDetails(uaccount, uname, uemail, username, upwd, Reupwd, umobile);// this is UserDetails part
		    UserListManager.addUser(newUser);
		
		    dispatcher = request.getRequestDispatcher("registration.jsp");
		    request.setAttribute("status", "success");
		    dispatcher.forward(request, response);
   
        // Inside doPost method of RegistrationServlet.java
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into users(uaccount, uname, uemail, username, upwd, umobile) values(?,?,?,?,?,?)");//db names

            for (UserDetails user : UserListManager.getUserList()) {
            	pst.setString(1, user.getAcoount());
            	pst.setString(2, user.getName());//UserDetails get()
            	pst.setString(3, user.getEmail());//UserDetails get()
            	pst.setString(4, user.getUsername());
                pst.setString(5, user.getPassword());//UserDetails get()
                pst.setString(6, user.getMobile());//UserDetails get()

                int rowCount = pst.executeUpdate();

                if (rowCount > 0) {
                    // Success
                } else {
                    // Failed
                }
            }

            dispatcher = request.getRequestDispatcher("home.jsp");
            request.setAttribute("status", "success");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
}
