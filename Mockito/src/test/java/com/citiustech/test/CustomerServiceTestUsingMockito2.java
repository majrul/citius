package com.citiustech.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepository;
import com.citiustech.repository.CustomerRepositoryUsingJdbc;
import com.citiustech.service.CustomerService;
import com.citiustech.service.CustomerService.Status;
import com.citiustech.service.EmailNotificationService;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTestUsingMockito2 {

	@Spy
	CustomerRepository customerRepository = new CustomerRepository();
	
	@Mock
	EmailNotificationService emailNotificationService;
	
	@InjectMocks
	CustomerService customerService;
	
	@Test
	public void registerCustomer_shouldBeSuccessful() {
		
		//Mockito.when(customerRepository.isCustomerPresent(Mockito.anyString())).thenReturn(false);
		Mockito.doReturn(false).when(customerRepository).isCustomerPresent(Mockito.anyString());
		Mockito.doNothing().when(emailNotificationService).sendMail(Mockito.any(Customer.class));
		
		Customer customer = new Customer(456, "Ed", "ed@gmail.com");
		Status status = customerService.register(customer);
		
		assertEquals(Status.SUCCESS, status);
		assertEquals(4, customerRepository.count());
	}
	
}
