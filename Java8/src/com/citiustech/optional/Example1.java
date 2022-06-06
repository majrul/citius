package com.citiustech.optional;

import java.util.Optional;

public class Example1 {

	public static void main(String[] args) {
		Optional<String> op1 = Optional.empty();
		System.out.println(op1.isPresent());
		//System.out.println(op1.get()); //NoSuchElementException
	
		Optional<String> op2 = Optional.of(args[0]);
		System.out.println(op2.isPresent());
		System.out.println(op2.get());
		
		String str = null; //String str = "Akshay";
		//Optional<String> op3 = Optional.of(str); //NullPointerException
		Optional<String> op3 = Optional.ofNullable(str);
		System.out.println(op3.isPresent());
		//System.out.println(op3.get()); //NoSuchElementException
		System.out.println(op3.orElse("Majrul"));
		//op3.orElseThrow(() -> new MyOwnException("No data available!"));
		//op3.orElseThrow(MyOwnException::new);
	
		System.out.println("-----------------------");
		String s = "Krishna Yadav";//String s = null;
		Optional<String> op4 = Optional.ofNullable(s);
		System.out.println(op4.orElse(getData()));
		
		Optional<String> op5 = Optional.ofNullable(s);
		System.out.println(op4.orElseGet(() -> getData()));
	}
	
	static String getData() {
		System.out.println("inside getData");
		return "Majrul Ansari";
	}
}

class MyOwnException extends RuntimeException {

	public MyOwnException() {
	}

	public MyOwnException(String msg) {
		super(msg);
	}
}