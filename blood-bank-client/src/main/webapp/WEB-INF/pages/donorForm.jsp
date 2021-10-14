<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width"/>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Blood Bank</title>
<style type="text/css">
h1{
text-align:centre;
margin-top:10px;
}

</style>
</head>
<body>
<h1>Donor Registration</h1>
<%@ include file="header.html" %>

<div>
	<c:if test="${errorMsg.length()!=0}">
		<div class="alert alert-danger">
		This can be caused by
			<ul >
				<li >All fields are required</li>
				<li > Age between 18 and 70 </li>
				<li >email must be unique</li>
			</ul>
		</div>
	</c:if>
</div>
<div>
	<form:form action="/donorRegisteration" modelAttribute="donorObj" method="post">
		<div>
			<label for="name">Name</label>
			<form:input path="name"/>
			<form:errors path="name" cssStyle="color:#ff0000;"></form:errors>
		</div>
		<div>
			<label for="age">Age</label>
			<form:input path="age"/>
			<form:errors path="age" cssStyle="color:#ff0000;"></form:errors>
		</div>
		<div>
			<label for="address">location</label>
			<form:input path="address"/>
		</div>
		<div>
			<label for="phoneNumber">email</label>
			<form:input path="phoneNumber"/>
		</div>
		<div>
			<label for="bloodGrp">Blood Group</label>
			<form:select path="bloodGrp">
				<form:option value="O+">O+</form:option>
				<form:option value="O-">O-</form:option>
				<form:option value="A+">A+</form:option>
				<form:option value="A-">A-</form:option>
				<form:option value="B+">B+</form:option>
				<form:option value="B-">B-</form:option>
				<form:option value="AB+">AB+</form:option>
				<form:option value="AB-">AB-</form:option>
			</form:select>
		</div>
		<div>
			<label for="donationDate">Last Donation Date</label>
			<form:input type="date" path="donationDate"/>
		</div>
		<div>
			<input type = "submit" value = "Register">
		</div>
	</form:form>
</div>
</body>
</html>