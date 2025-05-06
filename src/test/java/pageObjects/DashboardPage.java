package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dbTitle = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6");
    private By updatebtn=By.cssSelector("button.oxd-glass-button.orangehrm-upgrade-button");
    private By menulist=By.xpath("//*[@class='oxd-main-menu']/li/a/span");
    public String getDashboardTitle() {
        return driver.findElement(dbTitle).getText();
    }
    public String getUpgradetext()
    {
		String text=driver.findElement(updatebtn).getText();
    	return text;
    	
    }
    public List<String> getMenuList()
    {
    	List<String> sectionlist=new ArrayList<>();
    	List<WebElement> menus=driver.findElements(menulist);
    for(WebElement l:menus)
    {
    	String text=l.getText();
    	sectionlist.add(text);
    }
    return sectionlist;
    }
    
    public int getMenucount()
    {
    	int count=driver.findElements(menulist).size();
    	
		return count;
    	
    }
}