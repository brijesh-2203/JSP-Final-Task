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
    <link rel="stylesheet" type="text/css" href="assets/css/responsive.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="assets/dist/image-uploader.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="Header.jsp" %>

<section>
	<div class="container Form-Section">
		<c:choose> 
			<c:when test="${user != null}">
				<h2 class="edit-header"><u>Edit Page</u></h2>
			</c:when>
			<c:otherwise> 
			<h2 class="header"><u>Registration Page</u></h2>
			</c:otherwise>
		</c:choose>
		<span style='color:red'>${requestScope.message}</span>
		<c:choose> 
		<c:when test="${user != null}">
				<form action="EditServlet" method="POST" class="form-horizontal" id="myform" enctype="multipart/form-data">
		</c:when>
		<c:otherwise>
				<form action="UserRegistration" method="POST" class="form-horizontal" id="myform" enctype="multipart/form-data">
		</c:otherwise>
		</c:choose>
		<div class="row left-gap">
			<input type="hidden" name="userid" id="userid" value="${user.userID}">
			 <div class="col-md-5">
			 	<div class="form-group">
					FirstName :<input type="text" name="firstname" maxlength="50" value="${requestScope.formdata.firstname}${user.firstname}" id="firstname" class="form-control" placeholder="Enter First Name" required>
				</div>
				<div class="form-group">
					LastName :<input type="text" name="lastname" id="lastname" maxlength="50" value="${requestScope.formdata.lastname}${user.lastname}" class="form-control" placeholder="Enter Last Name" required>
				</div>
				<c:choose> 
				<c:when test="${user==null}">
				 <div class="form-group">
				 	 Email:<input type="email" name="email" id="email" maxlength="100" value="${requestScope.formdata.email}" class="form-control" placeholder="Enter Email" required>
				 	 <span id="error"></span>
				 </div>
				 <div class="form-group">
				 	 Password:<input type="password" placeholder="Enter Password" value="${requestScope.formdata.password}" maxlength="50" id="pwd" class="form-control" name="password" required>
				 </div>
				 <div class="form-group">
					 Confirm password:<input type="password" name="repass" id="repwd" class="form-control" maxlength="50" placeholder="Enter Confirm Password" required>
				 </div>
				 </c:when>
				 <c:otherwise> 
				 <div class="form-group">
				 	Gender:
				   <div class="radio checked-radio">
				  	 <c:choose>
					      <c:when test="${user.gender=='Male' || requestScope.formdata.gender=='Male'}">
							<label class="radio-inline"><input type="radio" name="Gender" value="Male" checked>Male</label>
						  </c:when>
						  <c:otherwise>
						  	<label class="radio-inline"><input type="radio" name="Gender" value="Male">Male</label>
						  </c:otherwise>
					  </c:choose>
					  <c:choose>
					      <c:when test="${user.gender=='Female' || requestScope.formdata.gender=='Female'}">
							<label class="radio-inline"><input type="radio" name="Gender" value="Female" checked>Female</label>
						  </c:when>
						  <c:otherwise>
						  	<label class="radio-inline"><input type="radio" name="Gender" value="Female">Female</label>
						  </c:otherwise>
					  </c:choose>
					  <c:choose>
					      <c:when test="${user.gender=='Transgender' || requestScope.formdata.gender=='Transgender'}">
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
					Phone:<input type="text" name="phone" maxlength="10" value="${requestScope.formdata.phone}${user.phone}${requestScope.phonenumber}" size="10" id="phone" class="form-control" placeholder="Enter Phone Number" required>
				 </div>
				 <div class="form-group">
				 	Date of Birth: <input type="date" id="dob" class="form-control" value="${requestScope.formdata.dateofbirth}${user.dateofbirth}" name="birthdate" required>
				 </div>
				 <c:if test="${user==null}">
				 <div class="form-group">
				 	Gender:
				   <div class="radio checked-radio">
				  	 <c:choose>
					      <c:when test="${requestScope.formdata.gender=='Male'}">
							<label class="radio-inline"><input type="radio" name="Gender" value="Male" checked>Male</label>
						  </c:when>
						  <c:otherwise>
						  	<label class="radio-inline"><input type="radio" name="Gender" value="Male">Male</label>
						  </c:otherwise>
					  </c:choose>
					  <c:choose>
					      <c:when test="${requestScope.formdata.gender=='Female'}">
							<label class="radio-inline"><input type="radio" name="Gender" value="Female" checked>Female</label>
						  </c:when>
						  <c:otherwise>
						  	<label class="radio-inline"><input type="radio" name="Gender" value="Female">Female</label>
						  </c:otherwise>
					  </c:choose>
					  <c:choose>
					      <c:when test="${requestScope.formdata.gender=='Transgender'}">
							<label class="radio-inline"><input type="radio" name="Gender" value="Transgender" checked>Transgender</label>
						  </c:when>
						  <c:otherwise>
						  	<label class="radio-inline"><input type="radio" name="Gender" value="Transgender">Transgender</label>
						  </c:otherwise>
					  </c:choose>
					</div>
				 </div>
				 </c:if>
				 <div class="form-group">
				 	Language Known:
				 	<div class="checkbox checked-checkbox">
				 	    <label class="checkbox-inline">
						 	<c:choose>
							      <c:when test="${fn:contains(user.language,'English') || fn:contains(requestScope.formdata.language,'English')}">
									<input type="checkbox" name="lang" value="English" checked>
								  </c:when>
								  <c:otherwise>
									<input type="checkbox" name="lang"  value="English">
								  </c:otherwise>
							</c:choose>
						    English
					    </label>
						<label class="checkbox-inline">
							<c:choose>
							    <c:when test="${fn:contains(user.language,'Hindi') || fn:contains(requestScope.formdata.language,'Hindi')}">
									<input type="checkbox" name="lang" id="myCheck"  value="Hindi" checked>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="lang" id="myCheck"  value="Hindi">
								</c:otherwise>
							</c:choose>
							Hindi
						</label>
						<label class="checkbox-inline">
							<c:choose>
							      <c:when test="${fn:contains(user.language,'Gujarati') || fn:contains(requestScope.formdata.language,'Gujarati')}">
									<input type="checkbox" name="lang" id="myCheck"  value="Gujarati" checked>
								  </c:when>
								  <c:otherwise>
									<input type="checkbox" name="lang" id="myCheck"  value="Gujarati">
								  </c:otherwise>
							</c:choose>
							Gujarati	
						</label>
						<label class="checkbox-inline">
							<c:choose>
							      <c:when test="${fn:contains(user.language,'Chinese') || fn:contains(requestScope.formdata.language,'Chinese')}">
							 		<input type="checkbox" name="lang" id="myCheck"  value="Chinese" checked>
								  </c:when>
								  <c:otherwise>
									<input type="checkbox" name="lang" id="myCheck" value="Chinese">
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
			    				 <input type="text"  class="form-control" id="ans1" value="${requestScope.formdata.answer1}" maxlength="60" name="q1" required><br>
			    			2.What was your childhood nickname?<br>
			    				 <input type="text" class="form-control" id="ans2" value="${requestScope.formdata.answer2}" maxlength="60" name="q2" required><br>
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
									 <input type="hidden" name="image[]" value="data:image/jpg;base64,${userimg.base64Image}">
									 <span id="${userimg.imgid}" class="delete-image">
									     <span class="uploadedimage"><img src="data:image/jpg;base64,${userimg.base64Image}" class="image" width="180" height="180"/>
									     <span class="del-image"><i class="material-icons">clear</i></span></span></span>
								     </c:forEach>
								     <div class="input-images"></div>
								</c:when>
								<c:otherwise> 
								 <div class="input-images"></div>
								</c:otherwise>
							</c:choose>
						</div>
					  </div>
				</div>
  <div id="main-container">
     <c:choose> 
		<c:when test="${user != null || formdata !=null}">
			 <c:choose> 
			 <c:when test="${requestScope.formdata !=null}">
				<c:forEach items="${requestScope.formdata.address}" var='useradd'>
					<div class="container-item">
						  <div class="row left-gap" id="add-design">
							    <h3  class="head-gap">Address Field:</h3>
								<div class="col-md-5 col-sm-5 gap">
									  <div class="form-group">
										<p class="add-head">Address line1:</p>
											<input type="text" class="form-control add-head" maxlength="50" value="${useradd.add1}"  name="address1" required>
									   </div>
									   <div class="form-group"><p class="add-head">City: </p><input type="text" value="${useradd.city}" maxlength="50" class="form-control add-head" name="city" required></div>
									    <div class="form-group"><p class="add-head"> Country: </p><input type="text" value="${useradd.country}" maxlength="50" class="form-control add-head" name="country" required></div>
									   <div class="form-group"><a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger add-head remove-data" id="remove-btn">Remove</a></div>
							 	</div>
								<div class="col-md-2 col-sm-2"></div>
								<div class="col-md-5 col-sm-5 gap right-gap">
									   <div class="form-group">
										<p>Address line2:</p>
											<input type="text" class="form-control" maxlength="50" value="${useradd.add2}" name="address2" required>
									   </div>
								    <div class="form-group"><p>State:</p><input type="text" maxlength="50" value="${useradd.state}"  class="form-control" name="state" required></div>
								    <div class="form-group"><p>Pincode:</p><input type="text" maxlength="6" value="${useradd.pincode}" class="form-control" name="pincode" id="pincode_0" required></div>
							 	</div>
						 	</div>
					  </div>
				</c:forEach>
			 </c:when>
			 <c:otherwise>
				<c:forEach items="${user.address}" var='useradd' >
				   <div class="container-item">
					   <div class="row left-gap" id="add-design">
						    <h3  class="head-gap">Address Field:</h3>
							<div class="col-md-5 col-sm-5 gap">
							  <c:if test="${user!=null}">
								<input type="hidden" name="addid" value="${useradd.addressid}">
							  </c:if>
								  <div class="form-group">
									<p class="add-head">Address line1:</p>
										<input type="text" class="form-control add-head" maxlength="50" value="${useradd.add1}"  name="address1" required>
								   </div>
								   <div class="form-group"><p class="add-head">City: </p><input type="text" value="${useradd.city}" maxlength="50" class="form-control add-head" name="city" required></div>
								   <div class="form-group"><p class="add-head"> Country: </p><input type="text" value="${useradd.country}" maxlength="50" class="form-control add-head" name="country" required></div>
								   <div class="form-group"><a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger add-head remove-data" id="remove-btn">Remove</a></div>
						    </div>
							<div class="col-md-2 col-sm-2"></div>
							<div class="col-md-5 col-sm-5 gap right-gap">
								   <div class="form-group">
									<p>Address line2:</p>
										<input type="text" class="form-control" maxlength="50" value="${useradd.add2}" name="address2" required>
								   </div>
								   <div class="form-group"><p>State:</p><input type="text" maxlength="50" value="${useradd.state}"  class="form-control" name="state" required></div>
								   <div class="form-group"><p>Pincode:</p><input type="text" maxlength="6" value="${useradd.pincode}" class="form-control" name="pincode" id="pincode_0" required></div>
						    </div>
					   </div>
		 		 </div>
	            </c:forEach>
			  </c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise> 
			   <div class="container-item">
				  <div class="row left-gap" id="add-design">
					    <h3  class="head-gap">Address Field:</h3>
						<div class="col-md-5 col-sm-5 gap">
							  <div class="form-group">
								<p class="add-head">Address line1:</p>
									<input type="text" class="form-control add-head" maxlength="50" name="address1" required>
							   </div>
							   <div class="form-group"><p class="add-head">City: </p><input type="text" id="city_0" maxlength="50" class="form-control add-head" name="city" required></div>
							   <div class="form-group"><p class="add-head"> Country: </p><input type="text" id="country_0" maxlength="50" class="form-control add-head" name="country" required></div>
							   <div class="form-group"><a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger add-head remove-data" id="remove-btn">Remove</a></div>
						</div>
						<div class="col-md-2 col-sm-2"></div>
						<div class="col-md-5 col-sm-5 gap right-gap">
							   <div class="form-group">
								<p>Address line2:</p>
									<input type="text" maxlength="50" class="form-control" name="address2" required>
							   </div>
							   <div class="form-group"><p>State:</p><input type="text" maxlength="50" id="state_0" class="form-control" name="state" required></div>
							   <div class="form-group"><p>Pincode:</p><input type="text" maxlength="6" class="form-control" name="pincode" id="pincode_0" required></div>
					 	</div>
				   </div>
				</div>
		</c:otherwise>
		</c:choose>
	</div>
		<div class="form-group">
			<a id="add-more" href="javascript:;" class="btn btn-primary left-gap add-btn">Add More Address</a>
		 </div>
		 <div class="form-group">
			 <c:choose> 
				<c:when test="${user != null}">
					<input type="submit" value="Update" class="btn btn-success left-gap" id="submit-btn">
				</c:when>
				<c:otherwise>
					<input type="submit" value="Submit" class="btn btn-success left-gap" id="submit-btn">
				</c:otherwise>
			</c:choose>
			<input type="reset" class="btn btn-info">
		 </div>	
	</form>
</div>	
</section>
<%@ include file="Footer.jsp" %>
		<script src="assets/js/jquery-3.6.0.min.js"></script>
		<script src="assets/js/cloneData.js"></script>		
		<script type="text/javascript" src="assets/dist/image-uploader.min.js"></script>
		<script src="assets/js/custom.js"></script>
		<script src="assets/js/validation.js"></script>
</body>
</html>