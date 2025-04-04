package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gqt.model.car;


public class ServiceRequest extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String carRegistrationNumber = request.getParameter("carRegistrationNumber");
		String serviceType = request.getParameter("serviceType");
		
		car tempcar = new car();
		tempcar.setCarRegistrationNumber(carRegistrationNumber);
		tempcar.setServiceType(serviceType);
		
		int status = tempcar.serviceType();
		
		if(status==0) {
			response.sendRedirect("/car-service-system/serviceRequestFailed.jsp");
			
		}
		else {

			response.sendRedirect("/car-service-system/serviceRequesrSuccess.jsp");
		}
		
	}

}

