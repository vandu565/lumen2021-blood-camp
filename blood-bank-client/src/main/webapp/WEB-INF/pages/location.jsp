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
h3{
text-align: center;
}
form{
text-align: center;
margin-top:40px;
}
</style>
<body>
<%@ include file="header.html" %>
<h3>Search By Address</h3>
<form:form action="/address" modelAttribute="donorObj" method="get">
		<div>
			<form:label path="address"></form:label>
			<form:input type="text" path="address"/>
		</div>
		<div>
			<input type = "submit" value = "Search">
		</div>
	</form:form>
</body>
</html>