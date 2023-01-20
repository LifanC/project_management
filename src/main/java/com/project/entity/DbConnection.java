package com.project.entity;

import java.sql.*;

public class DbConnection {
	public static Connection getConnection(){
		Connection cn=null;
			try {
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_object","root","1234");
				cn.setAutoCommit(true);
				System.out.println("Connection 成功");
			} catch (SQLException e) {
				System.out.println("SQL Error " + e.getMessage());
				e.printStackTrace();
			}
			
		return cn;
	}

}
