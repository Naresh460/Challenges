package com.secondatempt;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]/li[not(@class='multiselect-item multiselect-group')]/a"));
	for (WebElement option : options) {
		String optionName= option.getText();
		option.click();
		System.out.println(optionName);
		
	}
	
	}

}
