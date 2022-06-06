package com.citiustech.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your date of joining (yyyy-MM-dd)");
		String doj = s.nextLine();
		
		LocalDate dateOfJoining = LocalDate.parse(doj); //yyyy-MM-dd
		System.out.println(dateOfJoining);
		
		//Modify above code to take date from the user in some other format, for ex: dd-MM-yyyy
		System.out.println("Enter your date of joining (dd-MM-yyyy)");
		doj = s.nextLine();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		dateOfJoining = LocalDate.parse(doj, dtf);
		System.out.println(dateOfJoining);

		LocalDate todaysDate = LocalDate.now();
		System.out.println(todaysDate);

		//Write code to find out how many years/months/days the employee has spent in the organization
		Period period = Period.between(dateOfJoining, todaysDate);
		System.out.println("Employee has spent " + period.getMonths() + " months so far in the org.");
		long days = ChronoUnit.DAYS.between(dateOfJoining, todaysDate);
		System.out.println("Employee has spent " + days + " days so far in the org.");
				
		LocalDate creditCardExpiryDate = LocalDate.of(2022, 6, 2);
		
		//Write the condition that you will use for validating the credit card
		//Credit card is valid if the expiryDate >= todaysDate
		if(creditCardExpiryDate.isAfter(todaysDate) || creditCardExpiryDate.isEqual(todaysDate))
			System.out.println("card is valid");
		else
			System.out.println("card invalid");
		
		LocalTime time = LocalTime.now();
		if(time.getHour() >= 16 && time.getHour() <= 21)
			System.out.println("Good Evening!");
		
		//Write code to display the time right now in New York
		//ZoneId.getAvailableZoneIds().forEach(System.out::println);
		LocalTime timeInNY = LocalTime.now(ZoneId.of("America/New_York"));
		System.out.println(timeInNY);
	}
}
