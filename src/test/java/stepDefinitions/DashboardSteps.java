package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pages.DashboardPage;
import utilities.DriverFactory;

public class DashboardSteps {

    private DashboardPage dashboardPage;

    private DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(DriverFactory.getDriver());
        }
        return dashboardPage;
    }

    @Then("Dashboard heading should be displayed")
    public void verifyDashboardHeading() {
        Assert.assertTrue(getDashboardPage().isDashboardDisplayed(), "Dashboard heading is not displayed");
    }

    @Then("actual url should match the expected url")
    public void verifyDashboardUrl() {
        Assert.assertTrue(getDashboardPage().verifyDashboardUrl(), "Dashboard URL did not match expected path");
    }

    @Then("dashboard widgets are displayed")
    public void verifyDashboardWidgets() {
        Assert.assertTrue(getDashboardPage().isdashboardWidgetsDisplayed(), "One or more Dashboard widgets are missing");
    }

    @Then("actual names should match the expected names in assign leave")
    public void verifyAssignLeaveLabels() {
        getDashboardPage().clickAssignLeave();
        Assert.assertTrue(getDashboardPage().isAssignLeaveWidgetsDisplayed(), "Assign Leave labels did not match");
    }
}