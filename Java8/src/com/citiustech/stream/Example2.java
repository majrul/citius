package com.citiustech.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example2 {

	public static void main(String[] args) {
		Stream<String> s1 = Stream.of("Java", "JavaScript", "Python", "C Sharp");
		s1.forEach(System.out::println);
				
		s1 = Stream.of("Java", "JavaScript", "Python", "C Sharp");
		boolean found = s1.anyMatch(str -> str.equals("Scala"));
		System.out.println(found);
		
		s1 = Stream.of("Java", "JavaScript", "Python", "C Sharp");
		found = s1.allMatch(str -> str.contains("a"));
		System.out.println(found);
		
		IntStream nos = IntStream.rangeClosed(1, 10);

		Stream
			.generate(() -> new Random().nextInt(100))
			.limit(10)
			.forEach(System.out::println);
		
		//Create a Stream containing an array as it's element
		//Then using flatMap extract the individual elements of that array
		int[] arr = {1, 2, 3, 4, 5};
		Stream<int[]> stArr = Stream.of(arr);
		
	}
}
