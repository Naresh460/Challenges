package com.testpkg;

public class NumberfromString {
	public static void main(String[] args) {
		String name ="naresh656788460025hgy476";
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i <name.length(); i++) {			 
			char c=name.charAt(i);
			if(Character.isDigit(c)) {
				builder.append(c);
			}
		}
		System.out.println(builder.toString());
	}

}
