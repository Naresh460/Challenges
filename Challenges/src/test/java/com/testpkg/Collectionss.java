package com.testpkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Collectionss {

	public static void main(String[] args) {
		List<String> colle = new ArrayList<>();
		colle.add("Naresh");
		colle.add("Lalitha");
		System.out.println(colle);
		
		
		Collections.sort(colle);
		System.out.println(colle);
		
	}
}
