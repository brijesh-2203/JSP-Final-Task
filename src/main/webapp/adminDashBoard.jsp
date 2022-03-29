<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="assets/library/DataTables/datatables.min.css">
	<link rel="stylesheet" type="text/css" href="assets/library/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div>
	<table id="userdetails" class="display cell-border compact table-hover"> <!--Use the default css class of datatable-->
		<thead>
			<tr>
			<th>UserID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Date Of Birth</th>
			<th>Gender</th>
			<th>Language Known</th>
			<th>EditUser</th>
			<th>DeleteUser</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${requestScope.UsersList}" var='user' >
			<tr>
			    <td>${user.getUserID()}</td>
			    <td>${user.getFirstname()}</td>
			    <td>${user.getLastname()}</td>
			    <td>${user.getEmail()}</td>
			    <td>${user.getPhone()}</td>
			    <td>${user.getDateofbirth()}</td>
			    <td>${user.getGender()}</td>
			    <td>${user.getLanguage()}</td>
			    <td><a href="registration.jsp" class="btn btn-primary">Edit</a></td>
			    <td><a href="DeleteUser?userid=${user.getUserID()}" class="btn btn-danger">Delete</a></td>
			 </tr>
			</c:forEach>
			<!--<${sessionScope.UsersList}-->
		</tbody>
	</table>
</div>
<a href="registration.jsp" class="btn btn-info">Add New User</a>
<a href="LogOutServlet" class="btn btn-danger">LogOut</a>
<script src="assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" charset="utf8" src="assets/library/DataTables/datatables.min.js"></script>
<script src="assets/js/datatable.js"></script>
</body>
</html>