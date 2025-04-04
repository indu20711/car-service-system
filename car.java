package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class car {
	private String username;
	private String carModel;
	private String carType;
	private String CarRegistrationNumber; 
	private String ServiceType;
	private String Status;
	Connection con = null;
	 
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getCarModel() {
		return carModel;
	}
	
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	public String getCarType() {
		return carType;
	}
	
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public String getCarRegistrationNumber() {
		return CarRegistrationNumber;
	}
	
	public void setCarRegistrationNumber(String carRegistrationNumber) {
		CarRegistrationNumber = carRegistrationNumber;
	}
	
	public String getServiceType() {
		return ServiceType;
	}
	
	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String status) {
		Status = status;
	}
	
	public car() {
		super();
	}
	
	public car(String username, String carModel, String carType, String carRegistrationNumber, String serviceType,
			String status) {
		super();
		this.username = username;
		this.carModel = carModel;
		this.carType = carType;
		CarRegistrationNumber = carRegistrationNumber;
		ServiceType = serviceType;
		Status = status;
	}
	
	public String getUsername() {
		return username;
	}
	
	
	{
		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system_march", "root", "honey1234");
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int addCar() {
		
		try {
			
			String s = "insert into car values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			pstmt.setString(2, carModel);
			pstmt.setString(3, carType);
			pstmt.setString(4, CarRegistrationNumber);
			pstmt.setString(5, "null");
			pstmt.setString(6, "null");
			int rows = pstmt.executeUpdate();

			System.out.println("model"+username+" "+carModel+" "+carType+" "+CarRegistrationNumber);
			return rows;
			
		}
		
		catch (Exception e) {

			e.printStackTrace();
		}
		return 0;
	}
	
	public int editCar() {
		
		try {
			
			String s = "update car set car_model=?,car_type=?,car_registration_number=? where username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, carModel);
			pstmt.setString(2, carType);
			pstmt.setString(3, CarRegistrationNumber);
			pstmt.setString(4, username);
			int rows = pstmt.executeUpdate();

			System.out.println("model"+username+" "+carModel+" "+carType+" "+CarRegistrationNumber);
			return rows;
			
		}
		
		catch (Exception e) {

			e.printStackTrace();
		}
		return 0;
	}
	
	public int serviceType() {
		
		try {
			
			String s="update car set service_type=?,status=? where car_registration_number=?";
			PreparedStatement pstmt =con.prepareStatement(s);
			
			pstmt.setString(1, ServiceType);
			pstmt.setString(2, "Pending");
			pstmt.setString(3, CarRegistrationNumber);
			
			int rows = pstmt.executeUpdate();
			
			return rows;
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public String checkStatus() {
		
		try {
			
			String s = "select * from car where car_registration_number=?";
			PreparedStatement pstmt =con.prepareStatement(s);
			
			pstmt.setString(1, CarRegistrationNumber);
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				return res.getString(6);
			}
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

		
	}

	
	public List<car> viewPending() {
		
		try {
			
			
			ArrayList<car> customerPendingList = new ArrayList();
			String s = "select * from car where status=?";
			PreparedStatement pstmt =con.prepareStatement(s);
			pstmt.setString(1, "Pending");
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				username = res.getString(1);
				carModel = res.getString(2);
				carType = res.getString(3);
				CarRegistrationNumber = res.getString(4);
				ServiceType = res.getString(5);
				Status = res.getString(6);
				
				customerPendingList.add(new car( username,  carModel,  carType,  CarRegistrationNumber,  ServiceType, Status));
				System.out.println(customerPendingList);
			}
			return customerPendingList;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

	public int updateService() {
		
		try {
			
			String s = "update car set status=? where car_registration_number=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, Status);
			pstmt.setString(2, CarRegistrationNumber);
			int rows = pstmt.executeUpdate();

			System.out.println("model"+Status+" "+CarRegistrationNumber);
			return rows;
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}
