package com.citiustech.solid.ocp.good;

class Employee {
	int id;
	Type type;
	
	static enum Type {
		FULL_TIME, CONSULTANT;
	}
}

interface TaxCalculator {
	
	public double calculateTax(Employee emp);
}

class FullTimeTaxCalculator implements TaxCalculator {

	@Override
	public double calculateTax(Employee emp) {
		return 0.20;
	}
}

class ConsultantTaxCalculator implements TaxCalculator {

	@Override
	public double calculateTax(Employee emp) {
		return 0.30;
	}
	
}

class TaxCalculatorFactory {

	//if i use Reflection API properly, i will be able to somehow remove the if condition
	//and dynamically return object of relevant class
	public static TaxCalculator getInstance(Employee emp) {
		if(emp.type == Employee.Type.FULL_TIME)
			return new FullTimeTaxCalculator();
		else if(emp.type == Employee.Type.CONSULTANT)
			return new ConsultantTaxCalculator();
		else
			//throw some exception
			return null;
	}
}

class SalaryCalculator {
	
	
	public double calculateSalary(Employee emp) {
		TaxCalculator taxCalculator = TaxCalculatorFactory.getInstance(emp);
		double tax = taxCalculator.calculateTax(emp);
		return 0;
	}
}


public class Example1 {

}
