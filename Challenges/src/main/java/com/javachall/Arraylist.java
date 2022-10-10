package com.javachall;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arraylist {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<>();
		ls.add("Naresh");
		ls.add("Lalitha");
		ls.add("Sweety");
		
		System.out.println(ls);
		
		Iterator it= ls.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
	}

}
