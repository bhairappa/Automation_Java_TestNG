package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AssignLeavePage;
import utilities.DriverFactory;

public class AssignLeaveSteps {

    private AssignLeavePage assignLeavePage;

    private AssignLeavePage getAssignLeavePage() {
        if (assignLeavePage == null) {
            assignLeavePage = new AssignLeavePage(DriverFactory.getDriver());
        }
        return assignLeavePage;
    }

    @When("user navigates to Assign Leave page")
    public void navigateToAssignLeavePage() {
        getAssignLeavePage().clickAssignLeave();
    }

    @When("user enters employee name {string}")
    public void enterEmployeeName(String partialOrInvalidName) {
        getAssignLeavePage().enterEmployeename(partialOrInvalidName);
    }

    @Then("employee suggestions should be displayed")
    public void verifyEmployeeSuggestionsDisplayed() {
        Assert.assertTrue(getAssignLeavePage().isEmployeeDropdownDisplayed(), "Autocomplete suggestions did not appear");
    }

    @When("user selects name {string}")
    public void selectEmployeeFromSuggestions(String expectedName) {
        getAssignLeavePage().selectEmployeeName(expectedName);
    }

    @Then("selected employee name should be {string}")
    public void verifySelectedEmployeeName(String expectedName) {
        Assert.assertEquals(getAssignLeavePage().getSelectedEmployeeName(), expectedName, "Selected employee name mismatch");
    }

    @When("user click on assign button")
    public void clickAssignButton() {
        getAssignLeavePage().clickAssignButton();
    }

    @Then("user should be able to see invalid {string} error msg")
    public void verifyInvalidNameError(String expectedError) {
        Assert.assertEquals(getAssignLeavePage().verifyAssignErrorName(), expectedError, "Invalid name error text mismatch");
    }

    @Then("user should be able to see Required field error message")
    public void verifyRequiredFieldErrors() {
        Assert.assertTrue(getAssignLeavePage().isrequiredErrorsisDisplayed(), "Required field error messages are missing");
    }
}