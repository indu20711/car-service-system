<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name = (String)session.getAttribute("sname");
out.println("Dear "+name+", you have successfully logged in");
%>
<a href="addCar.html" >Add Car Details</a> <br><br>
<a href="editCar.html" >Edit Car Details</a> <br><br>
<a href="serviceRequest.html" >Request Service</a> <br><br>
<a href="checkStatus.html" >Check Status</a> <br><br>
<a href="changePassword.html" >Password Change</a> <br><br>
<a href="index.html" >Logout</a> <br><br>
</body>
</html>