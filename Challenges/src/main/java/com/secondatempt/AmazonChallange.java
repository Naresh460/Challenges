package com.secondatempt;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonChallange {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		List<Integer> li = new ArrayList<>();
		int givenPrice=11499;
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
		driver.findElement(By.id("nav-search-submit-button")).click();		
		List<WebElement> getproductname=driver.findElements(By.xpath("//div[@class='a-section a-spacing-none _bXVsd_block_1vI8- _bXVsd_row_3CEm0']/div[@class='_bXVsd_gridColumn_2Jfab']"));
		
		int length=getproductname.size();
		for (int i = 1; i <=length; i++) {
			WebElement getname =driver.findElement(By.xpath("//div[@class='a-section a-spacing-none _bXVsd_block_1vI8- _bXVsd_row_3CEm0']/div[@class='_bXVsd_gridColumn_2Jfab']["+i+"]//div[@class='a-section a-spacing-none']/a"));
			String nameoftheProd= getname.getText();
			if (nameoftheProd.contains("Blue")) {
				System.out.println(nameoftheProd);
				WebElement pricename =driver.findElement(By.xpath("//div[@class='a-section a-spacing-none _bXVsd_block_1vI8- _bXVsd_row_3CEm0']/div[@class='_bXVsd_gridColumn_2Jfab']["+i+"]//div[@class='a-section a-spacing-none']/a/following-sibling::div//span[@class='a-color-link']"));	
				String nameofPrice=pricename.getText();
				
				String fin = nameofPrice.replaceAll("[^a-z0-9A-Z]", "");
				int fin_int=Integer.parseInt(fin);
				System.out.println("Price is-->"+fin_int);
				li.add(fin_int);
				
				if(fin_int == givenPrice ) {
					System.out.println("givenPrice"+givenPrice);
					System.out.println("Fin prive"+fin_int);
					pricename.click();
					
				}
							}			
		}
		
		List<WebElement> getproductname2=driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[starts-with(@class,'s-result-item s-asin')]"));
		int length2= getproductname2.size();
		for (int i = 1; i <=length2; i++) {
			WebElement prod2= driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[starts-with(@class,'s-result-item s-asin')]["+i+"]//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/h2"));	
			String getname2=prod2.getText();
			if (getname2.contains("Blue,")) {
				System.out.println("Price2 is-->"+getname2);
				Thread.sleep(2000);
				WebElement pricename2 =driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[starts-with(@class,'s-result-item s-asin')]["+i+"]//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/h2/parent::div/following-sibling::div[2]/div[1]//span[@class='a-price']//span[@class='a-offscreen'][1]"));	
				Thread.sleep(2000);
				String nameofPrice2=pricename2.getAttribute("innerText");
				Thread.sleep(2000);				
				String fin2 = nameofPrice2.replaceAll("[^a-z0-9A-Z]", "");
				int fin_int2=Integer.parseInt(fin2);
				System.out.println("Price is-->"+fin_int2);
				Thread.sleep(2000);
				
						
				if(fin_int2 == givenPrice ) {
					System.out.println("givenPrice"+givenPrice);
					System.out.println("Fin prive"+fin_int2);
					String parentwindow=driver.getWindowHandle();
					driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[starts-with(@class,'s-result-item s-asin')]["+i+"]//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/h2/parent::div/following-sibling::div[2]/div[1]//span[@class='a-price']//span[@class='a-offscreen'][1]/parent::span/parent::a")).click();
					Thread.sleep(2000);
					Set<String> childWindows= driver.getWindowHandles();
					for (String childWin : childWindows) {
						if(!parentwindow.equals(childWin)) {
							driver.switchTo().window(childWin);
							WebElement cartt =driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
							cartt.click();
							Thread.sleep(4000);
							driver.findElement(By.id("attach-close_sideSheet-link")).click();
							Thread.sleep(2000);
							driver.findElement(By.id("nav-cart-count-container")).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@value='Delete']")).click();
						}
						
					}
					
					
					
				}

			}	
			
		}		
		
	
	
		
	
			}
		
				
		
		
	}


