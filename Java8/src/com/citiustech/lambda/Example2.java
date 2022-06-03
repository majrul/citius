package com.citiustech.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class Example2 {

	public static void main(String[] args) {
		Function<String, Integer> f = Integer::parseInt;
		Integer i = f.apply("100");
		System.out.println(i);
		
		Function<String, Integer> f2 = (str) -> Integer.parseInt(str);
		Integer i2 = f2.apply("12345");
		System.out.println(i2);
		
		ToIntFunction<String> f3 = Integer::parseInt;
		int i3 = f3.applyAsInt("67890");
		System.out.println(i3);
		
		List<String> list = Arrays.asList("Java", "Oracle", "Python");
		//list.forEach(str -> System.out.println(str));
		list.forEach(System.out::println);
		
		//Identify which functional interface you will use for calling
		// String class's toUpperCase method
		String str = "Majrul";
		String newstr = str.toUpperCase();
		
		Supplier<String> s = () -> str.toUpperCase();
		String s2 = s.get();
		System.out.println(s2);
		
		Supplier<String> s3 = str::toUpperCase;
		String s4 = s3.get();
		System.out.println(s4);
		
		Function<String, String> ss = (input) -> input.toUpperCase();
		String output = ss.apply("Citius");
		
		//using the right functional interface execute the add method of Calculator class
		Calculator c = new Calculator();
		IntBinaryOperator cc = c::add;
		int result = cc.applyAsInt(10, 20);
		System.out.println(result);
		
		//Is there any alternative to this?
		ToIntFunction<int[]> sumFunc = c::sum;
		int sum = sumFunc.applyAsInt(new int[] {10, 20, 30, 40, 50});
		System.out.println(sum);
		
		String username = "majrul";
		Predicate<String> condition1 = (uname) -> uname.equals("majrul");
		boolean one = condition1.test(username);
		
		//String password = "12345";
		//Predicate<String> condition2 = (upass) -> upass.equals("123");
		//boolean two = condition2.test(password);
		
		//boolean isValid = condition1.and(condition2);
		//System.out.println();
	}
}

class Calculator {
	
	int add(int x, int y) {
		return x + y;
	}
	
	int sum(int... nos) {
		int sum = 0;
		for(int no: nos)
			sum += no;
		return sum;
	}
}
