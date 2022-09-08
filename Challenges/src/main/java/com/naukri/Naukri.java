package com.naukri;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Naukri {
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i <= 2; i++) {
			System.out.println(i);
			naukri();
		}
	}
	
	
	public static void naukri() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com");
		driver.findElement(By.id("login_Layer")).click();
		driver.findElement(By.xpath("//form[@name='login-form']/div[2]/input")).sendKeys("Naresh_busireddy@yahoo.com");
		driver.findElement(By.xpath("//form[@name='login-form']/div[3]/input")).sendKeys("123456");
		driver.findElement(By.xpath("//form[@name='login-form']/div[6]/button")).click();
		driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']")).click();
		driver.findElement(By.linkText("View & Update Profile")).click();
		driver.findElement(By.xpath("//em[@class='icon edit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("saveBasicDetailsBtn")).click();
		driver.findElement(By.id("attachCV")).sendKeys(System.getProperty("user.dir")+"\\DataProvider\\Naresh_Profile.docx");
		driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']")).click();
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		driver.quit();
		System.out.println("Profile updated Successfully");
		Thread.sleep(30000);
		
	}

}
