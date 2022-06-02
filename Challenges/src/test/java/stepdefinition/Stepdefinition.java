/**
 * 
 */
package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageObjects.BaseClass;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author nbusireddy
 *
 */
public class Stepdefinition extends BaseClass {
		
	@Given("user is on login page")
	public void user_is_on_login_page() {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.get("https://www.saucedemo.com/");
		
	}

	@When("provided the input parameters UserName {string} and Password {string}")
	public void provided_the_input_parameters_user_name_and_password(String string, String string2) {
		loginPage = new LoginPage();
		loginPage.enterCredentials(string,string2);
		
	}

	@When("click on login button")
	public void click_on_login_button() {
		homePage =loginPage.signIN();
	}

	@When("verifying the Products")
	public void verifying_the_products() {	
		homePage.getProducts();
		
		
	   
	}

	
	
	
	
	
	
	
	
	
//	@Then("clicked on logout button")
//	public void clicked_on_logout_button() {
//	   
//	}

}
