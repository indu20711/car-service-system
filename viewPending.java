package com.gqt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gqt.model.car;


public class ViewPending extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		car tempCar = new car();
		List<car> carList = tempCar.viewPending();
		
		HttpSession session = request.getSession();
		session.setAttribute("scarList", carList);
		System.out.println("control");
		response.sendRedirect("/car-service-system/viewPendingSuccessjsp.jsp");
			
	}

}

