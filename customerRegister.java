package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqt.model.Customer;

/**
 * Servlet implementation class customerRegister
 */
public class customerRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("Name");
		String UserName = request.getParameter("UserName");
		String Password = request.getParameter("Password");
		String Email = request.getParameter("Email");
		Customer tempCustomer = new Customer(Name, UserName, Password, Email);
		int rows = tempCustomer.CustomerRegister();
		if(rows==1) {
			response.sendRedirect("/car-service-system/success.jsp");
		}
		else {
			response.sendRedirect("/car-service-system/failure.jsp");
		}
	}
}
