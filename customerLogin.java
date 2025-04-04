package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqt.model.car;


public class UpdateStatus extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String carRegistrationNumber = request.getParameter("carRegistrationNumber");
		
		String serviceStatus = request.getParameter("status");
		
		
		car tempcar = new car();
		tempcar.setCarRegistrationNumber(carRegistrationNumber);
		tempcar.setServiceType(serviceStatus);

		System.out.println("controller"+serviceStatus+" "+carRegistrationNumber);
		int status = tempcar.updateService();

		System.out.println("controller"+serviceStatus+" "+carRegistrationNumber);
		if(status==1) {
			response.sendRedirect("/car-service-system/updateStatusSuccess.jsp");
			
		}
		else {
			response.sendRedirect("/car-service-system/updateStatusFailed.jsp");
		}
		
	}

}

