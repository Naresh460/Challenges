package com.javaExceptions;

 class Demoexpection {
	
	public static void main(String[] args) {
		try {
			
			int a=10;
			int b=0;
			int c=a/b;
			System.out.println(c);
			System.out.println("Executed");
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
