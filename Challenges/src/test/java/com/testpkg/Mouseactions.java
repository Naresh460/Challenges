package com.testpkg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouseactions {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		Actions ac = new Actions(driver);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		File desti= new File("C:\\Users\\nbusireddy\\git\\Challenges\\Challenges\\Screenshots\\page.png");
		FileUtils.copyFile(SrcFile, desti);
		
		
	}

}
