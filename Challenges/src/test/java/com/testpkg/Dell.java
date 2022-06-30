package com.testpkg;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dell {
public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		//driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-in");
		Thread.sleep(3000);
		List<WebElement> li = driver.findElements(By.xpath("//ul[@aria-label='Products']//li[@class='child-nav']"));
		System.out.println("Tier-2 name count-->" +li.size() );
		for (int i=1;i<=li.size();i++) {
			//System.out.println("element-->" +web);
			List<WebElement> t3= driver.findElements(By.xpath("//ul[@aria-label='Products']//li[@class='child-nav']["+i+"]/ul/li[position()>2]/a"));
			System.out.println("t3 size-->" +t3.size());
			
			for (WebElement t3child : t3) {
				Thread.sleep(1000);
				String t3names =t3child.getAttribute("textContent");
				//String t3names =t3child.getText();
				
				System.out.println("Tier-3 names are-->" +t3names );
			}
			
			
		}
driver.quit();		
}
}
