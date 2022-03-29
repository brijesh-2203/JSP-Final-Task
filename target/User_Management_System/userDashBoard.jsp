<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="assets/library/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/custom.css">
</head>
<body>

<h3 class="header">Welcome ${requestScope.username}</h3>
   <a href="ShowUserProfile" class="btn btn-default">Show Profile</a>
   <a href="registration.jsp" class="btn btn-default">EditProfile</a>
   <a href="LogOutServlet" class="btn btn-default">LogOut</a>
</body>
</html>