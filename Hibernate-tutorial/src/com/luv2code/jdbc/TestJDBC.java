package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
			
			String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?allowPublicKeyRetrieval=true&useSSL=false&"
					+ "serverTimezone=UTC";
			
			String user="hbstudent";
			String pass="hbstudent";
			
		try {
			
			System.out.println("Connecting to database: "+jdbcurl);
			
			Connection conn = DriverManager.getConnection(jdbcurl,user,pass);
			
			System.out.println(conn);
			
			System.out.println("Connection successfull!!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
