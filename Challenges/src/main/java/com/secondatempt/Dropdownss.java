package com.secondatempt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdownss {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://registration.telangana.gov.in/UnitRateMV/getDistrictList.htm");
		//Thread.sleep(4000);
		driver.findElement(By.name("search_by")).click();
		WebElement district = driver.findElement(By.id("districtCode"));
		Select dis=new Select(district);
		dis.selectByVisibleText("RANGAREDDY");
		
		WebElement mandal = driver.findElement(By.id("mandalCode"));
		Select manda = new Select(mandal);
		manda.selectByVisibleText("ABDULLAPURMET");
		WebElement villag = driver.findElement(By.id("villageCode"));
		Select villa = new Select(villag);
		villa.selectByVisibleText("TURKAYAMJAL");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
		driver.quit();
		
	}

}
