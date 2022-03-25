<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="assets/library/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/custom.css">
</head>
<body>
<section>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 login">
				<h1 class="heading"><u>Reset Password</u></h1>
				<form action="ResetPassword" method="POST">
					<div class="form-group">
					Password:<input type="password" placeholder="Enter Password"  class="form-control" name="password" required>
					</div>
					<div class="form-group">
					 Confirm password:<input type="password" name="repass" class="form-control" placeholder="Enter Confirm Password" required>
					</div>
					<div class="form-group">
					<input type="submit" class="form-control login-btn" value="Reset">
					</div>
					
				</form>
			 </div>
			 <div class="col-md-4"></div>
			 
		</div>
	</div>
</section>
</body>
</html>