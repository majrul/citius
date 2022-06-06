package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.citiustech.code.Calculator;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator c = new Calculator();
		int actualValue = c.add(10, 20);
		int expectedValue = 30;
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testSub() {
		Calculator c = new Calculator();
		int actualValue = c.sub(10, 20);
		int expectedValue = -10;
		assertEquals(expectedValue, actualValue);
	}

	/*@Test
	void testAddBadVersion() {
		Calculator c = new Calculator();
		int result = c.add(10, 20);
		///NO NO NO NO NO
		//no println should be there in our test cases
		System.out.println(result);
	}*/
}
