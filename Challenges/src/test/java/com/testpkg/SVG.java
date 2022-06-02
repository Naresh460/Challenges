package com.testpkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVG {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.setHeadless(true);
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/search?q=covid+cases+in+india&rlz=1C1GCEU_enIN1006IN1006&oq=coivd+caes&aqs=chrome.1.69i57j0i10i433j0i10i433i457j0i402l2j0i10i433l3j0i131i433j0i10i433.3895j0j7&sourceid=chrome&ie=UTF-8");
		List<WebElement> rectlist = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[1]//*[name()='rect']"));
		System.out.println(rectlist.size());
		for (WebElement ele : rectlist) {
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			String countt = driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText();
			System.out.println(countt);

		}

	}

}
