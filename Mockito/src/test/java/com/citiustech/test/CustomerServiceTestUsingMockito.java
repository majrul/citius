package com.citiustech.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepository;
import com.citiustech.repository.CustomerRepositoryUsingJdbc;
import com.citiustech.service.CustomerService;
import com.citiustech.service.CustomerService.Status;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTestUsingMockito {

	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerService customerService;
	
	@Test
	public void registerCustomer_shouldBeSuccessful() {
		
		Mockito.when(customerRepository.isCustomerPresent(Mockito.anyString())).thenReturn(false);
		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(456);
		
		Customer customer = new Customer(456, "Ed", "ed@gmail.com");
		Status status = customerService.register(customer);
		
		assertEquals(Status.SUCCESS, status);
	}
	
	@Test
	public void registerCustomer_shouldFail_WithAnException() {
		
		Mockito.when(customerRepository.isCustomerPresent(Mockito.anyString())).thenReturn(false);
		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenThrow(RuntimeException.class);
		
		Customer customer = new Customer(456, "Ed", "ed@gmail.com");
		//Status status = customerService.register(customer);
		
		assertThrows(RuntimeException.class, () -> customerService.register(customer));
	}

	@Test
	public void registerCustomer_should_NotInvoke_Save_MoreThan_Once() {
		
		Mockito.when(customerRepository.isCustomerPresent(Mockito.anyString())).thenReturn(false);
		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenThrow(RuntimeException.class);
		
		Customer customer = new Customer(456, "Ed", "ed@gmail.com");
		Status status = customerService.register(customer);
		
		//assertThrows(RuntimeException.class, () -> customerService.register(customer));

		Mockito.verify(customerRepository, Mockito.times(1)).save(Mockito.any(Customer.class));
	}
}
