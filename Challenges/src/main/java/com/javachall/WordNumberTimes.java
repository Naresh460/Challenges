package com.javachall;

import java.util.HashMap;
import java.util.Map;

public class WordNumberTimes {
	
	public static void main(String[] args) {
		String name="How much time a Wood do Wood time much can";
		String nameLowercase = name.toLowerCase();
		String words[]= nameLowercase.trim().split(" ");
		Map<String, Integer> hashMap = new HashMap<>();
		 for (String word : words) {
			 Integer value= hashMap.get(word);
			 if (value==null ) {
				 hashMap.put(word, 1);
			}else {
				hashMap.put(word, value+1);
			}
			 
		}
		System.out.println(hashMap);
	}

}
