<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="assets/library/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/custom.css">
    <link rel="stylesheet" type="text/css" href="assets/css/responsive.css">
</head>
<body>
<%@ include file="Header.jsp" %> 
<section>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-3"></div>
			<div class="col-md-4 col-sm-4 login">
				<h1 class="heading"><u>Reset Password</u></h1>
				<form action="ResetPassword" method="POST">
					<div class="form-group">
					Password:<input type="password" placeholder="Enter Password" id="pwd" class="form-control" name="password" required>
					</div>
					<div class="form-group">
					 Confirm password:<input type="password" name="repass" id="repwd" class="form-control" placeholder="Enter Confirm Password" required>
					</div>
					<div class="form-group">
					<input type="submit" class="form-control login-btn" value="Reset">
					</div>
					<input type="hidden" name="usermail" value="${requestScope.email}" required>
				</form>
			 </div>
			 <div class="col-md-5 col-sm-5"></div>
			 
		</div>
	</div>
</section>
<%@ include file="Footer.jsp" %> 
	<script src="assets/js/jquery-3.6.0.min.js"></script>
		<script src="assets/js/validation.js"></script>
</body>
</html>