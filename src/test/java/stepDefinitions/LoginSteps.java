package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.DashboardPage;
import utilities.Configreader;
import utilities.DriverFactory;

public class LoginSteps {

    private LoginPage loginPage;
    
    private LoginPage getLoginpage() {
    	if(loginPage==null) {
    	loginPage = new LoginPage(DriverFactory.getDriver());
    	}
		return loginPage;
    	
    }
    
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
    	getLoginpage().enterUsername(
                Configreader.getProperty("username"));

    	getLoginpage().enterPassword(
                Configreader.getProperty("password"));
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_credentials() throws Exception {

//    	Thread.sleep(2000);
    	getLoginpage().enterUsername(
                Configreader.getProperty("invalidusername"));

    	getLoginpage().enterPassword(
                Configreader.getProperty("invalidpassword"));
    }
    
    @When("user keeps the username and password fields empty")
    public void user_enters_empty_credentials() throws Exception {
        //when user keeps empty fields
    }
    
    @When("user clicks on login button")
    public void user_clicks_login_button() throws Exception {
    	getLoginpage().clickLogin();
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
    			getLoginpage().isErrorMessageDisplayed(),
    	        "Invalid credentials error message is not displayed"
    	    );   	
    }
    
    @Then("user should see error msg as required")
    public void show_error_message_as_requored() {
    	Assert.assertTrue(
    			getLoginpage().isEmptyUserErrorMessageDisplayed(),
    	        "Username required message is not displayed"
    	    );
    	Assert.assertTrue(
    			getLoginpage().isEmptypasswordErrorMessageDisplayed(),
    	        "Password required message is not displayed"
    	    );  
    	   	
    }
    @Given("user is logged in to OrangeHRM")
    public void user_is_logged_in_to_orangehrm() throws Exception {

        DriverFactory.getDriver().get(
            Configreader.getProperty("url")
        );

        loginPage = new LoginPage(DriverFactory.getDriver());

        getLoginpage().enterUsername(
            Configreader.getProperty("username")
        );

        getLoginpage().enterPassword(
            Configreader.getProperty("password")
        );

        getLoginpage().clickLogin();
    }

    @When("user clicks on logout dropdown")
    
    public void user_clicks_on_logout_dropdown() {
    	getLoginpage().clickLogoutDropdown();
    }

    @When("user clicks on logout option")
    public void user_clicks_on_logout_option() {
    	getLoginpage().clickLogoutOption();
    }

    @Then("user should see login message")
    public void user_should_see_login_page() {
        Assert.assertTrue(
        		getLoginpage().isLoginHeaderDisplayed(),
            "Login page is not displayed after logout"
        );
    }
    
}