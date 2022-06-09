package com.citiustech.code;

public class Calculator {

	public int add(int x, int y) {
		try { Thread.sleep(5000); } catch(Exception e) { }
		return x + y;
	}
	
	public int sub(int x, int y) {
		return x - y;
	}
}
