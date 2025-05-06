package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory { 
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	public WebDriver initdriver(String browser)
	{
		System.out.println("=== Starting Scenario: ");
	 WebDriverManager.chromedriver().setup();
     tlDriver.set(new ChromeDriver());
    getdriver().manage().window().maximize();
     getdriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     return getdriver();

		
	}
	public static synchronized WebDriver getdriver()
	{
		return tlDriver.get();
	}

}
