package com.testpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationsHandle {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://whatmylocation.com");
		WebElement we= driver.findElement(By.xpath("/html/body/div/div[6]/div/div/div/div/p"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'color:red; background:yellow')", we);

		
		
	}

}
