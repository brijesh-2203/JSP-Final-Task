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

<h3 class="title-name">Welcome ${USER.firstname} ${USER.lastname}</h3>
<span class="buttons">
   <a href="UserDetails" class="btn btn-default">EditProfile</a>
   <a href="LogOutServlet" class="btn btn-default">LogOut</a>
 </span>
</body>
</html>