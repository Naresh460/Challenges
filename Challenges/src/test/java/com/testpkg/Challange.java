package com.testpkg;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Challange {
	
	public static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {
		
		String totalPopulation="//div[@class='maincounter-number']/span[@class='rts-counter']";
		String todayPopulation= "//div[@class='col1in']//span[@class='rts-counter']";
		String yearPopulation ="//div[@class='col2in']//span[@class='rts-counter']";
		
		
		pupulateNumbers(todayPopulation);
		
	}
	
	public static void pupulateNumbers(String locator) throws InterruptedException {
		int count=1;
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.worldometers.info/world-population/");		
			List<WebElement> totlaP = driver.findElements(By.xpath(locator));
			System.out.println(totlaP.size());
			while (count<=20) {
				for (WebElement singleElement : totlaP) {
					String number =singleElement.getText();  		
					System.out.println(number);
				}
				Thread.sleep(1000);
				count++;
			}      	

	}
	
}
