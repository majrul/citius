package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.citiustech.code.Calculator;

public class CalculatorTest {

	@Test
	void testAdd() {
		Calculator c = new Calculator();
		int actualValue = c.add(10, 20);
		int expectedValue = 30;
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void testAddV2() {
		Calculator c = new Calculator();
		int actualValue = c.add(10, 20);
		int expectedValue = 30;
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testAddV3() {
		Calculator c = new Calculator();
		assertTimeout(Duration.ofSeconds(1), () -> c.add(10, 20));
	}

	@Test
	//@Disabled
	@RepeatedTest(10)
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
