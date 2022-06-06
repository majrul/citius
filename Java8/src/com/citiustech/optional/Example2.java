package com.citiustech.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example2 {

	public static void main(String[] args) {
		PhoneBook phBook = new PhoneBook();
		phBook.add(new Contact("Raj", "+91-9812345678", "Mumbai"));
		phBook.add(new Contact("Smith", "+1-1234567890", "Mumbai"));
		phBook.add(new Contact("John", "+1-9876543210", "Delhi"));
		
		/*Optional<Contact> op = phBook.search("Raj");
		if(op.isPresent()) {
			Contact c = op.get();
			System.out.println(c.name + " " + c.mobileNumber);
		}*/
		phBook
			.search("Raj")
			//.ifPresent(System.out::println);
			//.ifPresentOrElse(System.out::println, 
			.ifPresentOrElse(c -> System.out.println(c), 
							 () -> System.out.print("No record found!"));
		
		System.out.println("--------------------");
		phBook
			.searchByCity("Ahmedabad")
			.forEach(System.out::println);
		
		List<String> names = phBook
								.searchByCity("Mumbai")
								.stream()
								.map(Contact::getName)
								.collect(Collectors.toList());
		names.forEach(System.out::println);
		
		String pno = phBook
						.search("Raj")
						.map(Contact::getMobileNumber)
						.orElse("");
		System.out.println(pno);
	}
}

class PhoneBook {
	List<Contact> contacts = new ArrayList<>();
	
	void add(Contact c) {
		contacts.add(c);
	}
	
	Optional<Contact> search(String name) {
		return contacts
				.stream()
				.filter(c -> c.name.equals(name))
				.findAny();
	}
	
	//return type should be collection/array
	List<Contact> searchByCity(String city) {
		return contacts
				.stream()
				.filter(c -> c.city.equals(city))
				.collect(Collectors.toList());
	}
}
/*class PhoneBook {
	
	Contact[] contacts = new Contact[999];
	int index;
	
	void add(Contact c) {
		contacts[index++] = c;
	}
	
	Optional<Contact> search(String name) {
		for(int i=0; i<index; i++) {
			if(contacts[i].name.equals(name))
				return Optional.of(contacts[i]);
		}
		return Optional.empty();
	}
}*/

class Contact {
	String name;
	String mobileNumber;
	String city;
	
	public Contact(String name, String mobileNumber, String city) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobileNumber=" + mobileNumber + ", city=" + city + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}

