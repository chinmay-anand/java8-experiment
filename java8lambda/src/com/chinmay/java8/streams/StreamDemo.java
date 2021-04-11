package com.chinmay.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

	/**
	 * Starting from Java 8 Stream API is available for us to process collecitons of objects.
	 * A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
	 *  * Stream takes input from Collections, Arrays or IO channels.
	 *  * Streams provide results as per pipelined methods (they don't change the data structure)
	 *  * Intermediate Operation: Each intermediate operation is lazily executed and returns a stream as a result.
	 *  * Terminal Operations: Terminal operations mark the end of the stream and return the result.
	 *  
	 *  * Examples:
	 *  * Intermediate Operations:
	 *  *	"map" -- Returns a stream of converted elements each applied with the method passed as parameter to "map"
	 *  *	"filter" -- Returns a stream of subset of input elements matching the passed in criteria.
	 *  *	"sorted" -- Returns the input elements sorted using the sorting method passed in argument. Default is ascending order of input list. "Comparator.reverseOrder()" causes the sorting in descending order.
	 *  * Terminal Operations:
	 *  *	"collect" -- Returns the collection by converting the input stream back to the original type from which stream was initiated.
	 *  			Collectors.toList() returns in form of a list and .toSet() returns a set which is the unique values from the list
	 *  			"collect" takes one of these as parameter [.toList()/.toSet()].
	 *  *	"forEach" -- Operates on each element of the input stream.
	 *  *	"reduce" -- Applies the passed-in method to the input stream and returns the result. 
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		// Demonstration of various stream operations (intermediate and terminal)
		
		List<Integer> numbers = Arrays.asList(2,7,1,5,6);
		
		System.out.println("Printing all numbers");
		numbers.stream().forEach(n -> System.out.println(n));
		
		System.out.println("Printing only odd numbers in ascending order");
		numbers.stream().filter(n->n%2!=0).sorted().forEach(n -> System.out.println(n));
		
		System.out.println("Printing odd numbers in descending order");
		numbers.stream().filter(n->n%2!=0).sorted(Comparator.reverseOrder()).forEach(n -> System.out.println(n));
		
		System.out.println("Printing cubes (uses map) of all the numbers");
		numbers.stream().map(i->i*i*i).forEach(n -> System.out.println(n));
		
		System.out.println("Printing sum (using reduce) of cubes of all the numbers");
		System.out.println(numbers.stream().map(i->i*i*i).reduce(0, Integer::sum)); //One way to get the sum
		System.out.println(numbers.stream().map(i->i*i*i).reduce(0, (a,b)->a+b)); //2nd way to get the sum
		
		List<String> names = Arrays.asList("Chinmay", "Anand", "Pattanayak");

		System.out.println("Printing strings starting with A");
		List<String> resNames = names.stream().filter(s->s.startsWith("A")).collect(Collectors.toList());
		System.out.println(resNames);
		System.out.println("Printing strings starting with A or C (uses regex)");
		//resNames = names.stream().filter(s->s.matches("("+"A"+"|"+"C"+").*")).collect(Collectors.toList());
		resNames = names.stream().filter(s->s.matches("(A|C).*")).collect(Collectors.toList());
		System.out.println(resNames);
	}

}
