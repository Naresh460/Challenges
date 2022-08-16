package com.testpkg;



public class WhiteSpace {
	
	public static void main(String[] args) {
		
	String inputt="N a r e s h";
	System.out.println(inputt);
	StringBuilder sb= new StringBuilder();
	char[] charArray = inputt.toCharArray();
	for (char c : charArray) {
		if(!Character.isWhitespace(c)) {
			sb.append(c);
		}
	
		
	}
	String finl= sb.toString();
	System.out.println(finl);
	}

}
