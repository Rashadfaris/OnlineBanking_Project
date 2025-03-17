<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Delete Profile</title>
  <style>
        /* Style for form container */
        .form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* Style for form input fields */
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 20px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Style for save button */
        .save-button {
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
        }
    </style>
</head>

<body>
    <!-- Form container -->
    <div class="form-container">
        <h2>Edit Profile</h2>
       <form action="deleteProfile" method="post">
            <label for="account">Account Number:</label>
            <input type="text" id="account" name="account" value="<%=session.getAttribute("account") %>" readonly>
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="<%=session.getAttribute("name") %>"readonly>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%=session.getAttribute("email") %>"readonly>
            
            <label for="userName">User Name:</label>
            <input type="text" id="userName" name="userName" value="<%=session.getAttribute("userName") %>"readonly>
            
            <label for="contact">Mobile:</label>
            <input type="text" id="contact" name="contact" value="<%=session.getAttribute("contact") %>"readonly>
            <button class="save-button" type="submit">Delete Profile</button>
          
        </form>
    </div>
</body>
</html>



  

