package com.testpkg;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferReader {
	
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("C:\\Users\\nbusireddy\\git\\Challenges\\Challenges\\DataProvider\\FileReader.txt");
			BufferedReader br = new BufferedReader(fr);
			String sCurrentLine;
			
			while((sCurrentLine=br.readLine())!=null) {
				System.out.println(sCurrentLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
