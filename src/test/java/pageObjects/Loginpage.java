package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
private WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	By username=By.name("username");
	By pwd=By.name("password");
	By Loginbtn=By.xpath("//button[@type='submit']");
	
	public void enterusername(String user) {
		driver.findElement(username).sendKeys(user);	
	}
	public void enterpwd(String pass) {
		driver.findElement(pwd).sendKeys(pass);	
	}
	
	public void login()
	{
				
		driver.findElement(Loginbtn).click();
		
	}
	public String getTtitle()
	{
		return driver.getTitle();
	}
	public DashboardPage doLogin(String un,String pw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(pwd).sendKeys(pw);	
		driver.findElement(Loginbtn).click();
		return new DashboardPage(driver);
		
	}
}
