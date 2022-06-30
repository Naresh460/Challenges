package com.testpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SystemProperties {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	//System.getProperties().list(System.out);
	
	System.out.println("------------------------------------------------>");
	String versions = System.getProperty("java.version");
	System.out.println(versions);
	ChromeOptions options = new ChromeOptions();
	
	options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://www.google.com");
}
}
