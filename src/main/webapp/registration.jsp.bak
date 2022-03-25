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
	<div class="container Form-Section">
			<h2 class="header"><u>Registration Page</u></h2>
			<form action="Validate" method="POST" class="form-horizontal">
		<div class="row left-gap">
			
			 <div class="col-md-5">
			 	<div class="form-group">
					FirstName :<input type="text" name="firstname"  class="form-control" placeholder="Enter First Name" required>
				</div>
				<div class="form-group">
					Phone:<input type="text" name="phone" size="10"  class="form-control" placeholder="Enter Phone Number" required>
				</div>
				 <div class="form-group">
				 	 Email:<input type="email" name="email" class="form-control" placeholder="Enter Email" required>
				 </div>
				 <div class="form-group">
				 	 Password:<input type="password" placeholder="Enter Password" class="form-control" name="password" required>
				 </div>
				 <div class="form-group">
					 Confirm password:<input type="password" name="repass" class="form-control" placeholder="Enter Confirm Password" required>
				 </div>
			 </div>
			<div class="col-md-2"></div>
			<div class="col-md-5">
				 <div class="form-group">
					LastName :<input type="text" name="lastname"  class="form-control" placeholder="Enter Last Name" required>
				 </div>
				 <div class="form-group">
				 	Date of Birth: <input type="date" id="birthday" class="form-control" name="birthday" required>
				 </div>
				 <div class="form-group">
				  Gender:
				   <div class="radio">
						<label class="radio-inline"><input type="radio" name="Gender" value="Male">Male</label>
						<label class="radio-inline"><input type="radio" name="Gender" value="FeMale">Female</label>
						<label class="radio-inline"><input type="radio" name="Gender" value="Transgender">Transgender</label>
					</div>
				 </div>
				 <div class="form-group">
				 	Language Known:
				 	<div class="checkbox">
						<label class="checkbox-inline"><input type="checkbox" name="lang" value="English">English</label>
						<label class="checkbox-inline"><input type="checkbox" name="lang" value="Hindi">Hindi</label>
						<label class="checkbox-inline"><input type="checkbox" name="lang" value="Gujarati">Gujarati</label>
						<label class="checkbox-inline"><input type="checkbox" name="lang" value="Chinese">Chinese</label>
				    </div>
				 </div>
			</div>
		</div> 
    
		<div class="row left-gap">
			<div class="col-md-12">
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
				    <label>Upload Photo:</label>
				    <input type="file" name="photo" id="imgUpload" required>
				 </div>
				  <div class="form-group">
				 <div id="image"></div>
				 </div>
    		 </div>
    	 </div>
      
    <div id="main-container">
	   <div class="container-item">
		  <div class="row left-gap" id="add-design">
			<div class="col-md-5 gap">
					  <div class="form-group">
						<p class="add-head">Address:</p>
							<textarea  class="form-control add-head" name="address" rows="10" maxlength="255" required></textarea>
					   </div>
					   <div class="form-group"><a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger add-head">Remove</a></div>
			 </div>
			<div class="col-md-2"></div>
			<div class="col-md-5 gap right-gap">
			        <div class="form-group">Pincode: <input type="text" class="form-control" name="pincode" required></div>
					<div class="form-group">City: <input type="text" class="form-control" name="city" required></div>
				    <div class="form-group">State: <input type="text"  class="form-control" name="state" required></div>
				    <div class="form-group"> Country: <input type="text" class="form-control" name="country" required></div>
			 </div>
		 </div>
		</div>
	</div>
		<div class="form-group">
			<a id="add-more" href="javascript:;" class="btn btn-primary left-gap">Add More Address</a>
		 </div>
		 <div class="form-group">
			<input type="submit" value="Submit" class="btn btn-success left-gap">
			<input type="reset" class="btn btn-info">
		 </div>
			
				</form>
			</div>
	
</section>
			<script src="assets/js/jquery-3.6.0.min.js"></script>
			<script src="assets/js/cloneData.js"></script>		
		<script src="assets/js/custom.js"></script>
		
</body>
</html>