<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.gqt.model.car" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	List<car> carList = (List)session.getAttribute("scarList");

	for(car x:carList){
		out.println(x.getUsername()+" "+x.getCarModel()+" "+x.getCarType()+" "+x.getCarRegistrationNumber()+" "+x.getServiceType()+" "+x.getStatus());
	}
	

%>
</body>
</html>