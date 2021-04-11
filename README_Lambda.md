# Contents of "java8lambda" project
* Stream API: Refer "src/com/chinmay/java8lambda/"
* Using Lambdas
* Functional Interfaces
* Method references
* Collections improvements

##### Advantages of Lambdas:
* Enables functional programming
	* we can pass a function name to a method to get it called on a certain condition.
* Readable and concise code
* Easier-to-use APIs and libraries
* Enables support for parallel processing
* Lambda works Java8 onwards.

##### Functional vs OOP
* Both can achieve the same
* Functional programmign gives a more readable and hence more maintainable code.
* Functional programming is elegant in certain situatio, but not always. We may need to use Object oriented programming in some other cases.
* In OOP all code blocks are "associated" with classes and objects.

##### Functional Interface
	 * Functional interface -- A special interfaces with 
	 * 		exactly one abstract method can be used as lambda variable type.
	 * 		Additional methods if needed must not be abstract i.e. should have body
	 * 		The non-abstract methods must be declared either "default" or "static"
	 * 	Annotate the interface with "@FunctionalInterface" (from java.lang) to enforce compile time checking to ensure that there is exactly one abstract method.
	 * 	This is not needed by compiler to identify lambda interface, but it is a good practice to prevent accidental errors from other developers preventing the addition of other abstract methods.
	 * Implementation of Functional Interface:
	 * 		The lone abstract method is used for lambda expression type, and lambda variable can eb used like an implementation class.
	 * 		Any implementation class of the interface may choose to @override the non-abstract methods.
	 * 		The static method scan not be overriden but can be defined in the implementer and treated as a new method.  

##### How to execute a Lambda Expression
	* Call the interface method on the lambda variable, as if it were instance of a class.
	* ------------------------------------------------
	* Java compiler automatically infers the type from the method body - called "Type Inference".
	* 	Java compiler can infer the return type as well as the parameter types by looking at the interface the lambda is implementing.
	* 	So we can omit the parameter type as well, in the lambda expression.
	*   * If there is only one parameter then we can omit the parenthesis surrounding the parameter of lambda function (RHS).
	* All 3 Below expressions are same:
	* 	StringLengthIF myLambda = (String s) -> {return s.length();};
	* 	StringLengthIF myLambda = (String s) -> s.length();
	* 	StringLengthIF myLambda = (s) -> s.length();
	* 
	* Multiple ways to execute a lambda expression:
	* ------------------------
	* Hint: Use the lambda variable as if it were an implementation of the interface (lambda var type)
	* All of the below lines will result in the same.
	* 	greeter.greet(lambdaGreeting);
	* 	lambdaGreeting.performAction(); // "performAction()" method name can be anything
	* 	greeter.greet(() -> System.out.println("Welcome Chinmay! - from lambda")); // Using directly the body of the lambda func
	* Any method that takes the interface defined for lambda as argument can also take the lambda variable in the expression

##### How to convert a normal function into an Lambda function Expression and how to execute it (with example)
	 * HOW TO Convert a standard function into a Lambda Function
	 * ----------------------------------------------------------- 
	 * 
	 * SUMMARY:
	 * 1. First write the normal method (FN1).
	 * 2. Define or Ensure that there is an "Functional Interface" (iFN1) defined matching with the function declaration (parameters and return type). The name of the interface or name of its parameters are immaterial.
	 * 3. Now declare a variable "lambdaFN1" of type iFN1 (i.e. the new interface you defined) and assign the variable with the entire function body (FN1), similar to anonymous internal class.
	 * 4. From the R.H.S of this expression remove function name, return type. And put an arrow (->) between the parametes and function body. Terminate the assignment with a semicolon.
	 * We are ready with the lambda expression.
	 * We can use the lambda expression "lambdaFN1", as if it is an implementation of interface "iFN1"
	 * Also note that any functional interface (e.g. iFN1) can have only one abstract method, else it becoem a standard interface and can not be used with lambda expression.
	 * 
	 * In "Lambda Expression we use a function as a value.
	 * i.e. we assign a function body to a variable and will call that vaiable later to invoke the function assigned to it.
	 * 	While assigning we 
	 * 		trim out the func access specifier (public, private etc, are meaningful in a class, but not useful when the func is used standalone way), 
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
	 
