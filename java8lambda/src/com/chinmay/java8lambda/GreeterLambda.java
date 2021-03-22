package com.chinmay.java8lambda;

public class GreeterLambda {
	
	public void greet(GreetingIF greeting) {
		greeting.performAction();
	}
	
	public static void main (String[] args) {
		GreeterLambda greeter = new GreeterLambda();
		/**
		 * HOW TO Convert a standard function into a Lambda Expression
		 * ----------------------------------------------------------- 
		 * 
		 * In "Lambda Expression we use a function as a value.
		 * i.e. we assign a function body to a variable and will call that vaiable later to invoke the function assigned to it.
		 * 	While assigning we 
		 * 		trim out the func access specifier (public, private etc, are meaningful in a class, but not useful when the cunc is used standalone way), 
		 * 		remove the func name (func name is not needed, we will call the method by the assigned variable on left side of the lambda expression), 
		 * 		get rid of return type which is not neededas java compiler finds out the return type from the func body.
		 * Finally add an arrow between the parameters and func body.
		 * AND of the func body contains only one line, then we don't need a enclosing bracket.
		 * AND if func body is one line and returns a value or expression, then we may omit "return" keyword.
		 * 
		 * Now for Return Type of the lambda expression 
		 * 		Define a random interface (say "MyLambda") with a method declaration (with random name) with the signatures matching with the lambda function
		 * we can use this interface as the variable type of the lambda expression.
		 * i.e. Define an interface that describes the lambda expression matching params and return type. 
		 * Like any other expression, lambda expression too must end with a semicolon.
		 * 
		 *  Lambda functions are similar to Anonymous inner inline classes
		 *  e.g. GreetingIF = new GreetingIF(){
		 *  		System.out.println("Hello world from the anonymous ineer class inside Greeter main class.");
		 *  	 };
		 *  	 //This 1. creates an implementation of interface GreetingIF, e. implements it's abstract method  
		 *  
		 *  So there are BASICALLY 3 WAYS
		 *  A. Implement the interface and call the method from the interface variable which is implemented using "new" on the implementation class
		 *  B. Call the method from the lambda expression which indeirectly implements the interface
		 *  C. Call the method on the anonymous inner class that is just a variable of type interface instanciated through "new" on our interface, but implements the abstract method
		 *  
		 *  B & C are similar Lambda expression is just a fancy new shortcut in Java8 to represent anonymous inner classes.
		 *  But there are some difference. 
		 * 
		 * This works Java8 onwards.
		 */
		MyAdd addExpr = (int n1, int n2) -> n1+n2;
		System.out.println(addExpr.bar(2,3)+": Result from MyAdd");
		//lambdaGreeting = public void performAction() { System.out.println("Welcome Chinmay!"); }
		//MyLambda lambdaGreeting = () -> System.out.println("Welcome Chinmay Anand!");
		
		GreetingIF welcomeChinmayGreeting = new WelcomeChinmayGreeting();
		GreetingIF lambdaGreeting = () -> System.out.println("Welcome Chinmay! - from lambda");
		GreetingIF innerClassGreeting = new GreetingIF() {
			
			@Override
			public void performAction() {
				System.out.println("Welcome Chinmay! - from innerclass");
			}
		};

 		System.out.println("\nInvoking the method from its interface passed as argument");
		greeter.greet(welcomeChinmayGreeting);	//This calls a method form an object instance
		greeter.greet(lambdaGreeting);	   		//This implements a method without instantiating the object
		greeter.greet(innerClassGreeting);		//This implements the method in an inner class
		
 		System.out.println("\nCalling the interface method");
		welcomeChinmayGreeting.performAction();
		lambdaGreeting.performAction();
		innerClassGreeting.performAction();
		
		/**
		 * Multiple ways to execute a lambda expression:
		 * Hint: Use the lambda variable as if it were an implementation of the interface (lambda var type)
		 * All of the below lines will result in the same.
		 * 
		 * greeter.greet(lambdaGreeting);
		 * lambdaGreeting.performAction(); // "performAction()" method name can be anything
		 * greeter.greet(() -> System.out.println("Welcome Chinmay! - from lambda")); // Using directly the body of the lambda func
		 * 
		 * Java compiler automatically infers the type from the method body - called "Type Inference".
		 * 		Java compiler can infer the return tupe as well as the parameter types by looking at the interface the lambda is implementing.
		 * 		So we can omit the parameter type as well, in the lambda expression.
		 */
		
		//So Lambda functions is just an implementation of the method without any instantiation of the class.
	}
}

/**
 * Functional interface -- A special interfaces with 
 * 		exactly one abstract method can be used as lambda variable type.
 * 		Additional methods if needed must not be abstract i.e. should have body
 * 		The non-abstract methods must be declared either "default" or "static"
 * Implementation of Functional Interface:
 * 		The lone abstract method is used for lambda expression type, and lambda variable can eb used like an implementation class.
 * 		Any implementation class of the interface may choose to @override the non-abstract methods.
 * 		The static method scan not be overriden but can be defined in the implementer and treated as a new method.  
 * 
 * Prior to Java 8 interfaces were allowed to have only the abstract method (all abstract method declarations).
 * In Java8 onwards we need to have at least one abstract method and rest methods can have "default" implementations
 * 
 * To use with lambda expression the interface name or the lone abstract method name is immaterial.
 * Only condition is that the lone abstrat method in the interface must match with the lambda expression method.
 * We can use GreetingIF instead of MyLambda during our lambda assignment as long as it has only one abstract method (non-default, non-static)
 * 
 * Refer: https://stackoverflow.com/questions/36233477/implementing-an-interface-with-two-abstract-methods-by-a-lambda-expression
 * 
 * @author Chinmay
 *
 */
interface MyLambda { 
	void foo();
}

@FunctionalInterface
interface MyAdd { 
	int bar(int a, int b); 
	default int bar1(int a, int b, int c) {return -1;} 
	static int bar2(int a, int b, String s) {return -2;}
}
