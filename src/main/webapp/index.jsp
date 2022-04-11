<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
	<link rel="stylesheet" type="text/css" href="assets/library/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/custom.css">
    <link rel="stylesheet" type="text/css" href="assets/css/responsive.css">
</head>
<body>
<%@ include file="Header.jsp" %> 
<main>
	 <section>
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-3"></div>
				<div class="col-md-4 col-sm-4 login">
					<h1 class="heading" style="text-decoration: underline">Login Page</h1>
					<form action="LoginServlet" method="POST">
					    <span style='color:red'>${requestScope.message}</span>
						<div class="form-group label-name">
						Email :<input type="email" placeholder="Enter Email-ID"  class="form-control" name="email" required>
						</div>
						<div class="form-group label-name">
						Password:<input type="password" placeholder="Enter Password"  class="form-control" name="password" required>
						</div>
						<div class="form-group">
						<input type="submit" class="form-control login-btn" value="Login">
						</div>
						<div class="a-tag">
							<a href="forgotpwd.jsp" class="label-name" style="text-decoration: underline">Forgot Password</a>
							<a href="registration.jsp" class="user-gap label-name" style="text-decoration: underline">New User?SignUp</a>
						</div>
					</form>
				 </div>
				 <div class="col-md-5 col-sm-5"></div>	 
			</div>
		</div>
	</section>
</main>
<%@ include file="Footer.jsp" %> 
</body>
</html>