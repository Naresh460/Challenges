package com.secondatempt;

public class DuplicateWords {
	public static void main(String[] args) {
		String name="The ball is in the court but court is ball";
		int count;  
		String nameLower=name.toLowerCase();
		String words[]=nameLower.split(" ");
		
		for(int i = 0; i < words.length; i++) {  
            count = 1;  
            for(int j = i+1; j < words.length; j++) {  
                if(words[i].equals(words[j])) {  
                    count++;  
                    //Set words[j] to 0 to avoid printing visited word  
                    words[j] = "0";  
                }  
            } 
            if(count > 1 && words[i] != "0")  
                System.out.println(words[i]);  
		
	}

	}}
