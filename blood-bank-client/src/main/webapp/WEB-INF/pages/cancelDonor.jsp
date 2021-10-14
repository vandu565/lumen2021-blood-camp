<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
text-align:centre;
margin-top:10px;
}
form{
text-align: center;
margin-top:30px;

}

h2{
text-align: center;
margin-top:50px;
}</style>
<body>
<%@ include file="header.html" %>
<h2>Donor De-Registration</h2>
<div>

	<form:form action="/delete" modelAttribute="donorObj" method="get">
		<div>
			<label for="id">Please Enter Registration Id </label>
			<form:input path="id"/>
		</div>
		<div>
			<input type = "submit" value = "Remove">
		</div>
	</form:form>
</div>
</body>
</html>