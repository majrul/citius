package com.citiustech.service;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepository;
import com.citiustech.repository.CustomerRepositoryUsingJdbc;

public class CustomerService {

	private CustomerRepository customerRepository;
	private EmailNotificationService emailNotificationService;
	
	public CustomerService(CustomerRepository customerRepository, EmailNotificationService emailNotificationService) {
		this.customerRepository = customerRepository;
		this.emailNotificationService = emailNotificationService;
	}
	
	public Status register(Customer customer) {
		if(customerRepository.isCustomerPresent(customer.getEmail()))
			return Status.FAILURE;
		else {
			int id = customerRepository.save(customer);
			emailNotificationService.sendMail(customer);
			return Status.SUCCESS;
		}
	}
	
	//assumption:
	//developer has done a mistake here
	//instead of throwing exception, 
	//he/she is returning status as success even in case of failure
	
	//another case:
	//developer has done one more mistake here
	//he/she is calling save method multiple times
	/*public Status register(Customer customer) {
		if(customerRepository.isCustomerPresent(customer.getEmail()))
			return Status.FAILURE;
		else {
			try {
				int id = customerRepository.save(customer);
			}
			catch(Exception e) {
				//did something
				try {
					int id = customerRepository.save(customer);
				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
				e.printStackTrace();
			}
			return Status.SUCCESS;
		}
	}*/
	
	public static enum Status {
		SUCCESS, FAILURE;
	}
}
