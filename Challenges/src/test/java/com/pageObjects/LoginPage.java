/**
 * 
 */
package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author nbusireddy
 *
 */
public class LoginPage extends BaseClass{
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement passwords;
	
	@FindBy(id="login-button")
	WebElement signBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterCredentials(String usernamee, String passwordd ) {
		
		username.sendKeys(usernamee);
		passwords.sendKeys(passwordd);
	}
	
	public HomePage signIN() {
		 signBtn.click();
		 return new HomePage();
	}

	
}
