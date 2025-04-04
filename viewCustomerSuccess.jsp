<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gqt.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	List<Customer> customerList = (List)session.getAttribute("scustomerList");

	for(Customer x:customerList){
		out.println(x.getName()+" "+x.getUsername()+" "+x.getEmail());
	}

%>
</body>
</html>