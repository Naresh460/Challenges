package com.practice;

public class Duplicates {
	public static void main(String[] args) {
		String name ="saraswati";
		  int count;    
		int leng = name.length();
		char[] ch=name.toCharArray();
				
		for (int i = 0; i < leng; i++) {
			count=1;
			for (int j = i+1; j < ch.length; j++) {
				if(ch[i]==ch[j]&& ch[i] != ' ') {
					count++;  
					ch[j]='0';					
				}
			}
			
			if(count>1&& ch[i] != '0') {
				System.out.println(ch[i]); 
			}
			
		}
	}

}
