package com.secondatempt;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandles {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com");
		String parent=driver.getWindowHandle();
		System.out.println("Parent"+parent);
		driver.findElement(By.id("register_Layer")).click();
		Set<String> child=driver.getWindowHandles();
		for (String ch : child) {
			System.out.println(ch);
			if(parent.equals(ch)) {
				System.out.println("If--->"+ch);
				driver.close();
			}else {
			driver.switchTo().window(ch);
			driver.findElement(By.id("name")).sendKeys("Naresh");
			}
		}
		
	}

}
