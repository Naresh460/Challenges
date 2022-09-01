package com.javachall;

public class Numberoftimes {
	public static void main(String[] args) {
		String stmt= "Naresh is a Good boy is handsom";
		String word="is";
		String temp[]= stmt.split("");
		int count =0;
		for (int i = 0; i < temp.length; i++) {
			if(word.equals(temp[i]))
				count++;
		}
		System.out.println("The string is: " + stmt);
		System.out.println("The word " + word + " occurs " + count + " times in the above string");
	
		
	}
	
		

}
