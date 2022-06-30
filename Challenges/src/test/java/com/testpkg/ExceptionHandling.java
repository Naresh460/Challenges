package com.testpkg;

public class ExceptionHandling {
	
	public static void main(String[] args) {
		int a=10;
		try {
		int b=a/0;
		}catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
	}

}
