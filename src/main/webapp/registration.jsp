<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="assets/library/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/custom.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="assets/dist/image-uploader.min.css">
</head>
<body>
<section>
	<div class="container Form-Section">
	<c:choose> 
		<c:when test="${user != null}">
			<h2 class="header"><u>Edit Page</u></h2>
		</c:when>
		<c:otherwise> 
		<h2 class="header"><u>Registration Page</u></h2>
		</c:otherwise>
		</c:choose>
		<c:choose> 
		<c:when test="${user != null}">
				<form action="EditServlet" method="POST" class="form-horizontal" id="myform" enctype="multipart/form-data">
		</c:when>
		<c:otherwise>
				<form action="ValidateServlet" method="POST" class="form-horizontal" id="myform" enctype="multipart/form-data">
		</c:otherwise>
		</c:choose>
		<div class="row left-gap">
			<input type="hidden" name="userid" value="${user.userID}">
			 <div class="col-md-5">
			 	<div class="form-group">
					FirstName :<input type="text" name="firstname" value="${user.firstname}" id="firstname" class="form-control" placeholder="Enter First Name" required>
				</div>
				<div class="form-group">
					Phone:<input type="text" name="phone" maxlength="10" value="${user.phone}" size="10" id="phone" class="form-control" placeholder="Enter Phone Number" required>
				</div>
				<c:choose> 
				<c:when test="${user==null}">
				 <div class="form-group">
				 	 Email:<input type="email" name="email" id="email" class="form-control" placeholder="Enter Email" required>
				 </div>
				 <div class="form-group">
				 	 Password:<input type="password" placeholder="Enter Password"  id="pwd" class="form-control" name="password" required>
				 </div>
				 <div class="form-group">
					 Confirm password:<input type="password" name="repass" id="repwd" class="form-control" placeholder="Enter Confirm Password" required>
				 </div>
				 </c:when>
				 <c:otherwise> 
				 <div class="form-group">
				 	Gender:
				   <div class="radio">
				  	 <c:choose>
					      <c:when test="${user.gender=='Male'}">
							<label class="radio-inline"><input type="radio" name="Gender" value="Male" checked>Male</label>
						  </c:when>
						  <c:otherwise>
						  	<label class="radio-inline"><input type="radio" name="Gender" value="Male">Male</label>
						  </c:otherwise>
					  </c:choose>
					  <c:choose>
					      <c:when test="${user.gender=='Female'}">
							<label class="radio-inline"><input type="radio" name="Gender" value="Female" checked>Female</label>
						  </c:when>
						  <c:otherwise>
						  	<label class="radio-inline"><input type="radio" name="Gender" value="Female">Female</label>
						  </c:otherwise>
					  </c:choose>
					  <c:choose>
					      <c:when test="${user.gender=='Transgender'}">
							<label class="radio-inline"><input type="radio" name="Gender" value="Transgender" checked>Transgender</label>
						  </c:when>
						  <c:otherwise>
						  	<label class="radio-inline"><input type="radio" name="Gender" value="Transgender">Transgender</label>
						  </c:otherwise>
					  </c:choose>
					</div>
				 </div>
				 </c:otherwise>
				 </c:choose>
			 </div>
			<div class="col-md-2"></div>
			<div class="col-md-5">
				 <div class="form-group">
					LastName :<input type="text" name="lastname" id="lastname" value="${user.lastname}" class="form-control" placeholder="Enter Last Name" required>
				 </div>
				 <div class="form-group">
				 	Date of Birth: <input type="date" id="birthday" class="form-control" value="${user.dateofbirth}" name="birthdate" required>
				 </div>
				 <c:if test="${user==null}">
				 <div class="form-group">
				  Gender:
				   <div class="radio">
				   
						<label class="radio-inline"><input type="radio" name="Gender" value="Male">Male</label>
						<label class="radio-inline"><input type="radio" name="Gender" value="FeMale">Female</label>
						<label class="radio-inline"><input type="radio" name="Gender" value="Transgender">Transgender</label>
					</div>
				 </div>
				 </c:if>
				 <div class="form-group">
				 	Language Known:
				 	<div class="checkbox">
				 	<label class="checkbox-inline">
						 	<c:choose>
							      <c:when test="${fn:contains(user.language,'English')}">
									<input type="checkbox" name="lang" value="English" checked>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="lang" value="English">
								</c:otherwise>
							</c:choose>
						English
					</label>
						<label class="checkbox-inline">
							<c:choose>
							      <c:when test="${fn:contains(user.language,'Hindi')}">
									<input type="checkbox" name="lang" value="Hindi" checked>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="lang" value="Hindi">
								</c:otherwise>
							</c:choose>
							Hindi
						</label>
						<label class="checkbox-inline">
							<c:choose>
							      <c:when test="${fn:contains(user.language,'Gujarati')}">
									<input type="checkbox" name="lang" value="Gujarati" checked>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="lang" value="Gujarati">
								</c:otherwise>
							</c:choose>
							Gujarati	
						</label>
						<label class="checkbox-inline">
							<c:choose>
							      <c:when test="${fn:contains(user.language,'Chinese')}">
									<input type="checkbox" name="lang" value="Chinese" checked>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="lang" value="Chinese">
								</c:otherwise>
							</c:choose>
							Chinese
						</label>
				    </div>
				 </div>
			</div>
		</div> 
    <c:if test="${user==null}">
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
    			 </div>
    	 </div>
