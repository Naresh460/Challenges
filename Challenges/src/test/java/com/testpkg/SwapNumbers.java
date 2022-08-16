package com.testpkg;

public class SwapNumbers {
	
	public static void main(String[] args) {
		int a=20;
		int b=30;
		b=a+b;
		
		a=b-a;
		System.out.println(a);
		b=b-a;
		System.out.println(b);
	}
	


}
