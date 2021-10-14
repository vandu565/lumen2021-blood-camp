<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<style type="text/css">
table{
border: 2px solid blue;
margin-left: auto;
margin-right: auto;
border-collapse: collapse;
}
tr,th,td{
border: 2px solid black;
 margin-top:40px;
 padding:2px; 
}
h3{
text-align: center;
}
h1{
text-align:centre;
margin-top:10px;
}

</style>
</head>
<body>

<%@ include file="header.html" %>
<h3>AVAILABLE DONORS LIST</h3>  
<c:if test="${fn:length(donors) == 0}">
	<h2>No Donors have the ${bloodgrp} blood group</h2>
</c:if>
<c:if test="${fn:length(donors) > 0}">
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Blood Group</th>
		<th>Address</th>
		<th>Phone Number</th>
		<th>Date</th>
	</tr>
	<c:forEach items="${donors}" var="donor">
		<tr>
			<td>${donor.id}</td>
			<td>${donor.name}</td>
			<td>${donor.age}</td>
			<td>${donor.bloodGrp}</td>
			<td>${donor.address}</td>
			<td>${donor.phoneNumber}</td>
			<td>${donor.donationDate}</td>
		</tr>
	
	</c:forEach>
</table>
</c:if>
</body>
</html>