package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.LoginPage;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.Configreader;
import utilities.DriverFactory;

public class LoginSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("user is on the OrangeHRM login page")
    public void user_is_on_login_page() {

        DriverFactory.getDriver()
                .get(Configreader.getProperty("url"));

        loginPage =
                new LoginPage(DriverFactory.getDriver());
    }

    @When("user enters valid username and password")
    public void user_enters_valid_credentials() throws Exception {

//    	Thread.sleep(2000);
        loginPage.enterUsername(
                Configreader.getProperty("username"));

        loginPage.enterPassword(
                Configreader.getProperty("password"));
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_credentials() throws Exception {

//    	Thread.sleep(2000);
        loginPage.enterUsername(
                Configreader.getProperty("invalidusername"));

        loginPage.enterPassword(
                Configreader.getProperty("invalidpassword"));
    }
    
    @When("user keeps the username and password fields empty")
    public void user_enters_empty_credentials() throws Exception {
        //when user keeps empty fields
    }
    
    @When("user clicks on login button")
    public void user_clicks_login_button() throws Exception {
        loginPage.clickLogin();
    }
   
    @Then("OrangeHRM Dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        dashboardPage =
                new DashboardPage(DriverFactory.getDriver());

        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed after login"
        );
    }
    
    @Then("user should see error msg")
    public void show_error_message() {
    	Assert.assertTrue(
    	        loginPage.isErrorMessageDisplayed(),
    	        "Invalid credentials error message is not displayed"
    	    );   	
    }
    
    @Then("user should see error msg as required")
    public void show_error_message_as_requored() {
    	Assert.assertTrue(
    	        loginPage.isEmptyUserErrorMessageDisplayed(),
    	        "Username required message is not displayed"
    	    );
    	Assert.assertTrue(
    	        loginPage.isEmptypasswordErrorMessageDisplayed(),
    	        "Password required message is not displayed"
    	    );  
    	   	
    }
    @Given("user is on login page")
    public void user_is_logged_in_to_orangehrm() throws Exception {

        DriverFactory.getDriver().get(
            Configreader.getProperty("url")
        );

        loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.enterUsername(
            Configreader.getProperty("username")
        );

        loginPage.enterPassword(
            Configreader.getProperty("password")
        );

        loginPage.clickLogin();
    }

    @When("user clicks on logout dropdown")
    public void user_clicks_on_logout_dropdown() {
        loginPage.clickLogoutDropdown();
    }

    @When("user clicks on logout option")
    public void user_clicks_on_logout_option() {
        loginPage.clickLogoutOption();
    }

    @Then("user should see login message")
    public void user_should_see_login_page() {
        Assert.assertTrue(
            loginPage.isLoginHeaderDisplayed(),
            "Login page is not displayed after logout"
        );
    }
    
}