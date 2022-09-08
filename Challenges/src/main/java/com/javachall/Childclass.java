package com.javachall;

public class Childclass extends Parentclass {
	String s="Child class";
	
	public static void main(String[] args) {
		Childclass cs= new Childclass();
		cs.mehod1();
	}
	
	public void mehod1() {
		System.out.println(this.s);
		System.out.println(super.s);
	}
	
	
	
}
