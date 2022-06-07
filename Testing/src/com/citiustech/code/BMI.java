package com.citiustech.code;

import java.util.Comparator;
import java.util.List;

public class BMI {

	public static double calculateBMI(Person person) {
		double height = person.getHeight();
		double weight = person.getWeight();
		
		if(height <= 0 || weight <= 0)
			throw new BMIException("Incorrect Data!");
		
		double bmi = weight / (height * height);
		return Math.round(bmi);
	}
	
	public static boolean isDietRecommended(Person person) {
		double bmi = calculateBMI(person);
		if(bmi < 25)
			return false;
		return true;
	}
	
	public static double[] getBMIValues(List<Person> persons) {
		return persons
				.stream()
				.mapToDouble(BMI::calculateBMI)
				.toArray();
	}
	
	public static Person findPersonWithLowestBMI(List<Person> persons) {
		return persons
				.stream()
				.sorted(Comparator.comparing(BMI::calculateBMI))
				.reduce((first, second) -> first)
				.orElseThrow(BMIException::new);
	}
}
