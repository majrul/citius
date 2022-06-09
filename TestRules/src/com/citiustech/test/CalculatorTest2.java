package com.citiustech.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import com.citiustech.code.Calculator;

public class CalculatorTest2 {

	@DI
	private Calculator c;

	@Rule
	public DIRule diRule = new DIRule(this);
	
	@Test
	public void testAdd() {
		int actualValue = c.add(10, 20);
		int expectedValue = 30;
		assertEquals(expectedValue, actualValue);
	}
	
}
