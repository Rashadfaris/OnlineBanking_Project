<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Expense" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Expenses</title>
    <!-- Add your CSS styles here -->
</head>
<body>
    <h1>View Expenses</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Expense ID</th>
                 <th>Account Number</th>
                <th>Type</th>
                <th>Item Name</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over the list of transactions --%>
            <c:forEach var="expense1" items="${expense}">
            
        <%
            int Id = (int) session.getAttribute("Id");
           	String uaccount = (String) session.getAttribute("uaccount");
            String Type = (String) session.getAttribute("Type");
            String ItemName = (String) session.getAttribute("ItemName");
            Double Amount = (Double) session.getAttribute("Amount"); // Note the change from double to Double
        %>
                <tr>
                    <td>${expense1.id}</td>
                    <td>${expense1.eaccount}</td>
                    <td>${expense1.type}</td> 
                    <td>${expense1.itemname}</td>
                    <td>${expense1.amount}</td>
                    <td>${expense1.amount}</td>
                    <td><button>Edit</button></td>
                    <td><button>Delete</button></td>
                 
                </tr>
            </c:forEach>
            <%-- Display a message if no transactions are found --%>
            <c:if test="${empty expense}">
                <tr>
                    <td colspan="5">No transactions found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</body>
</html>