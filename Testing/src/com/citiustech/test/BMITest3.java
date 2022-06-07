package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.citiustech.code.BMI;

class BMITest3 {

	@ParameterizedTest
	@CsvSource({"70,1.7,24", "90,1.7,31", "120,1.7,42"})
	void calculateBMI_shouldReturnExpectedValue(double weight, double height, double expected) {
		double actual = BMI.calculateBMI(weight, height);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/bmi.csv", numLinesToSkip = 1)
	void calculateBMI_FromCSVFileInput_shouldReturnExpectedValue(double weight, double height, double expected) {
		double actual = BMI.calculateBMI(weight, height);
		assertEquals(expected, actual);
	}

}
