package com.testpkg;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.awt.Rectangle;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.monte.media.FormatKeys.MediaType;
import static org.monte.media.FormatKeys.MediaTypeKey;
import org.monte.media.Format;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.FormatKeys.MIME_QUICKTIME;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;



public class VideoRecorder {
	WebDriver  driver;
	WebDriverWait wait ;
	static ScreenRecorder sr;


	@BeforeMethod
	public void setup() throws IOException, AWTException {		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		java.awt.Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rct = new Rectangle(size.width, size.height);
		File file = new File("./recording/");
		sr= new ScreenRecorder(gc,rct,
				new Format(MediaTypeKey, MediaType.FILE,
						MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						new Rational(15,1)),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, new Rational(30,1)),
				null,file		
				);
		


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sr.start();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(200),Duration.ofMillis(500));
	}

	@Test
	public void main() throws InterruptedException {

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

	@AfterMethod
	public void tearDown() throws IOException {
		sr.stop();
		driver.quit();	
	}
}
