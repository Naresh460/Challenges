package com.testpkg;

public class StaticBlock {
	
	static String name="naeesh";
	
	
	static {
		System.out.println("Static Block");
	}
	
	public static void main(String[] args) {
		System.out.println("Main method");
		m();
		
	}
	
	public static void m() {
		System.out.println("Static method-->"+name);
	}

}
