package com.citiustech.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.citiustech.entity.Customer;

public class CustomerRepositoryUsingJdbc {

	public boolean isCustomerPresent(String email) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.driver.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			String sql = "select count(id) from customer where email = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if(rs.next())
				return (Long) rs.getLong(1) == 1 ? true : false;
			else
				return false;
		}
		catch(Exception e) {
			throw new RuntimeException(e);
			//return false;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
		
	}
	
	public int save(Customer customer) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.driver.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			PreparedStatement st = conn.prepareStatement("insert into customer values(?, ?, ?)");
			st.setInt(1, customer.getId());
			st.setString(2, customer.getName());
			st.setString(3, customer.getEmail());
			st.executeUpdate();
			
			return customer.getId();
		}
		catch(Exception e) {
			//throw some user defined exception
			return 0;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
