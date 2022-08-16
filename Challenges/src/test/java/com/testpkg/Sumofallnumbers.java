package com.testpkg;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*Sum of all numbers using streams
 */

public class Sumofallnumbers {
	
	public static void main(String[] args) {
		List<Integer> li= Arrays.asList(1,2,3,4);
		//Sum of the all the numbers
		Optional<Integer> sum = li.stream().reduce((a,b)->a+b);
		System.out.println("Sum is--->" +sum.get());
		
		//Avarage of all the numbers
		Double avg =li.stream().mapToInt(e->e).average().getAsDouble();		
		System.out.println("Avg is--->" +avg);
		
		
		
	}
}
