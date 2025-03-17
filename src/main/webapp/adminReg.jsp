<!DOCTYPE html>
<html>
<head>
    <title>Admin Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #f9f9f9;
        }
        h2 {
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"],
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 10px;
            cursor: pointer;
            border-radius: 5px;
            width: auto;
        }
        .delete-button {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <h2>Admin Registration Form</h2>
    <form action="adminreg" method="post">
        <label for="aid">Admin ID:</label>
        <input type="text" id="aid" name="aid" pattern="[A-Za-z0-9]+" title="Please enter alphanumeric characters only" required><br><br>
        
        <label for="adminName">Admin Name:</label>
        <input type="text" id="adminName" name="adminName" required><br><br>
        
        <label for="auserName">Username:</label>
        <input type="text" id="auserName" name="auserName" required><br><br>
        
        <label for="aPassword">Password:</label>
        <input type="password" id="aPassword" name="aPassword"required><br><br>
        
        <input type="submit" value="Register">
        <button class="button delete-button" onclick="location.href='AdminLogin.jsp'">Back to Login</button>
    </form>
</body>
</html>
