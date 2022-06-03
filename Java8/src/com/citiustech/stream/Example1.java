package com.citiustech.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1001, "Neha", 50000, LocalDate.of(2021, 10, 30)));
		list.add(new Employee(1003, "Sagar", 60000, LocalDate.of(2022, 3, 30)));
		list.add(new Employee(1005, "Krishna", 40000, LocalDate.of(2022, 2, 10)));
		list.add(new Employee(1004, "Saahil", 70000, LocalDate.of(2021, 5, 15)));
		list.add(new Employee(1002, "Amol", 80000, LocalDate.of(2022, 1, 31)));
		
		//Iterator<Employee> itr = list.iterator();
		//for(Employee emp : list) //for each loop of Java internally uses Iterator API
		/*Stream<Employee> s = list.stream();
		s = s.filter(emp -> emp.getSalary() > 50000);*/
		System.out.println("------example 1------------");
		list.stream()
			.filter(emp -> emp.getSalary() > 50000)
			.forEach(emp -> System.out.println(emp));
		
		System.out.println("------example 2------------");
		Predicate<Employee> con1 = emp -> emp.getSalary() > 50000;
		Predicate<Employee> con2 = emp -> emp.getDateOfJoining().getYear() == 2022;
		list.stream()
			.filter(con1.or(con2))
			.forEach(emp -> System.out.println(emp));
		
		System.out.println("------example 3------------");
		List<Employee> list2 = list
								.stream()
								.filter(emp -> emp.getSalary() > 50000)
								//.collect(Collectors.toList());
								.collect(Collectors.toCollection(LinkedList::new));
		list2.forEach(System.out::println);
		
		System.out.println("------example 4------------");
		Employee[] empArr = list
								.stream()
								.filter(emp -> emp.getSalary() > 50000)
								.toArray(Employee[]::new);
		Stream
			.of(empArr)
			.forEach(System.out::println);
				
		System.out.println("------example 5------------");
		List<String> names = list
								.stream()
								.map(emp -> emp.getName())
								.collect(Collectors.toList());
		System.out.println(names);
		
		System.out.println("------example 6------------");
		List<EmployeeInfo> info = list
									.stream()
									.map(emp -> new EmployeeInfo(emp.name, emp.dateOfJoining))
									.collect(Collectors.toList());
		info.forEach(System.out::println);
		
		System.out.println("------example 7------------");
		List<String> names2 = list
								.stream()
								.filter(emp -> emp.dateOfJoining.getYear() == 2022) //condition
								.map(emp -> emp.name) //transformation
								.sorted()
								.collect(Collectors.toList());
		names2.forEach(System.out::println);
		
		System.out.println("------example 8------------");
		List<Employee> emps = list
								.stream()
								.filter(emp -> emp.getSalary() > 10000)
								//.sorted((e1, e2) -> e1.getName().compareTo(e2.getName))
								.sorted(Comparator.comparing(Employee::getName))
								.collect(Collectors.toList());
		emps.forEach(System.out::println);
		
		System.out.println("------example 9------------");
		//write a stream to calculate the total salary of all the employees
		Double totalSalary = list
								.stream()
								//.mapToDouble(emp -> emp.getSalary())
								.mapToDouble(Employee::getSalary)
								.sum();
		System.out.println(totalSalary);
		
		//similarly we can find out count, min, max, ...
		
		System.out.println("------example 10-----------");
		List<Employee> emps2 = list
								.stream()
								//.filter(emp -> emp.getSalary() > 70000)
								.peek(emp -> emp.deductTax())
								.peek(System.out::println)
								.collect(Collectors.toList());
								
		System.out.println("------example 11-----------");
		List<Customer> custList = new ArrayList<>();
		Customer c1 = new Customer("John", "john@gmail.com");
		Order o1 = new Order(c1, LocalDate.of(2022, 6, 1), 5000);
		Order o2 = new Order(c1, LocalDate.now(), 6000);

		Customer c2 = new Customer("Smith", "smith@gmail.com");
		Order o3 = new Order(c2, LocalDate.of(2022, 5, 30), 7500);
		Order o4 = new Order(c2, LocalDate.now(), 10000);

		custList.add(c1);
		custList.add(c2);
		
		List<Order> orders = custList
								.stream()
								.flatMap(cust -> cust.orders.stream())
								.filter(ord -> ord.orderDate.equals(LocalDate.now()))
								.collect(Collectors.toList());
		orders.forEach(ord -> System.out.println(ord.amount + " " + ord.orderDate + " " + ord.customer.name));
		
		
		System.out.println("------example 12-----------");
		double totalSales = custList
								.stream()
								.flatMap(cust -> cust.orders.stream())
								.map(ord -> ord.amount)
								.reduce(0.0, Double::sum);
		System.out.println(totalSales);
		
		System.out.println("------example 13-----------");
		List<String> empList = list
									.parallelStream()
									.filter(emp -> {
										System.out.println("filter " + Thread.currentThread().getName());
										return emp.getSalary() > 1000;
									})
									.map(emp -> {
										System.out.println("map " + Thread.currentThread().getName());
										return emp.getName();
									})
									.collect(Collectors.toList());
		
	}
}

class Customer {
	String name;
	String email;
	
	List<Order> orders;

	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
		this.orders = new ArrayList<Order>();
	}
}

class Order {
	LocalDate orderDate;
	double amount;
	Customer customer;

	public Order(Customer customer, LocalDate orderDate, double amount) {
		this.customer = customer;
		this.orderDate = orderDate;
		this.amount = amount;
		customer.orders.add(this);
	}
}

class EmployeeInfo {
	String name;
	LocalDate dateOfJoining;
	
	EmployeeInfo(String name, LocalDate dateOfJoining) {
		this.name = name;
		this.dateOfJoining = dateOfJoining;
	}
	@Override
	public String toString() {
		return "EmployeeInfo [name=" + name + ", dateOfJoining=" + dateOfJoining + "]";
	}
}

class Employee {
	
	int empno;
	String name;
	double salary;
	LocalDate dateOfJoining;
	
	public Employee() {
	}
	public Employee(int empno, String name, double salary, LocalDate dateOfJoining) {
		super();
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public void deductTax() {
		this.salary = salary - salary * 0.20;
	}
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", dateOfJoining=" + dateOfJoining
				+ "]";
	}
}
