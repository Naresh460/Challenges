package com.javachall;

public class ReverseString {
	public static void main(String[] args) {
		String s="Naresh is good";
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		System.out.println(sb.toString());
	}

}
