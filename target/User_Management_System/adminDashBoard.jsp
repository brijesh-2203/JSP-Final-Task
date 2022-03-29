<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
</head>
<body>
Hello admin
<div>
	<table id="userdetails" class="display cell-border compact stripe"> <!--Use the default css class of datatable-->
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
			    <td>${user.getDateofbirth}</td>
			    <td>${user.getGender()}</td>
			    <td>${user.getLanguage}</td>
			 </tr>
			</c:forEach>
			<!--<${sessionScope.UsersList}-->
		</tbody>
	</table>
</div>
<script src="assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
<script src="assets/js/datatable.js"></script>
</body>
</html>