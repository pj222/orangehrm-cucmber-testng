package hooks;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.Driverfactory;

public class Setup {
	
	private Driverfactory dp;
	private WebDriver driver;
	private ConfigReader cg;
	Properties prop;
	
	@Before(order=0)
  public void getproperty() throws FileNotFoundException
  {
		cg=new ConfigReader();
		prop=cg.init_prop();
  }
	@Before(order=1)
	public void setupbrowser() {
		String browsername=prop.getProperty("browser");
		 dp=new Driverfactory();
		 driver=dp.initdriver(browsername);
	}
	
	@After(order=0)
	public void closebowser()
	{
		driver.quit();
	}
	@After(order=1)
	public void takescreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotname=scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotname);
		}
	}



	
	

			}
