package stefdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.DashboardPage;
import pageObjects.Loginpage;
import utils.Driverfactory;

public class Dashboard_stepdef {

	private Loginpage lp=new Loginpage(Driverfactory.getdriver());
	private DashboardPage db;
	
	@Given("user is logged into the portal with username {string} and pwd {string}")
	public void user_is_logged_in(String username, String password) {
		Driverfactory.getdriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   db=lp.doLogin(username, password);
	}
	
	@Then("Upgrade button link is displayed")
	public void upgrade_button_link_is_displayed() {
		//db=new DashboardPage(Driverfactory.getdriver());
		Assert.assertEquals("Upgrade", db.getUpgradetext());
		
	   
	}
	@Then("menu list is displayed")
	public void menu_list_is_displayed(DataTable dataTable) {
	   List<String> expectedlist=dataTable.asList();
	   System.out.println("expected menu list is"+expectedlist);
	   List<String> actuallist=db.getMenuList();
	   System.out.println("actual menu list is"+actuallist);
	   Assert.assertTrue(expectedlist.containsAll(actuallist));
	   
	}

	@Then("count is {int}")
	public void count_is(Integer int1) {
	   Assert.assertTrue(db.getMenucount()==int1);
	}



	}




