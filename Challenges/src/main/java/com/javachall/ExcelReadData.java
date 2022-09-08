package com.javachall;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import zmq.Mailbox;

public class ExcelReadData {
	
	public static void main(String[] args) throws IOException {
		Map<String, String> hashmap= new HashMap<>();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\DataProvider\\Excel.xlsx");
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sheet =wb.getSheetAt(0);
			int lastRowNumber=sheet.getPhysicalNumberOfRows();  //4
			for (int i = 1; i < lastRowNumber; i++) {
				Row row=sheet.getRow(i);
				Cell keycell =row.getCell(0);
				String Key=keycell.getStringCellValue().trim();
				
				Cell valuecell =row.getCell(1);
				String value= valuecell.getStringCellValue().trim();
				
				hashmap.put(Key, value);
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	System.out.println(hashmap);
		
		
	}

}
