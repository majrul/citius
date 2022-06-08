package com.citiustech.repository;

import java.util.ArrayList;
import java.util.List;

import com.citiustech.entity.Customer;

//assumption: we are using jdbc/hibernate/jpa
public class CustomerRepository {

	private List<Customer> customers;
	
	public CustomerRepository() {
		customers = new ArrayList<Customer>();
		customers.add(new Customer(111, "John", "john@gmail.com"));
		customers.add(new Customer(222, "Smith", "smith@gmail.com"));
		customers.add(new Customer(333, "Jack", "jack@gmail.com"));
	}

	public boolean isCustomerPresent(String email) {
		System.out.println("isCustomerPresent");
		return customers
				.stream()
				.anyMatch(c -> c.getEmail().equals(email));
		//code of firing select query here in a real app
		/*if(email.equals("majrul@gmail.com"))
			return true;
		return false;*/
	}
	
	public int save(Customer customer) {
		System.out.println("save");
		if(customer.getName() == null)
			throw new RuntimeException("Invalid Data");
		else {
			customers.add(customer);
			return customer.getId();
		}
	}
	
	public int count() {
		return customers.size();
	}
}
