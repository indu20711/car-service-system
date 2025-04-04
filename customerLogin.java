package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Customer;





public class customerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String UserName = request.getParameter("UserName");
	String Password = request.getParameter("Password");
	
	Customer tempCustomer = new Customer();
	
	tempCustomer.setUserName(UserName);
	tempCustomer.setPassword(Password);
	int status = tempCustomer.customerLogin();
	String name = tempCustomer.getName();
	System.out.println("Controller "+UserName+" "+Password);
	
	HttpSession session = request.getSession();
	session.setAttribute("sname", name);//String sname = name 
	session.setAttribute("susername", UserName);
	if(status==1) {
		response.sendRedirect("/car-service-system/customerLoginSuccess.jsp");
	}
	else if (status == 0){
		response.sendRedirect("/car-service-system/customerInvalidPassword.jsp");
	}
	else {
		response.sendRedirect("/car-service-system/customerInvalidUserName.jsp");
	}
}
}
