package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Naresh Reddy
 * using to read the data from Excel

 */
public class TempoAuto {
	 static WebDriver driver;
	
	@BeforeMethod
	public static void setup() throws InterruptedException {		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://issues.guidingcare.com/secure/Tempo.jspa");
		driver.findElement(By.id("login-form-username")).sendKeys("nreddy");
		driver.findElement(By.id("login-form-password")).sendKeys("Nari@1234567890");
		driver.findElement(By.id("login-form-submit")).click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='aui-avatar aui-avatar-small']")).click();
		driver.findElement(By.id("log_out")).click();
		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 1)
	public static void method1() throws InterruptedException, IOException {
		for (int i = 25; i <=28; i++) {
			tempoAuto(""+i+"th July 2022",""+i+"/Jul/2022");
		}


	}	

	public static void tempoAuto(String sheetname, String datee) throws InterruptedException, IOException {
		System.out.println("Sheet date-->"+sheetname);
		String resourceName="Naresh";
		File file = new File("C:\\Users\\nbusireddy\\git\\Challenges\\Challenges\\DataProvider\\July-2022.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet(sheetname);
		DataFormatter formatter = new DataFormatter();
		int rowcount = sheet.getLastRowNum()+1;
		int columncount = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <=rowcount; i++) {
			for (int j = 0; j <=columncount; j++) {
				try {
					String values= formatter.formatCellValue(sheet.getRow(i).getCell(j));
					if(values!=null) {
						if(resourceName.equals(values)){
							String clientId = formatter.formatCellValue(sheet.getRow(i).getCell(2));
							String resolution=formatter.formatCellValue(sheet.getRow(i).getCell(7));
							String issueType=formatter.formatCellValue(sheet.getRow(i).getCell(4)).toLowerCase();
							System.out.println("Ticket id is-->"+clientId);
							System.out.println("Resolution-->"+resolution);
							Thread.sleep(5000);
							driver.findElement(By.name("logWorkButton")).click();
							Thread.sleep(2000);
							WebElement ele= driver.findElement(By.id("issuePickerInput"));
							ele.sendKeys(clientId);
							Thread.sleep(2000);
							ele.sendKeys(Keys.ENTER);

							//driver.findElement(By.xpath("//div[@class='sc-dNLxif fLotRs' and text()='History Search']/following-sibling::ul/li/div/div")).click();

							driver.findElement(By.id("comment")).sendKeys(resolution);
							Thread.sleep(2000);
							WebElement datess =driver.findElement(By.id("started"));
							datess.click();
							datess.sendKeys(Keys.CONTROL + "a");
							datess.sendKeys(Keys.DELETE);		
							datess.sendKeys(datee);
							Thread.sleep(1000);
							WebElement timeToSpend =driver.findElement(By.name("timeSpentSeconds"));
							timeToSpend.click();
							timeToSpend.sendKeys(Keys.CONTROL + "a");
							timeToSpend.sendKeys(Keys.DELETE);		
							timeToSpend.sendKeys("1");
							Thread.sleep(1000);
							timeToSpend.sendKeys(Keys.ENTER);
							Thread.sleep(1000);
							driver.findElement(By.id("_Test_")).click();					
							Thread.sleep(1000);
							if(issueType.equals("task")) {
								WebElement workTY=driver.findElement(By.xpath("//div[normalize-space(@class)='css-6vixg8-placeholder'][contains(text(),'Please select')]/following-sibling::div//input"));
								workTY.sendKeys("Dev - Analysis Task");
								Thread.sleep(1000); 
								workTY.sendKeys(Keys.ENTER);
								Thread.sleep(1000);
							}else {
								WebElement workTY=driver.findElement(By.xpath("//div[normalize-space(@class)='css-6vixg8-placeholder'][contains(text(),'Please select')]/following-sibling::div//input"));
								workTY.sendKeys("Triage");
								Thread.sleep(1000); 
								workTY.sendKeys(Keys.ENTER);
								Thread.sleep(1000);
							}					

							driver.findElement(By.xpath("//div[@id='_Client_']")).click();
							Thread.sleep(1000);
							WebElement clientBau= driver.findElement(By.xpath("//div[normalize-space(@class)='css-6vixg8-placeholder'][contains(text(),'Search Accounts...')]/following-sibling::div//input"));
							clientBau.sendKeys("PX-100202202 - Client BAU Support");					
							Thread.sleep(1000);
							clientBau.sendKeys(Keys.ENTER);
							Thread.sleep(2000);
							driver.findElement(By.name("submitWorklogButton")).click();
							Thread.sleep(2000);
							System.out.println(clientId+"-->Ticket Submitted");
						}
					}

				}catch (Exception e) {
					// TODO: handle exception
				}
			}

		}
		System.out.println("<-------------------------------------->");
		workBook.close();

	}
}
