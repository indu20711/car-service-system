<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin:0px;
		padding:0px;
		box-sizing:border-box;
	}
	body{
		background-color: black;
		text-align:center;
	}
	h1{
		background-color:white;
		text-align:center;
		padding:15px;
	}
	div{
		margin:180px 400px;
		padding:50px;
		background-color: rgba(139, 0, 0, 0.7);
		font-style: italic;
		font-size:30px;
 		border: 2px solid green;
  		border-radius: 15px;
	}
	form{
		text-align :center;
	}
	input{
		padding:7px;
		margin:10px;
	}
	
</style>
</head>
<body>

	<h1>Request Service-Type</h1>
	Service Requst Failed
		
	<div>
		<form action="/car-service-system/ServiceRequest">
		<table>
		<tr>
		<td>Car Registration Number</td>
		<td><input type="text" name="carRegistrationNumber"/></td>
		</tr>
		<tr>
		<td>Service Type</td>
		<td><input type="text" name="serviceType"/></td>
		</tr>
		<tr>
		<td><input type="submit" value="Request Service"/></td>
		</tr>
		</table>
		</form>
	</div>
</body>
</html>