package com.javachall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.compress.harmony.pack200.NewAttributeBands.Union;
import org.openqa.selenium.interactions.Interaction;

public class Setdemo {

	public static void main(String[] args) {
		iterator();
		operatios();

	}

	public static void iterator() {
		Set<String> st = new HashSet<>();
		st.add("Naresh");
		st.add("Lalitha");
		st.add("Naresh");
		System.out.println(st);
		Iterator<String> it = st.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
	
	public static void operatios() {
		
		List<Integer>li1 =new ArrayList<>();
		li1.add(1);
		li1.add(2);
		li1.add(3);
		li1.add(1);
		List<Integer>li2 =new ArrayList<>();
		li1.add(5);
		li1.add(6);
		li1.add(7);
		li1.add(2);
		Set<Integer> si= new HashSet<Integer>(li1);
		si.addAll(li2);
		System.out.println(si);
		li1.addAll(li2);
		System.out.println(li1);
	
		
	}
}
