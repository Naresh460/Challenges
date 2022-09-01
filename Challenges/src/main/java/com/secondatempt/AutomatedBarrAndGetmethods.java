package com.secondatempt;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomatedBarrAndGetmethods {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions op =new ChromeOptions();
		op.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://www.google.com");
		String url=driver.getCurrentUrl();
		String title= driver.getTitle();
		String pSource= driver.getPageSource();
		System.out.println(url);
		System.out.println(title);
	//	System.out.println(pSource);
		driver.quit();
		
	}

}
