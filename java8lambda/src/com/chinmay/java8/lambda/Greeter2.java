package com.chinmay.java8.lambda;

public class Greeter2 {
	
	public void greet(GreetingIF greeting) {
		greeting.performAction();
		//This uses an interface implementation to change action/behavior at runtime. No more hardcoding. 
		/**
		 * Now calling a method from interface argument instead of actual method implementation 
		 * 
		 */
	}
	
	public static void main (String[] args) {
		Greeter2 greeter = new Greeter2();
		GreetingIF welcomeChinmayGreeting = new WelcomeChinmayGreeting();
		greeter.greet(welcomeChinmayGreeting);
		
		//Same method performs a different action with a different implementer of th einterface argument
		GreetingIF welcomeAnandGreeting = new WelcomeAnandGreeting();
		greeter.greet(welcomeAnandGreeting);

		// During execution we can create multiple implementations (polymorphism) of the same interface to implement different things through the same greeter() method
		// This was a way to pass the behavior in OOP till JDK7
		//In fact we are passing an object having the behavior or function. Not passing only the function itself.
	}
}
