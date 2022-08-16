package com.practice;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
	static WebDriver driver;
	@FindBy(xpath="")
	WebElement name;
	
	public Waits() {
		PageFactory.initElements(driver, this);
	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(null);
		WebDriverWait wait = new WebDriverWait(driver, null);
		//wait.until("");
		Capabilities cap=((ChromiumDriver) driver).getCapabilities();
		cap.getBrowserVersion();
		
		
		
	}

}
