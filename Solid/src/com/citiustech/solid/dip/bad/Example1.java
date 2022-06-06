package com.citiustech.solid.dip.bad;

import java.time.LocalTime;

class Greeting {
	
	void greet() {
		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		if(hour >= 5 && hour < 12)
			System.out.println("Good Morning!");
		else if(hour >= 12 && hour < 16)
			System.out.println("Good Afternoon!");
		else if(hour >= 16 && hour < 21)
			System.out.println("Good Evening!");
		else
			System.out.println("Good Night!");
	}
}
public class Example1 {

	public static void main(String[] args) {
		Greeting g = new Greeting();
		g.greet();
	}
}
