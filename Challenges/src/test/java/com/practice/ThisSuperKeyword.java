package com.practice;

public class ThisSuperKeyword {

	int a = 10;
	int b = 20;

	void method() {
		this.a = 20;
		this.b = 30;
		System.out.println(a);
		System.out.println(b);
		
	}
	
	public static void main(String[] args) {
		ThisSuperKeyword thiss= new ThisSuperKeyword();
		thiss.method();
		
		
	}

	
	
	
}
