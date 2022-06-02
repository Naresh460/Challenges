package com.testpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	public static void main(String[] args) throws InterruptedException {
		amazon();
	}
	
	public static void flipKart() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("mobiles");
		Thread.sleep(3000);
		List<WebElement> listt = driver.findElements(By.xpath("//div[contains(@class,'lrtEPN')]"));
		System.out.println(listt.size());
		for (WebElement wl : listt) {
			String suggestions =wl.getText();
			System.out.println("Suggestions are==>"+suggestions);
		}
		
		driver.quit();
	}
	
	public static void amazon() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		driver.get("https://www.amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
		Thread.sleep(3000);
		String listt= driver.findElement(By.xpath("//div[@class='autocomplete-results-container']")).getText();
		System.out.println("Suggestions are-->"+listt);
		driver.quit();
	}
}
