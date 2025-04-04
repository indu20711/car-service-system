package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	
		private String adminUsername;
		private String adminPassword;
		Connection con = null;
		
		public String getAdminUsername() {
			return adminUsername;
		}
		public void setAdminUsername(String adminUsername) {
			this.adminUsername = adminUsername;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		public Connection getCon() {
			return con;
		}
		public void setCon(Connection con) {
			this.con = con;
		}
		public Admin() {
			super();
		}
		public Admin(String adminUsername, String adminPassword, Connection con) {
			super();
			this.adminUsername = adminUsername;
			this.adminPassword = adminPassword;
			this.con = con;
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
		
		public int adminLogin() {
			
			try {
				
				String s = "select * from admin where username=?";
				PreparedStatement pstmt = con.prepareStatement(s);
				pstmt.setString(1, adminUsername);
				ResultSet res = pstmt.executeQuery();
				
				if(res.next()) {
					if(res.getString(2).equals(adminPassword)) {
						return 1;
					}
					else {
						return 0;
					}
				}
				else {
					return -1;
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
			
			
		}

}
