package com.secondatempt;

import java.util.Collections;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scannerclass {
	
	public static void main(String[] args) throws InterruptedException {
		  WebDriverManager.chromedriver().setup();		
			ChromeOptions op =new ChromeOptions();
			op.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
			WebDriver driver = new ChromeDriver(op);
			driver.get("https://www.facebook.com/");
			Scanner inputt = new Scanner(System.in);
			System.out.println("Enter your anme:");
			String name =	inputt.nextLine();
			Thread.sleep(3000);
			driver.findElement(By.name("email")).sendKeys(name);
			
			
	}

}
