package com.javaExceptions;

public class DefaultExceptio {
public static void main(String[] args) {
	method1();
}

public static void method1() {
	method2();
}
public static void method2() {
	method3();
	System.out.println("came to method2");
}
public static void method3() {
	try {
	System.out.println(10/0);
	}
	catch (Exception e) {
		System.err.println(e);
	}
}
}
