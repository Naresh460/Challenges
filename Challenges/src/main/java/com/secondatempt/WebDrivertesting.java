package com.secondatempt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDrivertesting {
public static void main(String[] args) {
	WebDriverManager.edgedriver().setup();
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	WebDriverManager.safaridriver().setup();
	WebDriver driver = new EdgeDriver();
	driver.get("https://www.google.com");
}
}
