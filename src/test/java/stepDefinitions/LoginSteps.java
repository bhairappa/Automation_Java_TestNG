package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.Configreader;
import utilities.DriverFactory;

public class LoginSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    private LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(DriverFactory.getDriver());
        }
        return loginPage;
    }

    private DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(DriverFactory.getDriver());
        }
        return dashboardPage;
    }

    @Given("user is on the OrangeHRM login page")
    public void userIsOnLoginPage() {
        DriverFactory.getDriver().get(Configreader.getProperty("url"));
    }

    @Given("user is logged in to OrangeHRM")
    public void userIsLoggedInToOrangeHRM() {
        DriverFactory.getDriver().get(Configreader.getProperty("url"));
        getLoginPage().login(
            Configreader.getProperty("username"),
            Configreader.getProperty("password")
        );
        Assert.assertTrue(getDashboardPage().isDashboardDisplayed(), "Dashboard did not load after login");
    }

    @When("user enters valid username and password")
    public void enterValidCredentials() {
        getLoginPage().enterUsername(Configreader.getProperty("username"));
        getLoginPage().enterPassword(Configreader.getProperty("password"));
    }

    @When("user enters invalid username and password")
    public void enterInvalidCredentials() {
        getLoginPage().enterUsername("invalidUser");
        getLoginPage().enterPassword("invalidPass123");
    }

    @When("user keeps the username and password fields empty")
    public void keepFieldsEmpty() {
        getLoginPage().enterUsername("");
        getLoginPage().enterPassword("");
    }

    @When("user clicks on login button")
    public void clickLoginButton() {
        getLoginPage().clickLogin();
    }

    @Then("OrangeHRM Dashboard should be displayed")
    public void verifyDashboardDisplayed() {
        Assert.assertTrue(getDashboardPage().isDashboardDisplayed(), "OrangeHRM Dashboard is not displayed");
    }

    @Then("user should see error msg")
    public void verifyInvalidErrorMsg() {
        Assert.assertTrue(getLoginPage().isErrorMessageDisplayed(), "Invalid credentials error message not displayed");
    }

    @Then("user should see error msg as required")
    public void verifyRequiredErrorMsg() {
        Assert.assertTrue(getLoginPage().isEmptyUserErrorMessageDisplayed(), "Username required error not displayed");
        Assert.assertTrue(getLoginPage().isEmptypasswordErrorMessageDisplayed(), "Password required error not displayed");
    }

    @When("user clicks on logout dropdown")
    public void clickLogoutDropdown() {
        getLoginPage().clickLogoutDropdown();
    }

    @When("user clicks on logout option")
    public void clickLogoutOption() {
        getLoginPage().clickLogoutOption();
    }

    @Then("user should see login message")
    public void verifyLoginHeaderDisplayed() {
        Assert.assertTrue(getLoginPage().isLoginHeaderDisplayed(), "Login page header not displayed after logout");
    }
}