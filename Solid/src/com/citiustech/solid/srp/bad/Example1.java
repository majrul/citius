package com.citiustech.solid.srp.bad;

/*
 * This code basically has 3 stake holders
 * 1. Payroll
 * 2. HR
 * 3. IT/Infra
 * 
 * Payroll system might require some change to be done for salary processing
 * HR might introduce new policies related to work hours from time to time
 * IT/Infra might change the Database based on the infrastructure
 * 
 * Assume, calculateMonthlyTimeSheet() is used internally by calculateMonthlySalary method
 * 
 * Now an intentional change in one method can have an unintentional impact on other methods
 * It's very important to test the impact of the change whether we are following SRP or not
 */
class Employee {
	
	public double calculateMonthlySalary() {
		double hours = calculateMonthlyTimesheet();
		return 0;
	}
	
	public double calculateMonthlyTimesheet() {
		return 0;
	}

	public void saveChanges() {
		
	}
	
}
public class Example1 {

}
