package com.base;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventHandl extends Base implements WebDriverListener {
	
	public void beforeClick(WebElement element) {
	try {
		screenShot();
		System.out.println("Listner");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
