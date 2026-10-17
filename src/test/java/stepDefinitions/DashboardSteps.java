package stepDefinitions;

import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;
import utilities.DriverFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BasePage;
import io.cucumber.java.en.Then;

public class DashboardSteps{

//public DashboardSteps(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}
//    @FindBy(xpath = "//h6[text()='Dashboard']")
//    private WebElement dashboardHeader;
	
//  public boolean isDashboardDisplayed() {
//  return dashboardHeader.isDisplayed();
//}
	
private DashboardPage dashboardPage;

    @Then("Dashboard heading should be displayed")
    public void isDashboardDisplayed() {
        dashboardPage = new DashboardPage(
                DriverFactory.getDriver()
            );
    Assert.assertTrue(
            dashboardPage.isDashboardDisplayed(),
            "Dashboard is not displayed after login"
    );
    }
    
    @Then("actual url should match the expected url")
    public void verifyDashboardURLAfterLogin() {
    	String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"; 
    	Assert.assertEquals(dashboardPage.getActualurl(),expectedUrl, "actualurl does not matches the expected url");
    }
    @Then("dashboard widgets are displayed")
    public void isdashboardWidgetTimeAndWOrkDisplayed() {
    	 Assert.assertTrue(
    	            dashboardPage.isdashboardWidgetsDisplayed(),
    	            "Dashboard Widgets are not displayed after dashboard visibility"
    	    );
    }

}