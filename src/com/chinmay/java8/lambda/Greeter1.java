package com.chinmay.java8.lambda;

public class Greeter1 {
	
	public void greet() {
		System.out.println("Welcome Chinmay!");
		//This uses hardcoded action to perform
		/**
		 * We want to modify the greet() method to do different things based on the input argument passed to the method.
		 * 
		 * Option-I: Crude way - we can write all possible actions in greet() and accept the argumet to use as switch statement.
		 * Option-II: (in jdk prior to JDK8) 
		 * 		* Create an interface and implement the action logic in that interface and 
		 * 
		 */
	}
	
	public static void main (String[] args) {
		Greeter1 greeter = new Greeter1();
		greeter.greet();
	}
}
