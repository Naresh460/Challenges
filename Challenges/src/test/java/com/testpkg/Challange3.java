package com.testpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Challange3 {
	//	public static void main(String[] args) throws InterruptedException {
	//		testingg("Trending deals in kitchen & dining");
	//	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.noon.com/uae-en/");	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		for (int i = 0; i < 10000; i += 40) {
			js.executeScript("window.scrollTo(0, " + i + ")");
		}


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200),Duration.ofMillis(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sc-160e1e76-10 bQUOLL']")));
		List<WebElement> listti = driver.findElements(By.xpath("//div[@class='sc-160e1e76-10 bQUOLL']"));
		System.out.println(listti.size());
		for (WebElement weelemt : listti) {
			System.out.println("Text is ------->"+weelemt.getAttribute("innerText"));
		}}
	}
