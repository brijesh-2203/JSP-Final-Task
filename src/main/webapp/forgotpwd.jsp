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
			<div class="col-md-3"></div>
			<div class="col-md-5 forgot-section">
				<h1 class="heading"><u>Find Your Account</u></h1>
				<form action="resetpwd.jsp">
				<div class="form-group">
					Email :<input type="text" placeholder="Enter Email-ID"  class="form-control" name="email">
				</div>
				<div class="form-group">
				 	Date of Birth: <input type="date" id="birthday" class="form-control" name="birthday" required>
				 </div>
				 <div class="form-group">
			 		<fieldset>
    					<legend>Security Questions:</legend>
			    			1.Who was your childhood super hero?<br>
			    				 <input type="text"  class="form-control" name="q1" required><br>
			    			2.What was your childhood nickname?<br>
			    				 <input type="text" class="form-control"  name="q2" required><br>
    				</fieldset>
    			 </div>
				<div class="form-group">
				<input type="submit" class="form-control login-btn" value="Submit">
				</div>
				
				
			</form>
			 </div>
			 <div class="col-md-4"></div>
			 
		</div>
	</div>
</section>
</body>
</html>