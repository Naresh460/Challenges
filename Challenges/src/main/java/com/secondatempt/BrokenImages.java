package com.secondatempt;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImages {
public static void main(String[] args) {
	  WebDriverManager.chromedriver().setup();		
			ChromeOptions op =new ChromeOptions();
			op.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
			WebDriver driver = new ChromeDriver(op);
			driver.get("https://www.theworldsworstwebsiteever.com");
			List<WebElement> listimgs= driver.findElements(By.tagName("img"));
			for (WebElement immgs : listimgs) {
				String imggSrc = immgs.getAttribute("src");
				try {
				URL url=new URL(imggSrc);				
				URLConnection urlCon=url.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection)urlCon;
				httpURLConnection.setConnectTimeout(5000);
				httpURLConnection.connect();
				if(httpURLConnection.getResponseCode()==200) {
					System.out.println("Result-->"+httpURLConnection.getResponseMessage());
					
				}
				else {
					System.out.println("Result-->"+httpURLConnection.getResponseMessage());
				}

				}
				catch (Exception e) {
					// TODO: handle exception
				}
				
			}
}
}
