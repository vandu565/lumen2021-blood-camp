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
<style>
h1{
text-align:center;
margin-top:10px;}
.head{
text-align: center;
margin-top:30px;
margin-left:450px;
}
h3{
 text-align: center;
margin-top:30px;
}
</style>
</head>
<body>
<%@ include file="header.html" %>
<h1 class="btn btn-success head">Registered Successfully !!!</h1>
<h3 class="btn btn-success">Your Registration Id  is ${object.id}</h3>
</body>
</html>