<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
margin-top:50px;}
div{
text-align: center;
margin-top:30px;}
</style>
<body>
<%@ include file="header.html" %>
<h3>SEARCH FOR DONORS</h3>

<div>
<a class="btn btn-success" href="searchbybloodgroup">Search by Blood Group</a>
<a  class="btn btn-success" href="searchbyaddress">Search by Address</a>
</div>
</body>
</html>