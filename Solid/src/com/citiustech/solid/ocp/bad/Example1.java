package com.citiustech.solid.ocp.bad;

import com.citiustech.solid.ocp.bad.Employee.Type;

class Employee {
	int id;
	Type type;
	
	static enum Type {
		FULL_TIME, CONSULTANT;
	}
}

class SalaryCalculator {
	
	private TaxCalculator taxCalculator;
	
	public double calculateSalary(Employee emp) {
		double tax = taxCalculator.calculateTax(emp);
		return 0;
	}
}

/*
 * The problem is we will have to change the calculateTax method everytime
 * a new type of employee gets introduced
 */
class TaxCalculator {
	
	public double calculateTax(Employee emp) {
		if(emp.type == Type.FULL_TIME)
			return 0;
		else if(emp.type == Type.CONSULTANT)
			return 0;
		return 0;
	}
}
public class Example1 {

}
