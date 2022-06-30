package com.testpkg;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImages {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/broken_images");
	List<WebElement> listt= driver.findElements(By.tagName("img"));
	for (WebElement lis : listt) {
		String imageSrc =lis.getAttribute("src");
		System.out.println("Img Src-->"+imageSrc);
		try {
			URL url = new URL(imageSrc);
			URLConnection urlconnection =url.openConnection();
			HttpURLConnection httpurlconne = (HttpURLConnection)urlconnection;
			httpurlconne.connect();
			if(httpurlconne.getResponseCode()==200) {
				System.out.println(imageSrc+"<------>"+httpurlconne.getResponseCode()+"<------>"+httpurlconne.getResponseMessage());
			}
			
			else {
				System.err.println(imageSrc+"<---->"+httpurlconne.getResponseCode()+"<------>"+httpurlconne.getResponseMessage());
			}
			httpurlconne.disconnect();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
}
