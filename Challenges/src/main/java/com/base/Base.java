package com.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Base {	
	public static WebDriver driver ;	
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		WebDriverListener web = new EventHandl();
	    driver = new EventFiringDecorator(web).decorate(new ChromeDriver());
		driver.manage().window().maximize();		
		
	}
	
	@Test
	public static void test1() throws InterruptedException {
		driver.get("https://www.bing.com/");
		driver.findElement(By.xpath("//input[@id=\"sb_form_q\"]")).sendKeys("Naresh reddy");
		Thread.sleep(2000);
		driver.findElement(By.id("search_icon")).click();
		System.out.println("1st method");
	}

	
	
	public String screenShot() throws IOException {

		String filename ="naresh";
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\" + filename + "_" + dateName + ".png");	
		FileUtils.copyFile(source, destination);
		return destination.getAbsolutePath();

	}
	
}


