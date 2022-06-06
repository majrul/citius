package com.citiustech.solid.dip.good;

import java.time.LocalTime;

class Greeting {

	LocalTime time;
	
	Greeting(LocalTime time) {
		this.time = time;
	}
	
	void greet() {
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
		//LocalTime time = LocalTime.now();
		LocalTime time = LocalTime.of(7,30,0);
		Greeting g = new Greeting(time);
		g.greet();
	}
}
