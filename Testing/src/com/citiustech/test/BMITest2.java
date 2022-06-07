package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.citiustech.code.BMI;
import com.citiustech.code.BMIException;
import com.citiustech.code.Person;

class BMITest2 {

	@Test
	void isDietRecommended_ShouldReturnFalse() {
		//given
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

	@Test
	void isDietRecommended_ShouldThrowBMIException() {
		//given
		Person p = new Person(0, 1.7);
		
		//when
		Executable e = () -> BMI.isDietRecommended(p);
		
		//then
		assertThrows(BMIException.class, e);
	}
	
	//TODO: Write test case for calculateBMI method
	@Test
	void calculateBMI_ShouldReturnExpectedValue() {
		//given
		Person p = new Person(70, 1.7);
		
		//when
		double actualBmi = BMI.calculateBMI(p);
		
		//then
		double expectedBmi = 24;
		assertEquals(expectedBmi, actualBmi);		
	}
	
	@Test
	void testing_Multiple_Assertions() {
		Person p = new Person(1.7, 70);
		
		assertEquals(60, p.getWeight());
		assertEquals(1.5, p.getHeight());
		assertEquals(25, BMI.calculateBMI(p));
		
		/*assertAll(
				() -> assertEquals(60, p.getWeight()),
				() -> assertEquals(1.5, p.getHeight()),
				() -> assertEquals(25, BMI.calculateBMI(p)));*/	
	}
	
	@Nested
	class BMINestedTest {
		
		List<Person> persons;
		
		@BeforeEach
		public void init() {
			//given
			persons = new ArrayList<>();
			persons.add(new Person(70, 1.7));
			persons.add(new Person(90, 1.7));
			persons.add(new Person(120, 1.7));
		}
		
		@Test
		public void personWithLowestBmi_ShouldReturn_ExpectedValue() {
			//when
			Person actual = BMI.findPersonWithLowestBMI(persons);
			
			//then
			Person expected = persons.get(0);
			assertEquals(expected, actual);
			
			/*//when
			Person p = BMI.findPersonWithLowestBMI(persons);
			
			//then
			assertAll(
				() -> assertEquals(70, p.getWeight()),
				() -> assertEquals(1.7, p.getHeight()));*/
		}
		
		@Test
		public void getBMIValues_ShouldReturn_ExpectedResult() {
			//when
			double[] actual = BMI.getBMIValues(persons);
			
			//then
			double[] expected = {24, 31, 42};
			assertArrayEquals(expected, actual);
		}
	}
}
