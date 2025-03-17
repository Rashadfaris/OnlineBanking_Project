<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*, com.example.util.DBConnection, com.example.model.UserDetails" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            font-family: Arial, sans-serif; /* Change font style */
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 8px;
            font-family: Arial, sans-serif; /* Change font style */
        }
        h1 {
            text-align: center;
            color: #333;
            font-size: 28px;
            margin-top: 20px;
            font-family: Arial, sans-serif; /* Change font style */
        }

    </style>
</head>
<body>
    <h1>Welcome to the Admin Dashboard</h1>
    
    <table>
        <thead>
            <tr>
                <th>User Account</th>
                <th>User Name</th>
                <th>User Email</th>
                <th>User Username</th>
                <th>User Mobile</th>
            </tr>
        </thead>
        <tbody>
            <% 
            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM users");
                ResultSet rs = pst.executeQuery();
                while(rs.next()) {
            %>
            <tr>
                <td><%= rs.getString("uaccount") %></td>
                <td><%= rs.getString("uname") %></td>
                <td><%= rs.getString("uemail") %></td>
                <td><%= rs.getString("username") %></td>
                <td><%= rs.getString("umobile") %></td>
            </tr>
            <% 
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </tbody>
    </table>
    
     <button class="button back-button" onclick="location.href='AdminLogin.jsp'">Back to login</button>
</body>
</html>
