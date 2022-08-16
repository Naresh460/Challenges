package com.practice;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart_search {

	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		
		List<Integer> li = new ArrayList<>();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		driver.findElement(By.name("q")).sendKeys("refrigerator");
		driver.findElement(By.xpath("//div[@class='col-12-12 _2oO9oE']/button")).click();
		Thread.sleep(2000);
		List<WebElement> lis =driver.findElements(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/div[position()>1  and position() < (last()-1)]//div[@class='_30jeq3 _1_WHN1'] "));
		//List<WebElement> fridgename =driver.findElements(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/div[position()>1  and position() < (last()-1)]//div[@class='_4rR01T']"));
		int result = lis.size();
		for (WebElement we : lis) {
			String Amounts=we.getAttribute("textContent");
			System.out.println(Amounts);
			String fin = Amounts.replaceAll("[^a-z0-9A-Z]", "");

			int fin_int=Integer.parseInt(fin);  
			li.add(fin_int);		
		}
		int maxnumber =Collections.max(li);
		String s=Integer.toString(maxnumber);
		//		Locale lcl = new Locale("en","IN");
		//		NumberFormat inFrmt = NumberFormat.getCurrencyInstance(lcl);		
		//		System.out.println(inFrmt.format(maxnumber));

		//Converting max number to indian curremcy

		StringBuilder sb = new StringBuilder();
		char amountArray[] = s.toCharArray();
		int a = 0, b = 0;
		for (int i = amountArray.length - 1; i >= 0; i--) {
			if (a < 3) {
				sb.append(amountArray[i]);
				a++;
			} else if (b < 2) {
				if (b == 0) {
					sb.append(",");
					sb.append(amountArray[i]);
					b++;
				} else {
					sb.append(amountArray[i]);
					b = 0;
				}
			}
		}
		//indian currency format
		String string = "\u20B9";
		byte[] utf8 = string.getBytes("UTF-8");
		string = new String(utf8, "UTF-8");
		String cureen = string+sb.reverse().toString();
		System.out.println("Highest Price-->"+cureen);
		Thread.sleep(2000);
		WebElement wle =driver.findElement(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/div[position()>1  and position() < (last()-1)]//div[text()='"+cureen+"']//parent::div//parent::div//parent::div//parent::div//div[@class='_4rR01T']"));
		wle.click();
		//  System.out.println(wle.getAttribute("textContent"));
		System.err.println(wle.getAttribute("textContent"));
		Thread.sleep(6000);
		
		driver.quit();


	}

}


