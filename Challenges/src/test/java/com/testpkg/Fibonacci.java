package com.testpkg;

public class Fibonacci {
public static void main(String[] args) {
	int a=0;
	int b=1;
	int c=1;
	
	for (int i = 1; i <= 10; i++) {
		
	a=b;
	b=c;
	c=a+b;
		System.out.println(c);
	}
}
}
