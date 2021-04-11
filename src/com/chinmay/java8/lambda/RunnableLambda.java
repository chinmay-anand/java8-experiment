package com.chinmay.java8.lambda;

public class RunnableLambda {

	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Printed inside Runnable");
			}
		});
		myThread.run();
		
		//Here we are treating "myLambda" as an implementation of "java.lang.Runnable" interface which have exactly one abstract method.
		Runnable myLambda = () -> System.out.println("Printed inside Runnable Lambda");
		myLambda.run();
		
		//Here we are passing a lambda expression to a method where the interface was expected.
		Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside Runnable Lambda thread"));
		myLambdaThread.run();
		//This allowed us to use the pre jdk8 classes like Thread to use lambda.
	}
}
