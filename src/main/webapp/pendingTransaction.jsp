<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.model.Transfer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pending Transactions</title>
    <style>
/* Style for profile information container */
.profile-container {
	max-width: 600px;
	margin: 0 auto;
	padding: 20px;
	background-color: #f9f9f9;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	font-family: Arial, sans-serif; /* Change font style */
}

/* Style for profile information text */
.profile-info {
	margin-bottom: 10px;
	font-size: 16px;
	color: #333;
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

/* Style for edit button */
.edit-button {
	background-color: #008CBA;
}

/* Style for delete button */
.delete-button {
	background-color: #f44336;
}

table {
	border-collapse: collapse;
	width: 100%;
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

h1 {
	text-align: center;
	color: #333;
	font-size: 28px;
	margin-top: 20px;
}
</style>
</head>
<body>
    <div class="profile-container">
        <h1>Pending Transactions</h1>
        <table border="1" cellspacing="0">
            <thead>
                <tr>
                    <th>Transaction ID</th>
                    <th>Sender Account</th>
                    <th>Recipient Account No</th>
                    <th>Recipient Account Name</th>
                    <th>Purpose</th>
                    <th>Amount</th>
                    <th>Edit Transaction</th>
                    <th>Delete Transaction</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaction" items="${transactions}">
                    <tr>
                        <td>${transaction.tid}</td>
                        <td>${transaction.account}</td>
                        <td>${transaction.recAccountNo}</td>
                        <td>${transaction.recAccountName}</td>
                        <td>${transaction.purpose}</td>
                        <td>${transaction.amount}</td>
                        <td>
                            <button class="button edit-button" onclick="redirectToEdit(${transaction.tid}, '${transaction.purpose}', ${transaction.amount})">Edit</button>
                        </td>
                        <td>
                            <button class="button delete-button" onclick="deleteTransaction(${transaction.tid})">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty transactions}">
                    <tr>
                        <td colspan="6">No transactions found.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
    
    <script>
        function redirectToEdit(tid, purpose, amount) {
            window.location.href = "EditTransaction.jsp?tid=" + tid + "&purpose=" + purpose + "&amount=" + amount;
        }
        
        function deleteTransaction(tid) {
            window.location.href = "DeleteTransaction.jsp?tid=" + tid;
        }
    </script>
</body>
</html>
