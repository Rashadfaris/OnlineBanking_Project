<%
    // Check if any session attribute is missing
    if (session.getAttribute("account") == null || session.getAttribute("name") == null || session.getAttribute("email") == null || session.getAttribute("userName") == null || session.getAttribute("contact") == null) {
        // Redirect to login page if any attribute is missing
        response.sendRedirect("login.jsp");
    }
%>

<!doctype html>
<html lang="en">

<head>
    <title> User View Profile</title>
    <style>
        /* Style for profile information container */
        .profile-container {
		    max-width: 600px;
		    margin: 0 auto; /* Center horizontally */
		    padding: 20px;
		    background-color: #f9f9f9;
		    border-radius: 10px;
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
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
        }

        /* Style for edit button */
        .edit-button {
            background-color: #008CBA;
        }

        /* Style for delete button */
        .delete-button {
            background-color: #f44336;
        }

        /* Style for back button */
        .back-button {
            background-color: #808080;
        }
    </style>
</head>

<body>
    <!-- Profile information container -->
    <div class="profile-container">
        <div class="profile-info">
            <p>Account Number: <%=session.getAttribute("account") %></p>
            <p>Name: <%=session.getAttribute("name") %></p>
            <p>Email: <%=session.getAttribute("email") %></p>
            <p>User Name: <%=session.getAttribute("userName") %></p>
            <p>Mobile: <%=session.getAttribute("contact") %></p>
        </div>

        <!-- Buttons for Edit Profile, Delete Profile, and Back to Home -->
        <div>
            <button class="button edit-button" onclick="location.href='editProfile.jsp'">Edit Profile</button>
            <button class="button delete-button" onclick="location.href='deleteProfile.jsp'">Delete Profile</button>
            <button class="button back-button" onclick="location.href='home.jsp'">Back to Home</button>
        </div>
    </div>
    
</body>

</html>
