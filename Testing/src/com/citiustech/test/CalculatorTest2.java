package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import com.citiustech.code.Calculator;

public class CalculatorTest2 {

	@Rule
	private Timeout timeout = Timeout.seconds(2);
	
	@Rule
	private TestName testName = new TestName();
	
	@Test
	public void testAdd() {
		System.out.println(testName.getMethodName());
		Calculator c = new Calculator();
		int actualValue = c.add(10, 20);
		int expectedValue = 30;
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testAddV2() {
		System.out.println(testName.getMethodName());
		Calculator c = new Calculator();
		int actualValue = c.add(100, 200);
		int expectedValue = 300;
		assertEquals(expectedValue, actualValue);
	}

}
