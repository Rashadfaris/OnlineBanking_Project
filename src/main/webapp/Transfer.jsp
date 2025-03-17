<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Transaction Details Form</title>

<link rel="stylesheet"
	href="fonts1/material-icon1/css/material-design-iconic-font1.min.css">
<link rel="stylesheet" href="css1/style1.css">
</head>
<body>

	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Transaction Details</h2>

						<form method="post" action="transfer" class="register-form"
							id="transfer">
							
							<div class="form-group"><!-- accountj -->
								<label for="accountj"><i
									class="zmdi zmdi-account material-icons-name">
									 </i></label> <input
									type="text" name="accountj" id="acoountj"
									placeholder="Your Account Number" required="required"
									value = <%=session.getAttribute("account") %>
									style="font-size: 18px;" /readonly>
							</div>
							<div class="form-group"><!-- recipientnoj -->
								<label for="recipientnoj"><i class="zmdi zmdi-email"></i></label> <input
									type="text" name="recipientj"
									id="recipientj"
									placeholder="Recipient's Account Number" required="required"
									style="font-size: 18px;" />
							</div>
							<div class="form-group"><!-- recipientnamej -->
								<label for="recipientnamej"><i class="zmdi zmdi-lock"></i></label> <input
									type="text" name="recipientnamej" id="recipientnamej"
									placeholder="Recipient's Name" required="required"
									style="font-size: 18px;" />
							</div>
							<div class="form-group"><!-- purposej -->
								<label for="purposej"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="purposej" id="purposej"
									placeholder="Purpose" required="required"
									style="font-size: 18px;" />
							</div>
							<div class="form-group"><!-- amountj -->
								<label for="amountj"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="number" step="0.01" min="0" name="amountj"
									id="amountj" placeholder="Amount" required="required"
									style="font-size: 18px;" />
							</div>

							<div style="display: flex;"><!-- Submit btn -->
								<div class="form-group form-button" style="padding-right: 25px;">
									<button class="button edit-button" onclick="location.href='home.jsp'">Submit</button>
								</div>
							</div>
						</form>
						<div><a href="pendingTransaction.jsp">Pending Transactions</a></div>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js1/main1.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">




</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>