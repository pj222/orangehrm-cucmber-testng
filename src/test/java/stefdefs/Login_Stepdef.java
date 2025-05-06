package stefdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Loginpage;
import utils.Driverfactory;
import hooks.Setup;

import org.testng.Assert;

import hooks.Setup;

//import hooks.Webdriversetup;

public class Login_Stepdef {

	private Loginpage lp=new Loginpage(Driverfactory.getdriver());


	// WebDriver driver=Setup.getDriver();
	
	// Setup s=new Setup();
	@Given("user is on portal")
	public void user_is_on_portal() {
			
		
		Driverfactory.getdriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@When("user puts correct username {string} and pwd {string}")
	public void user_puts_correct_username_and_pwd(String user, String pwd) {
		lp.enterusername(user);
		lp.enterpwd(pwd);
	}

	@When("clicks login button")
	public void clicks_login_button() {
		lp.login();
	}

	@Then("home page opens")
	public void home_page_opens() {
		
Assert.assertEquals("OrangeHRM", lp.getTtitle());
		//System.out.println("home page with title" + title + "opens");
	}

	/*
	 * @Then("title is orangehrm") public void title_is_orangehrm() {
	 * Assert.assertEquals(driver.getTitle(), "orangehrm"); }
	 */

}
