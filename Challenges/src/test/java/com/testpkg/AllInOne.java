package com.testpkg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllInOne {
	
	static WebDriver driver;

	
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	datepicker("");
}

public static void waits() {
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofMillis(500));
	WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span"));
	wait.until(ExpectedConditions.visibilityOfAllElements(element));
	FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
	fwait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));

}

public static void navigate() throws InterruptedException {
	driver.get("https://www.bing.com");
	Thread.sleep(2000);
	driver.navigate().to("https://www.google.com");
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	driver.navigate().forward();
}

public static void driverclose() throws InterruptedException {
	
	driver.get("https://www.bing.com");
	Thread.sleep(2000);
	String firstwindow = driver.getWindowHandle();
	System.out.println(firstwindow);
	driver.close();
	
}

public static void datepicker(String givenMonth) throws InterruptedException {
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span")).click();
    Thread.sleep(2000);
    Date sampleDate = new Date(); // initialising the date object with the current date 
    System.out.println("Date is --->"+sampleDate);
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM yyyy");
    
    
    String date = formatter.format(sampleDate); // formatting the date object in dd-MMM yyyy format
    System.out.println("Formatted Date is --->"+date);
    String splitter[] = date.split("-");
    
    String monthYear = splitter[1]; // storing the month and year concatenated string excluding the day number
    System.out.println("monthYear is --->"+monthYear);

    String day = splitter[0]; // storing the day number in the current date
 
    System.out.println("Day is -->"+day);
    List<WebElement> month= driver.findElements(By.xpath("//div[@class='DayPicker-Month']/div[1]"));
    List<WebElement> li= driver.findElements(By.xpath("//div[@class='dateInnerCell']/p"));
    ////div[@class='DayPicker-Month'][1]/div[@class='DayPicker-Body']/div[@class='DayPicker-Week'][3]/div[@class='DayPicker-Day'][j]
    
    for (WebElement mo : month) {
    	if(mo.getText().equals(givenMonth)) {
    		
    	}
    	
		
	}
    	driver.quit();
		
	}

    
    

}



