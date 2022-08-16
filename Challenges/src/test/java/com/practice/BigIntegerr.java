package com.practice;

import java.math.*;

public class BigIntegerr {
	
	public static void main(String[] args) {
		BigInteger bi = new BigInteger("1236577985245871233333");
		BigInteger bi2 = new BigInteger("100");
		BigInteger addition = bi.add(bi2);
		BigInteger sub = bi.subtract(bi2);
	
		System.out.println("Adding 2 big numers-->"+addition);
		System.out.println("sub 2 big numers-->"+sub);
	}

}
