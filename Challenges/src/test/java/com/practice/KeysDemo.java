package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import de.erichseifert.vectorgraphics2d.VectorHints.Key;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KeysDemo {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		WebElement ele1 =driver.findElement(By.id("firstName"));
		ele1.sendKeys("Naresh Reddy");
		action.moveToElement(ele1).click().keyDown(Keys.CONTROL).sendKeys("a","c");
		
		WebElement ele2 =driver.findElement(By.id("lastName"));
		action.moveToElement(ele2).click().keyDown(Keys.CONTROL).sendKeys("v");
		action.keyUp(Keys.CONTROL).build().perform();
		
	}

}
