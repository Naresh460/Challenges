package com.javachall;

public class Wordcount {
	public static void main(String[] args) {
		System.out.println("Simple Java Word Count Program");

	     String str1 = "Today is Holdiay Day";

	     String[] wordArray = str1.trim().split("\\s+");
	     int wordCount = wordArray.length;

	     System.out.println("Word count is = " + wordCount);
	}

}
