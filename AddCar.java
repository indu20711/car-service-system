package com.gqt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.car;



public class AddCar extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String carModel = request.getParameter("carModel");
		String carType = request.getParameter("carType");
		String carRegistrationNumber = request.getParameter("carRegistrationNumber");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("susername");
		
		car tempcar = new car();
		tempcar.setUsername(username);
		tempcar.setCarModel(carModel);
		tempcar.setCarType(carType);
		tempcar.setCarRegistrationNumber(carRegistrationNumber);

		System.out.println("Controller "+username+" "+carModel+" "+carRegistrationNumber);
		int status=tempcar.addcar();
		System.out.println("Controller "+username+" "+carModel+" "+carRegistrationNumber);
		if(status==0) {
			response.sendRedirect("/car-service-system/addCarFailure.jsp");
			
		}
		else {
			response.sendRedirect("/car-service-system/addCarSuccess.jsp");
		}
		
	}

}

