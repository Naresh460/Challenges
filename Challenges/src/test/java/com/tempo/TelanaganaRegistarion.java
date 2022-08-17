package com.tempo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TelanaganaRegistarion {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://registration.telangana.gov.in");
		Thread.sleep(3000);
		String parentwindoww=driver.getWindowHandle();
		//System.out.println(parentwindoww);
		driver.findElement(By.partialLinkText("Encumbrance")).click();		
		Thread.sleep(3000); 
		Set<String> childw=driver.getWindowHandles();
		for (String childd : childw) {
			if(!parentwindoww.equalsIgnoreCase(childd)) {
				//System.out.println(childw);
			driver.switchTo().window(childd);
			driver.findElement(By.xpath("//div[@class='clearfix']/following-sibling::div/a")).click();
			//driver.get("https://registration.telangana.gov.in/EncumbranceCertificate/Search_Document.htm");
			Thread.sleep(3000);
			driver.findElement(By.id("doct")).sendKeys("10476");
			driver.findElement(By.id("regyear")).sendKeys("2021");
			driver.findElement(By.id("sroVal")).sendKeys("1528");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]/li")).click();
			driver.findElement(By.xpath("//div[@id=\"docno\"]/div[4]/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("checkall2")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			Thread.sleep(3000);

			String dateName = new SimpleDateFormat("dd-MM-YYYY-hhmmss").format(new Date());
			Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1500)).takeScreenshot(driver);           
                ImageIO.write(screenshot.getImage(),"PNG",new File("C:\\\\Users\\\\nbusireddy\\\\git\\\\Challenges\\\\Challenges\\\\Screenshots\\\\EC-"+dateName+".png"));
		      System.out.println("Screenshot taken");
			
			}
		}
		
		driver.quit();
	}

}
