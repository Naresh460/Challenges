package com.testpkg;

import java.util.ArrayList;
import java.util.List;

public class Oddnumbers {
	
	public static void main(String[] args) {
		List<Integer> li= new ArrayList<>();
		
		li.add(1);
		li.add(2);
		li.add(3);
		System.out.println(li);
		for (Integer in : li) {
			if(in%2!=0) {
				System.out.println("Odd number is-->" +in);
			}
			
			
		}
	}

}
