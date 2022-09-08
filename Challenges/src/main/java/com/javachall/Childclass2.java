package com.javachall;

public class Childclass2 extends Parentclass {
	String s = "Child class2";
	
	public void methidc() {
		System.out.println(super.s);
		System.out.println(this.s);
	}
	
	public static void main(String[] args) {
		Childclass2 cs2= new Childclass2();
		cs2.methidc();
		
	}

}
