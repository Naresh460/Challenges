package com.secondatempt;

import java.util.HashMap;
import java.util.Map;

public class CountofWords {
	public static void main(String[] args) {
		String name="The ball is in the court but court is ball";
		String nameToLower=name.toLowerCase();
		
		Map<String, Integer> hashmap= new HashMap<>();
		
		String[] words=nameToLower.split(" ");
		for (String word : words) {
			Integer key = hashmap.get(word);
			
			if(key==null) {
				hashmap.put(word, 1);
			}else {
				hashmap.put(word, key+1);
			}
			
			
		}
		
		System.out.println(hashmap);
		
		
	}
	
}