package com.demo.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnect {

	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aip","root","root");
		return conn;
	}
}
