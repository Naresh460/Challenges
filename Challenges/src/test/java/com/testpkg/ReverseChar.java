package com.testpkg;

public class ReverseChar {
	
	public static void main(String[] args) {
		String name="Naresh reddy";
		StringBuilder sb= new StringBuilder();			
			sb.append(name);
			
			String rev = sb.reverse().toString();
			for(int i=0; i<rev.length();i++) {
				char ch=rev.charAt(i);
				System.out.println(ch);
		}
		
	}

}
