package com.demo.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.dbconnection.DbConnect;
import com.demo.dbconnection.SQLQueries;
import com.demo.model.Account;



public class AccountDAO {

	Connection conn = null;
	public void insertAccount(Account account) {
		DbConnect dbcon = new DbConnect();
	
			try {
				conn = dbcon.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQLQueries.insertAccount);
				stmt.setString(1, account.getFirstName());
				stmt.setString(2, account.getLastName());
				stmt.setString(3, account.getAddress());
				stmt.setInt(4, account.getAge());
				stmt.setString(5, account.getEmail());
				stmt.setString(6, account.getPassword());
				stmt.executeUpdate();
				
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void deleteAccount(Account account) {
		DbConnect dbcon = new DbConnect();
		
		try {
			conn = dbcon.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SQLQueries.deleteAccount);
			stmt.setString(1, account.getFirstName());
			stmt.setString(2, account.getLastName());
			//stmt.setString(5, account.getEmail());
			//stmt.setString(6, account.getPassword());
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
		e.printStackTrace();
		}
	}
	
	public Account loginAccount(Account account) {
		DbConnect dbcon = new DbConnect();
		ResultSet rs = null;
		Account accountLogin = null;
		try {
			conn = dbcon.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SQLQueries.loginAccount);
			stmt.setString(1, account.getEmail());
			//stmt.setString(6, account.getPassword());
			rs = stmt.executeQuery();
			while(rs.next()) {
				accountLogin = new Account();
				accountLogin.setFirstName(rs.getString("firstName"));
				accountLogin.setLastName(rs.getString("lastName"));
				accountLogin.setAddress(rs.getString("address"));
				accountLogin.setAge(rs.getInt("age"));
				accountLogin.setEmail(rs.getString("email"));
				accountLogin.setPassword(rs.getString("password"));
			}
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			
		e.printStackTrace();
		}
		return accountLogin;
	}
}
