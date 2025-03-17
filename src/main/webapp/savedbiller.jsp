<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Biller" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Biller</title>
    <style>
        /* Add your CSS styles here */
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <h1>View Biller</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Biller ID</th>
                <th>Account No</th>
                <th>Biller Name</th>
                <th>Biller Reference</th>
                <th>Mobile No</th>
                <td><b>Edit</b></td>
                <td><b>Delete</b></td>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over the list of transactions --%>
            <c:forEach var="biller1" items="${biller}">
                <tr>
                    <td>${biller1.bid}</td>
                    <td>${biller1.account}</td>
                    <td>${biller1.bname}</td>
                    <td>${biller1.breference}</td>
                    <td>${biller1.bmobile}</td>
                    <td><button>Edit</button></td>
                    <td><button>Delete</button></td>
                </tr>
            </c:forEach>
            <%-- Display a message if no transactions are found --%>
            <c:if test="${empty biller}">
                <tr>
                    <td colspan="5">No transactions found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</body>
</html>
