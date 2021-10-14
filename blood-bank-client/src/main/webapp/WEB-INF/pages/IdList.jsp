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
text-align:center;
margin-top:40px;
}
h5{
text-align:center;
}
form{
text-align:center;
margin-top:20px;
}
</style>

<body>
<%@ include file="header.html" %>
<h3>LIST OF ALL DONORS IDs</h3>
<h5>Please Select An ID To Update</h5>
<form:form action="/updateform" modelAttribute="donorObj" method="get">
		<div>
			<form:label path="id"></form:label>
			<form:select path="id">
			<c:forEach items="${ids}" var="eachid">
				<form:option value="${eachid}">${eachid}</form:option>
			</c:forEach>
			</form:select>
		</div>
		<div>
			<input type = "submit" value = "Search">
		</div>
</form:form>
</body>
</html>