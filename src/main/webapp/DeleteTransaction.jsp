
<%
    // Check if any session attribute is missing
    if (session.getAttribute("accountj") == null || session.getAttribute("recipientj") == null || session.getAttribute("recipientnamej") == null || session.getAttribute("purposej") == null || session.getAttribute("amountj") == null) {
        // Redirect to login page if any attribute is missing
        //response.sendRedirect("login.jsp");
    }
%>

<!doctype html>
<html lang="en">

<head>
    <title>Delete Transaction</title>
   <style>
       body {
        background-color: #141E46; /* Background color for the entire page */
    }
        .confirmation-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }


        /* Style for save button */
        .save-button {
            background-color:#00bbf0;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 13px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 8px;
        }
        
        .cancel-button {
            background-color: grey;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 13px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <div class="confirmation-container">
        <h2>Delete Transaction Confirmation</h2>
        <p>Are you sure you want to delete transaction <%= request.getParameter("tid") %>?</p>
        <form action="deletetransfer" method="post">
            <input type="hidden" id="tid" name="tid" value="<%= request.getParameter("tid") %>">
            <button class="save-button" type="submit">Delete</button>
            <button class="cancel-button" onclick="window.history.back()">Cancel</button>
        </form>
    </div>
</body>

</html>
