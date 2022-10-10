package com.javachall;

public class Wordcount {
	public static void main(String[] args) {
	

	     String str1 = "Today is Holdiay Day";

	     String[] wordArray = str1.trim().split(" ");
	     int wordCount = wordArray.length;

	     System.out.println("Word count is = " + wordCount);
	}

}
