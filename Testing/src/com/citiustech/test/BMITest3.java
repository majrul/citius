package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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

	@ParameterizedTest
	@MethodSource("bmiArguments")
	void calculateBMI_FromSomeInput_shouldReturnExpectedValue(double weight, double height, double expected) {
		double actual = BMI.calculateBMI(weight, height);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> bmiArguments() {
		return Stream.of(
				Arguments.of(70, 1.7, 24),
				Arguments.of(90, 1.7, 31),
				Arguments.of(120, 1.7, 42));
	}
	
}
