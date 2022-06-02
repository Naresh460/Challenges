/**
 * 
 */
package com.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author nbusireddy
 *
 */
public class HomePage extends BaseClass {

	@FindBy(xpath = "//div[@class=\"inventory_list\"]/div")
	List<WebElement> list_product;


	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	public void getProducts() {		

		List<Double> amountlist = new ArrayList<Double>();
		for(int i=1;i<=list_product.size(); i++) {
			WebElement element =driver.findElement(By.xpath("//div[@class=\"inventory_list\"]/div["+i+"]/div[2]/div[2]/div"));
			String amount = element.getText();
			String amountnum=amount.replaceAll("[^a-zA-Z0-9]","");
			double finalTotalPrice=Double.parseDouble(amountnum);
			double finalampunt =finalTotalPrice/100;
			amountlist.add(finalampunt);

			/**Simple way to get MaxPrice
			 * 
			 */
			//Double maxprice=list_product.stream().mapToDouble(e->Double.parseDouble(e.getText().trim().replaceAll("$", "")))
			//				                            .max().getAsDouble();


		}
		Double highestNumber = Collections.max(amountlist);

		WebElement element3 =driver.findElement(By.xpath("//div[normalize-space()='$"+highestNumber+"']/following-sibling::button"));
		element3.click();

	}

}