</c:if>
			   	<div class="row left-gap">
					<div class="col-md-12">
		    			 <div class="form-group">
						    <div><label>Upload Photo:</label></div>
						    <c:choose> 
								<c:when test="${user != null}">
									 <c:forEach items="${user.image}" var='userimg' >
									     <span class="uploadedimage"><img src="data:image/jpg;base64,${userimg.base64Image}" class="image" width="180" height="180"/>
									     <a href="RemoveImage?imgId=${userimg.imgid}" class="del-image"><i class="material-icons">clear</i></a></span>
								     </c:forEach>
								     <div class="input-images"></div>
								</c:when>
								<c:otherwise> 
								 <div class="input-images"></div>
								</c:otherwise>
							</c:choose>
						   
						    <!--<input id="fileupload" type="file" name="files[]" multiple>-->
						   <!--<input  type="file" id="files" name="files" multiple="true" required>--><!--<input type="file" name="photo" class="imgUpload" id="image_0">-->
						 </div>
						<!--<div class="form-group"><a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger add-head" id="remove-btn">Remove</a></div>-->
					  </div>
					</div>
		<!--
       <div class="form-group">
			<a id="add-more" href="javascript:;" class="btn btn-primary left-gap add-photos-btn">Add More Photos</a>
		 </div>
     -->
     <c:choose> 
		<c:when test="${user != null}">
			<c:forEach items="${user.address}" var='useradd' >
    <div id="main-container">
	   <div class="container-item">
		  <div class="row left-gap" id="add-design">
		    <h3  class="head-gap">Address Field:</h3>
			<div class="col-md-5 gap">
					  <div class="form-group">
						<p class="add-head">Address line1:</p>
							<input type="text" class="form-control add-head" value="${useradd.add1}" name="address1" required>
					   </div>
					   <div class="form-group"><p class="add-head">City: </p><input type="text" value="${useradd.city}"  class="form-control add-head" name="city" required></div>
					    <div class="form-group"><p class="add-head"> Country: </p><input type="text" value="${useradd.country}" class="form-control add-head" name="country" required></div>
					   <div class="form-group"><a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger add-head remove-data" id="remove-btn">Remove</a></div>
			 </div>
			<div class="col-md-2"></div>
			<div class="col-md-5 gap right-gap">
					   <div class="form-group">
						<p>Address line2:</p>
							<input type="text" class="form-control" value="${useradd.add2}" name="address2" required>
					   </div>
				    <div class="form-group"><p>State:</p><input type="text" value="${useradd.state}"  class="form-control" name="state" required></div>
				    <div class="form-group"><p>Pincode:</p><input type="text"  value="${useradd.pincode}" class="form-control" name="pincode" id="pincode_0" required></div>
			 </div>
		 </div>
		</div>
	</div>
	 </c:forEach>
	</c:when>
		<c:otherwise> 
		    <div id="main-container">
			   <div class="container-item">
				  <div class="row left-gap" id="add-design">
				    <h3  class="head-gap">Address Field:</h3>
					<div class="col-md-5 gap">
							  <div class="form-group">
								<p class="add-head">Address line1:</p>
									<input type="text" class="form-control add-head" name="address1" required>
							   </div>
							   <div class="form-group"><p class="add-head">City: </p><input type="text" class="form-control add-head" name="city" required></div>
							    <div class="form-group"><p class="add-head"> Country: </p><input type="text" class="form-control add-head" name="country" required></div>
							   <div class="form-group"><a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger add-head remove-data" id="remove-btn">Remove</a></div>
					 </div>
					<div class="col-md-2"></div>
					<div class="col-md-5 gap right-gap">
							   <div class="form-group">
								<p>Address line2:</p>
									<input type="text" class="form-control" name="address2" required>
							   </div>
						    <div class="form-group"><p>State:</p><input type="text" class="form-control" name="state" required></div>
						    <div class="form-group"><p>Pincode:</p><input type="text" class="form-control" name="pincode" id="pincode_0" required></div>
					 </div>
				 </div>
				</div>
			</div>
		</c:otherwise>
		</c:choose>

		<div class="form-group">
			<a id="add-more" href="javascript:;" class="btn btn-primary left-gap add-btn">Add More Address</a>
		 </div>
		 <div class="form-group">
			<input type="submit" value="Submit" class="btn btn-success left-gap" id="submit-btn">
			
			<input type="reset" class="btn btn-info">
		 </div>
			
	</form>
</div>
	
</section>
			<script src="assets/js/jquery-3.6.0.min.js"></script>
			<script src="assets/js/cloneData.js"></script>		
		<script type="text/javascript" src="assets/dist/image-uploader.min.js"></script>
		<script src="assets/js/custom.js"></script>
		<script src="assets/js/validation.js"></script>
</body>
</html>