<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Register</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fontslogin/material-icon/css/material-design-iconic-font.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
	
 <style>
        body {
            font-family: sans-serif; /* Use Roboto for body text */
        }

        h1, h2, h3 {
            font-family: sans-serif; /* Use Montserrat for headings */
        }
    </style>
<!-- Main css -->
<link rel="stylesheet" href="csslogin/style.css">
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>"> 
	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Register</h2>
					
						<form method="post" action="register" class="register-form"
							id="register-form">
							<div class="form-group"><!--add account field -->
								<label for="account"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="account" id="account" placeholder="Account Number " required="required" />
							</div>
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name" required="required" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" required="required" />
							</div>
							<div class="form-group"><!--add userName field -->
								<label for="userName"><i class="zmdi zmdi-email"></i></label> <input
									type="userName" name="userName" id="userName" placeholder="User Name" required="required" />
							</div>
							
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="Password" required="required"  />
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" required="required"  />
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact no" required="required"  />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="./imageslogin/Register.png" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src ="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
 var status = document.getElementById("status").value;
 if(status =="success"){
	 swal("congrats","Account Created Successfully","success");
 }
 if(status =="invalidName"){
	 swal("Sorry","Please Enter Name","error");
 }
 if(status =="invalidEmail"){
	 swal("Sorry","Please Enter Email","error");
 }
 if(status =="invalidUpwd"){
	 swal("Sorry","Please Enter Password","error");
 }
 if(status =="invalidConfirmPassword"){
	 swal("Sorry","Password do not match","error");
 }
 if(status =="invalidMobile"){
	 swal("Sorry","Please Enter Mobile Number","error");
 }
 if(status =="InvalidMobileLength"){
	 swal("Sorry","Please Enter Mobile Number should be of 10 digit","error");
 }
</script>


</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>