package com.testpkg;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOM {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		driver.get("https://shop.polymer-project.org/");
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement ele=(WebElement)js.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-home\").shadowRoot.querySelector(\"div:nth-child(2) > shop-button > a\")");
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		WebElement ele2=(WebElement)js2.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-list\").shadowRoot.querySelector(\"ul > li:nth-child(1) > a > shop-list-item\").shadowRoot.querySelector(\"shop-image\").shadowRoot.querySelector(\"#img\")");
		js2.executeScript("arguments[0].click();", ele2);


	}
}
