package com.javachall;

public class StringCount {
	public static void main(String[] args) {
		String name="This is Naresh";
		int count=0;
		for (int i = 0; i < name.length(); i++) {
			if(name.charAt(i)!=' ') {
				count++;
			
		}
			}
		System.out.println(count);
	}

}
