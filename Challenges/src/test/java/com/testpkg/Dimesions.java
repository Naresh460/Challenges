package com.testpkg;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dimesions {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		Dimension di = new Dimension(956, 1000);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(di);
		driver.get("https://www.google.com");
		
	}

}
