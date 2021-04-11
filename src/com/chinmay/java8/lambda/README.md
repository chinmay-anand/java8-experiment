#### Explanation of the files:
##### Java8 Lambda functions and Functional programming
* **GreeterLambda.java** -- explains how to write Lambda functions and how to do functional programming

##### Using Stream API in Java8 onwards
* **StreamDemo.java** -- Demonstrates the Intermediate operations (map/filter/sorted) and Terminal operations (collect/forEach/reduce)
* Refer below for detailed explanation.

	 * Starting from Java 8 Stream API is available for us to process collecitons of objects.
	 * A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
	 *  * Stream takes input from Collections, Arrays or IO channels.
	 *  * Streams provide results as per pipelined methods (they don't change the data structure)
	 *  * Intermediate Operation: Each intermediate operation is lazily executed and returns a stream as a result.
	 *  * Terminal Operations: Terminal operations mark the end of the stream and return the result.
	 *  
	 *  * Examples:
	 *  * Intermediate Operations:
	 *  *	"map" -- Returns a stream of converted elements applied with the method passed as parameter to "map"
	 *  *	"filter" -- Returns a stream of subset of input elements mathcing th epassed in criteria
	 *  *	"sorted" -- Returns the input elements sorted by the argument passed.
	 *  * Terminal Operations:
	 *  *	"collect" -- Returns the collection by converting the input stream back to the original type from which stream was initiated.
	 *  			Collectors.toList() returns in form of a list and .toSet() returns a set which is the unique values from the list
	 *  			"collect" takes one of these as parameter.
	 *  *	"forEach" -- Operates on each element of the input stream.
	 *  *	"reduce" -- Applies the passed-in method to the input stream and returns the result. 
