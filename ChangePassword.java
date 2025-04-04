package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqt.model.Customer;
import com.gqt.model.car;

public class ChangePassword extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer tempcustomer = new Customer();
		tempcustomer.setUserName(username);
		tempcustomer.setPassword(password);
		
		int status = tempcustomer.changePassword();

		System.out.println("controller"+username+" "+password);
		
		if(status==1) {

			response.sendRedirect("/car-service-system/changePasswordSuccess.jsp");
			
		}
		else {

			response.sendRedirect("/car-service-system/changePasswordFailed.jsp");
		}
		
	}

}

