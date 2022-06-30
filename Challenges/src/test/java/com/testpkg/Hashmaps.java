package com.testpkg;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Hashmaps  {
	WebDriver driver;
	
	@FindBy(id="")
	WebElement name;
	
	public Hashmaps() {
		//PageFactory.initElements(this, driver);
	}
	
public static void main(String[] args) {
	HashMap<String, Integer> hassmap = new HashMap<>();
	hassmap.put("Naresh", 1);
	hassmap.put("Anil", 2);
	
	System.out.println(hassmap);
	
	//* get the values from the hasmap
	System.out.println(hassmap.get("Naresh"));
	
	// remove values in set
	
	System.out.println(hassmap.remove("Naresh"));
	
	//replace values
	
	System.out.println(hassmap.replace("Naresh", 5));
}


@Test (priority = 1,alwaysRun = true,enabled = false,groups = {"sanity,smoke"}, dependsOnMethods = {"method_name"},ignoreMissingDependencies = true,dataProvider = "dataprovider_name")@Parameters("browsername")
public void testing(@Optional("Chrome") String browsername) {
	System.out.println("This is disabled");
	
	
	
	
}
@Test@DataProvider(name="naresh")
public void providerData() {
	
}
}
