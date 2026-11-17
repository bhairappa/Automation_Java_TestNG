package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import utilities.DriverFactory;

public class AdminSteps {

    private AdminPage adminPage;
    private String expectedUsername;
    private String expectedUserRole;
    private String expectedStatus;

    private AdminPage getAdminPage() {
        if (adminPage == null) {
            adminPage = new AdminPage(DriverFactory.getDriver());
        }
        return adminPage;
    }

    @When("user clicks on admin button")
    public void clickOnAdminButton() {
        getAdminPage().clickOnAdminbutton();
    }

    @Then("user should navigate to admin page")
    public void verifyAdminUrl() {
        Assert.assertTrue(getAdminPage().verifyAdminUrl(), "Expected Admin URL did not match");
    }

    @When("the user searches with username {string}, role {string}, and status {string}")
    public void searchSystemUsers(String username, String userRole, String status) {
        this.expectedUsername = username;
        this.expectedUserRole = userRole;
        this.expectedStatus = status;

        getAdminPage().enterAdminUserName(username);
        getAdminPage().selectUserRole(userRole);
        getAdminPage().selectStatus(status);
        getAdminPage().clickOnSearchButton();
    }

    @Then("the results table should match the searched filter criteria")
    public void verifySystemUserResults() {
        List<Map<String, String>> allRows = getAdminPage().getSearchResultRows();
        Assert.assertFalse(allRows.isEmpty(), "Expected at least one matching record in System Users table");

        SoftAssert softAssert = new SoftAssert();
        for (Map<String, String> row : allRows) {
            if (expectedUsername != null && !expectedUsername.isEmpty()) {
                softAssert.assertEquals(row.get("Username"), expectedUsername, "Username mismatch");
            }
            if (expectedUserRole != null && !expectedUserRole.isEmpty()) {
                softAssert.assertEquals(row.get("User Role"), expectedUserRole, "User Role mismatch");
            }
            if (expectedStatus != null && !expectedStatus.isEmpty()) {
                softAssert.assertEquals(row.get("Status"), expectedStatus, "Status mismatch");
            }
            softAssert.assertFalse(row.getOrDefault("Employee Name", "").isEmpty(), "Employee Name should not be blank");
        }
        softAssert.assertAll();
    }
}