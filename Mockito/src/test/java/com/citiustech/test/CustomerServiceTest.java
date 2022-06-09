package com.citiustech.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepositoryUsingJdbc;
import com.citiustech.service.CustomerService;
import com.citiustech.service.CustomerService.Status;

public class CustomerServiceTest {

	@Test
	public void registerCustomer_shouldBeSuccessful() {
		/*CustomerRepositoryUsingJdbc customerRepository = new CustomerRepositoryUsingJdbc();
		CustomerService customerService = new CustomerService(customerRepository);
		
		Customer customer = new Customer(456, "Ed", "ed@gmail.com");
		Status status = customerService.register(customer);
		
		assertEquals(Status.SUCCESS, status);*/
	}
}
