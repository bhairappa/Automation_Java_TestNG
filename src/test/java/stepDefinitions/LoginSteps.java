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
    public void user_enters_valid_credentials() {

        loginPage.enterUsername(
                Configreader.getProperty("username"));

        loginPage.enterPassword(
                Configreader.getProperty("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_login_button() {

        loginPage.clickLogin();
    }

    @Then("OrangeHRM dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        dashboardPage =
                new DashboardPage(DriverFactory.getDriver());

        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed after login"
        );
    }
}