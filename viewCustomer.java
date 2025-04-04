package com.gqt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.Customer;

public class viewCustomer extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer tempCustomer = new Customer();
		List<Customer> customerList = tempCustomer.viewCustomer();
		
		HttpSession session = request.getSession();
		session.setAttribute("scustomerList", customerList);
		
		response.sendRedirect("/car-service-system/viewCustomerSuccess.jsp");
		
	}

}

