package com.testpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author nbusireddy
 * Used Javascript executor to scroll the page to down for loading
 * get the list of the span tages and iterate for text
 * instead of getText use getAttribute("innerText")
 *
 */
public class Challange2 {
	
public static void main(String[] args) throws InterruptedException {
	testingg("Trending deals in kitchen & dining");
}

	public static void testingg(String sectionName) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.noon.com/uae-en/");	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		 for (int i = 0; i < 10000; i += 50) {
		      js.executeScript("window.scrollTo(0, " + i + ")");
		   }

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200),Duration.ofMillis(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='"+sectionName+"']/parent::div/following-sibling::div//div[@class='sc-d3293424-11 iOSKQc']/span")));
		List<WebElement> listti = driver.findElements(By.xpath("//h3[text()='"+sectionName+"']/parent::div/following-sibling::div//div[@class='sc-d3293424-11 iOSKQc']/span"));

		for (WebElement weelemt : listti) {
			System.out.println("Text is ------->"+weelemt.getAttribute("innerText"));
		}
		driver.quit();
	}
}
