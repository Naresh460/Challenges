package com.javachall;

public class PrintChar {
	public static void main(String[] args) {
		String name="This is Naresh";
		String namef=name.replaceAll("\\s", "");
		StringBuilder sb= new StringBuilder(namef);
		sb.reverse();
		String reverse = sb.toString();
		
		for (int i = 0; i < reverse.length(); i++) {
			char c=reverse.charAt(i);	
				System.out.println(c);
			
		}
			
		
	}

}
