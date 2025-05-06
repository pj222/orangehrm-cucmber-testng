package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/resources//features/"},
glue= {"stefdefs","hooks"},
plugin= {"pretty", "html:target/cucumber-reports","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:target/test-output-thread/"},
monochrome = true,
dryRun=false)
public class RunTest extends AbstractTestNGCucumberTests {

	@Override
	
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
