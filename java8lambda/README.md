# Contents of "java8lambda" project
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

##### Functional vs OOP
* Both can achieve the same
* Functional programmign gives a more readable and hence more maintainable code.
* Functional programming is elegant in certain situatio, but not always. We may need to use Object oriented programming in some other cases.
* In OOP all code blocks are "associated" with classes and objects.

##### How to convert a normal function into an Lambda Expression
	 * HOW TO Convert a standard function into a Lambda Expression
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
