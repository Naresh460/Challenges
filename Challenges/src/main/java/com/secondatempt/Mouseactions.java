package com.secondatempt;

import java.time.Duration;
import java.util.Collections;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouseactions {
	
	public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();		
		ChromeOptions op =new ChromeOptions();
		op.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://www.hyrtutorials.com/");
		WebElement tutorials = driver.findElement(By.linkText("Tutorials"));
		WebElement YouTube=driver.findElement(By.linkText("YouTube Courses"));
		
		Actions action = new Actions(driver);
		action.moveToElement(tutorials).pause(Duration.ofSeconds(3))
		.moveToElement(YouTube)
		.build().perform();
		
	}

}
