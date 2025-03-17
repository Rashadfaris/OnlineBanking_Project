<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Biller</title>
    <link rel="stylesheet" href="styles.css">
    <style>
    body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
}

.container {
    max-width: 600px;
    margin: 50px auto;A
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
    text-align: center;
    margin-bottom: 20px;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 5px;
}

input {
    padding: 10px;
    margin-bottom: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

button {
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}
    </style>
    
</head>
<body>
    	<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Biiler Details</h2>

						<form method="post" action="biller" class="biller"
							id="biller">
							
							<div class="form-group"><!-- accountj -->
								<label for="baccount"><i
									class="zmdi zmdi-account material-icons-name">
									 </i></label> <input
									type="text" name="baccount" id="baccount"
									placeholder="Your Account Number" required="required"
									value = <%=session.getAttribute("account") %>
									style="font-size: 18px;" readonly>
							</div>
							<div class="form-group"><!-- recipientnoj -->
								<label for="bname"><i class="zmdi zmdi-email"></i></label> <input
									type="text" name="bname"
									id="bname"
									placeholder="Biller Name" required="required"
									style="font-size: 18px;" />
							</div>
							<div class="form-group"><!-- recipientnamej -->
								<label for="bref"><i class="zmdi zmdi-lock"></i></label> <input
									type="text" name="bref" id="bref"
									placeholder="Biller Reference" required="required"
									style="font-size: 18px;" />
							</div>
							<div class="form-group"><!-- purposej -->
								<label for="bnumber"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="bnumber" id="bnumber"
									placeholder="Mobile Number" required="required"
									style="font-size: 18px;" />
							</div>
							
						<div style="display: flex;"><!-- Submit btn -->
								<div class="form-group form-button" style="padding-right: 25px;">
								 <button class="button edit-button" onclick="location.href='savedbiller.jsp'">Submit</button>
									
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>

    
    <script src="script.js"></script>
</body>
</html>