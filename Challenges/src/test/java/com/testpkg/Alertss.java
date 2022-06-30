package com.testpkg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertss {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.navigate().to("");
		driver.findElement(By.name("proceed")).click();
		Alert a = driver.switchTo().alert();

		a.accept();
	}
	
	public static void methodtest()
	{
		System.out.println("hi");
		
	}
}
