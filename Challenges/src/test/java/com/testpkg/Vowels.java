package com.testpkg;

public class Vowels {
	
	public static void main(String[] args) {
		System.out.println(testmeth());
	}
	
	public static Boolean testmeth() {
		String name="naresh";
		 return name.toLowerCase().matches(".*[aeiou].*");
	}
	


}
