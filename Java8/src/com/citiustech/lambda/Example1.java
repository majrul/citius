package com.citiustech.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

@FunctionalInterface
interface Printer {
	void print(String document);
	//void cancelPrinting();
}

interface Math {
	int calc(int x, int y);
}
//Try one anonymous and one lambda implementation of Math interface

//just a regular class implementing Printer interface
class DotMatrixPrinter implements Printer {
	@Override
	public void print(String document) {
		System.out.println("DotMatrix printer printing " + document);
	}
}

public class Example1 {

	public static void main(String[] args) {
		//inner class implementing Printer interface
		class InkjetPrinter implements Printer {
			@Override
			public void print(String document) {
				System.out.println("Inkjet printer printing " + document);
			}
		}
		
		Printer p1 = new DotMatrixPrinter();
		p1.print("abc.txt");
		Printer p2 = new InkjetPrinter();
		p2.print("abc.txt");
		
		//anonymous inner class implementing Printer interface
		Printer p3 = new Printer() {
			@Override
			public void print(String document) {
				System.out.println("Deskjet printer printing " + document);
			}
		};
		p3.print("abc.txt");
		
		//lambda style implementation of Printer interface
		Printer p4 = (doc) -> {
			System.out.println("Laser printer prining " + doc);
		};
		p4.print("abc.txt");
		
		Math m1 = new Math() {	
			@Override
			public int calc(int x, int y) {
				return x + y;
			}
		};
		System.out.println(m1.calc(10, 20));
		
		Math m2 = (x, y) -> x - y;
		System.out.println(m2.calc(10, 20));
		
		List<Emp> list = new ArrayList<>();
		list.add(new Emp(1001, "Krishna", 10000));
		list.add(new Emp(1005, "Bharati", 10000));
		list.add(new Emp(1003, "Akshay", 10000));
		
		for(Emp emp : list)
			System.out.println(emp.empno + " " + emp.name + " " + emp.salary);
			
		list.forEach(emp -> System.out.println(emp.empno + " " + emp.name + " " + emp.salary));

		list.sort((e1, e2) -> e1.name.compareTo(e2.name));
		list.forEach(emp -> System.out.println(emp.empno + " " + emp.name + " " + emp.salary));
	}
}

class Emp {
	int empno;
	String name;
	double salary;
	
	Emp(int empno, String name, double salary) {
		super();
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}		
}