package com.practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesHandling {
	public static WebDriver driver;
	
	
	@Test (priority = 1)
	public  void testmethod() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		driver.get("https://www.google.com");
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File desti=new File("C:\\Users\\nbusireddy\\git\\Challenges\\Challenges\\Screenshots\\test.png");
		FileUtils.copyFile(source, desti);
		
	}
	@Test
	public void scrrenShot() throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File desti=new File("C:\\Users\\nbusireddy\\git\\Challenges\\Challenges\\Screenshots\\test.png");
		FileUtils.copyFile(source, desti);
	}
}


