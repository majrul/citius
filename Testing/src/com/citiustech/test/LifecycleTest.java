package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LifecycleTest {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("before all the test cases");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("after all the test cases");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("before each test case");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("after each test case");
	}

	@Test
	@DisplayName("my testcase no. 1")
	@Order(1)
	public void xyz() {
		System.out.println("test case 1");
	}
	
	@Test
	@DisplayName("my testcase no. 2")
	@Order(2)
	public void abc() {
		System.out.println("test case 2");
	}

}
