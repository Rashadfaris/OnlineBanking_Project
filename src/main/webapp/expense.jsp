<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Expense Tracker</title>
    <style>
        /* CSS styles for the Expense Tracker form */

        /* Overall styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: rgb(161, 9, 73);
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
        }

        /* Label styles */
        label {
            display: block;
            font-weight: bold;
        }

        /* Input styles */
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }

        /* Submit button styles */
        button {
            background-color: rgb(161, 9, 73);
            color: #fff;
            border: none;
            padding: 12px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #ad0746;
        }
    </style>
</head>
<body>
    <form action="expense" method="post" class="container">
        <div>
            <h1>Expense Tracker</h1>
        </div>
        <div class="form-group">
            <label for="account">Account:</label>
            <input type="text" name="account" id="account" placeholder="Your Account Number" required="required" value="<%=session.getAttribute("account") %>" readonly style="font-size: 18px;">
        </div>

        <div class="form-group">
            <label for="type">Type:</label>
            <input type="text" id="type" name="type" required><br><br>
        </div>

        <div class="form-group">
            <label for="item">Item:</label>
            <input type="text" id="item" name="item" required><br><br>
        </div>

        <div class="form-group">
            <label for="amount">Amount:</label>
            <input id="amount" name="amount" type="number" placeholder="Amount" required />
        </div>

        <div class="form-group">
            <button type="submit">Submit</button>
        </div>
        
        
    </form>
</body>
</html>
