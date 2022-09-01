package com.secondatempt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertss {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		Thread.sleep(3000);
		driver.switchTo().frame("login_page");
		driver.findElement(By.linkText("Forgot Customer ID")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class=\"formtable\"]/tbody/tr[7]//img")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.quit();
	}

}
