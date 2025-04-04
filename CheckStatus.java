package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.car;


public class CheckStatus extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String carRegistrationNumber=request.getParameter("carRegistrationNumber");
		
		car tempcar = new car();
		tempcar.setCarRegistrationNumber(carRegistrationNumber);
		
			
		String status = tempcar.checkStatus(); 
		
		HttpSession session = request.getSession();
		session.setAttribute("sstatus", status);
		System.out.println(status);
		response.sendRedirect("/car-service-system/checkStatusSuccess.jsp");
		
		
	}

}

