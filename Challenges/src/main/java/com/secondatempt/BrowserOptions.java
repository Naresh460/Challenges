package com.secondatempt;

import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserOptions {
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
				ChromeOptions dc = new ChromeOptions();
				String name=dc.getBrowserName();
				//String version =dc.getBrowserVersion();
				dc.addArguments("--incognito");
				
		        WebDriver driver=new ChromeDriver(dc);		
		        Capabilities cap = ((ChromeDriver) driver).getCapabilities();
		        String version =cap.getBrowserVersion();
							
		driver.get("https://www.google.com");
		System.out.println(name);		
		System.out.println("Versions--->"+version);
		driver.quit();
	}

}
