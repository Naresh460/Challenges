package com.testpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class FlipKart {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200),Duration.ofMillis(500));
		driver.get("https://www.flipkart.com/");	
		/*
		 * 
		 * Login pop is normal way
		 */
		driver.findElement(By.xpath("//div[@class='_2MlkI1']//div[@class='IiD88i _351hSN']/input[@class='_2IX_2- VJZDxU']")).sendKeys("Naresh");
		driver.findElement(By.xpath("//div[@class='_2MlkI1']//div[@class='IiD88i _351hSN']/input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("Naresh");	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		for (int i = 0; i < 10000; i += 20) {
			js.executeScript("window.scrollTo(0, " + i + ")");
		}


		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Trending Offers']/parent::div/parent::div/following-sibling::div//div[@class='_37K3-p']//a")));
		List<WebElement> listti = driver.findElements(By.xpath("//h2[text()='Trending Offers']/parent::div/parent::div/following-sibling::div//div[@class='_37K3-p']//a"));
		System.out.println(listti.size());
		for (WebElement weelemt : listti) {
			System.out.println("Text is ------->"+weelemt.getAttribute("innerText"));
			System.out.println();
		}
		
		driver.quit();	
	}
}
