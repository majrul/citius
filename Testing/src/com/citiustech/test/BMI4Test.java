package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

import com.citiustech.code.BMI;
import com.citiustech.code.Person;

class BMI4Test {

	private String env = "dev";
	
	@Test
	void isDietRecommended_ShouldReturnFalse() {
		//given
		assumeTrue(env.equals("qa"));
		
		Person p = new Person(70, 1.7);
		
		//when
		boolean recommended = BMI.isDietRecommended(p);
		
		//then
		assertFalse(recommended);		
	}

	@Test
	void isDietRecommended_ShouldReturnTrue() {
		//given
		Person p = new Person(80, 1.7);
		
		//when
		boolean recommended = BMI.isDietRecommended(p);
		
		//then
		assertTrue(recommended);		
	}


}
