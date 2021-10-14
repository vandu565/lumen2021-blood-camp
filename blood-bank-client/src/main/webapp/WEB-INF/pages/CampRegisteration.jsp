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
</head>
<style>
h1{
text-align:center;
margin-top:50px;
}
.main{
text-align:center;
}</style>
<body>

<%@ include file="header.html" %>
<h1>Donation Camp Registration</h1>

<div class="main">
	<form:form action="/registerCamp" modelAttribute="campObj" method="post">
		<div>
			<label for="name">name</label>
			<form:input path="name"/>
			<form:errors path="name" cssStyle="color:#ff0000;"></form:errors>
		</div>
		<div>
			<label for="location">location</label>
			<form:input path="location"/>
		</div>
		<div>
			<label for="organisingDate">Date of Held</label>
			<form:input type="date" path="organisingDate"/>
		</div>
		<div>
			<input type = "submit" value = "Register">
		</div>
	</form:form>
</div>
</body>
</html>