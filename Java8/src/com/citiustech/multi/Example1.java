package com.citiustech.multi;

interface MobileApp {
	void start();
	void stop();
	
	default void cleanup() {
		System.out.println("some code to clean the resources used by the app");
	}
	
	static void metadata() {
		System.out.println("@Copyright of Google Inc.");
	}
}

class MyAwesomeGame implements MobileApp {

	@Override
	public void start() {
		System.out.println("my game loading..");
	}

	@Override
	public void stop() {
		System.out.println("my game stopping..");
	}
}
public class Example1 {

	public static void main(String[] args) {
		MobileApp app = new MyAwesomeGame();
		app.start();
		app.stop();
		app.cleanup();
		MobileApp.metadata();
	}
}
