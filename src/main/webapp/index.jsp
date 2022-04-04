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
</head>
<body>
<%@ include file="Header.jsp" %> 
<main>
  <section>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 login">
				<h1 class="heading"><u>Login Page</u></h1>
				<form action="LoginServlet" method="POST">
				    <span style='color:red'>${requestScope.message}</span>
					<div class="form-group">
					Email :<input type="text" placeholder="Enter Email-ID"  class="form-control" name="email" required>
					</div>
					<div class="form-group">
					Password:<input type="password" placeholder="Enter Password"  class="form-control" name="password" required>
					</div>
					<div class="form-group">
					<input type="submit" class="form-control login-btn" value="Login">
					</div>
					<div class="a-tag">
						<a href="forgotpwd.jsp"><u>Forgot Password</u></a>
						<a href="registration.jsp" class="user-gap"><u>New User?SignUp</u></a>
					</div>
				</form>
			 </div>
			 <div class="col-md-4"></div>	 
		</div>
	</div>
</section>
</main>
<%@ include file="Footer.jsp" %> 
</body>
</html>