package com.secondatempt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locatorss {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
	driver.findElement(By.id("firstName"));
	driver.findElement(By.name("lName"));
	driver.findElement(By.className("inp"));
	driver.findElement(By.tagName("input"));
	driver.findElement(By.xpath("//label[@class=\"inp\"]"));
	driver.findElement(By.cssSelector(".inp"));
	driver.findElement(By.linkText("click Here"));
	driver.findElement(By.partialLinkText("click"));
}
}
