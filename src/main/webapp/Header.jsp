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
		<nav class="navbar-fixed-top">
			<div class="container-fluid default-header">
			    <div class="row">
				   <div class="col-md-10 col-sm-10 set-data"><p class="userheading"><i>User Management System</i></p></div>
				   <c:choose>
				   <c:when test="${sessionScope.USER == null }">
				   <div class="col-md-1 col-sm-1 set-data"><a href="index.jsp" class="header-tag">Home</a></div>
				   <div class="col-md-1 col-sm-1 set-data"><a href="registration.jsp" class="header-tag">Signup</a></div>
				   </c:when>
				   <c:otherwise>
				   <div class="col-md-1 col-sm-1 set-data"></div>
				   <div class="col-md-1 col-sm-1 set-data"><a href="LogOutServlet" class="btn btn-danger">LogOut</a></div>
				   </c:otherwise>
				   </c:choose>
				</div>
				</div>
		</nav>
</body>
</html>