package com.secondatempt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framess {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	JavascriptExecutor js = (JavascriptExecutor) driver;  
	driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
	js.executeScript("window.scrollBy(0,300)", "");
	driver.findElement(By.id("name")).sendKeys("Naresh");		
	Thread.sleep(3000);
	driver.switchTo().frame("frm3");
	driver.findElement(By.id("name")).sendKeys("Entered to Frame3");	
	Thread.sleep(3000);
	driver.switchTo().frame("frm1");
	WebElement course = driver.findElement(By.id("course"));
	Select cou=new Select(course);
	cou.selectByVisibleText("Java");
	Thread.sleep(3000);
	driver.switchTo().parentFrame();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("frm2");
	driver.findElement(By.id("firstName")).sendKeys("2nd frame");
	

}
}
