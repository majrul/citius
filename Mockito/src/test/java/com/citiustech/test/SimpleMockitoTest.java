package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimpleMockitoTest {

	@Test
	void test() {
		ArrayList<String> mockList = Mockito.mock(ArrayList.class);
		
		mockList.add("Java");
		mockList.add("Python");
		mockList.add(".NET");
		
		//Mockito.when(mockList.size()).thenReturn(3);
		//assertEquals(3, mockList.size());
		
		
		ArrayList<String> spyList = Mockito.spy(new ArrayList<>());
		
		spyList.add("Java");
		spyList.add("Python");
		spyList.add(".NET");
		//spyList.add("JavaScript");
		
		assertEquals(3, spyList.size());
		
		Mockito.when(spyList.size()).thenReturn(5);
		assertEquals(3, spyList.size());
	}

}
