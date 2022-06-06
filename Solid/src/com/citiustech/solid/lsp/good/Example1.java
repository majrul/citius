package com.citiustech.solid.lsp.good;

class Logger {
	
	void log(String msg) {
		System.out.println("Logger's log method");
	}

	void clear() {
		System.out.println("Logger's clear method");
	}
}

/*
 * assume FileLogger doesn't supports clearing the log
 */
class FileLogger extends Logger {

	void log(String msg) {
		System.out.println("FileLogger's log method");
	}

	void clear() {
		System.out.println("FileLogger's clear method");
		//throw new RuntimeException("operation not permitted!");
	}
}

public class Example1 {

	public static void main(String[] args) {
		//Logger logger = new Logger();
		Logger logger = new FileLogger();
		logger.log("some message");
		logger.clear();
	}
	
}
