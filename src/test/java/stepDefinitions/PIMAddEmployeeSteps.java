package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PIMAddEmployeePage;
import utilities.DriverFactory;

public class PIMAddEmployeeSteps {

    private PIMAddEmployeePage pimPage;

    private PIMAddEmployeePage getPimPage() {
        if (pimPage == null) {
            pimPage = new PIMAddEmployeePage(DriverFactory.getDriver());
        }
        return pimPage;
    }

    @When("user navigates to pim field")
    public void navigateToPim() {
        getPimPage().navigateToPimButton();
    }

    @When("user clicks on add employee")
    public void clickAddEmployee() {
        getPimPage().addEmployeeButton();
    }

    @When("user enters employee First Name {string}")
    public void enterFirstName(String firstName) {
        getPimPage().enterEmployeeFirstname(firstName);
    }

    @When("user enters employee Second Name {string}")
    public void enterMiddleName(String middleName) {
        getPimPage().enterEmployeemiddleName(middleName);
    }

    @When("user enters employee Last Name {string}")
    public void enterLastName(String lastName) {
        getPimPage().enterEmployeelastName(lastName);
    }

    @When("user enters employee_id {string}")
    public void enterEmployeeId(String employeeId) {
        getPimPage().enterEmployeePimEmployeeId(employeeId);
    }

    @When("user click on save button")
    public void clickSaveButton() {
        getPimPage().clickOnsaveButton();
    }

    @Then("add employee success msg displayed")
    public void verifySuccessMsgDisplayed() {
        Assert.assertTrue(getPimPage().verifyAddemployeesuccessmsg(), "Add employee success toast was not displayed");
    }

    @When("user Navigates to employeeList option")
    public void navigateToEmployeeList() {
        getPimPage().clickOnemployeeList();
    }

    @When("user searches employee {string}")
    public void searchEmployeeByName(String firstName) {
        getPimPage().searchEmployee(firstName);
        getPimPage().clickSearchButton();
    }

    @When("user scroll the page")
    public void scrollPageToResults() {
        getPimPage().scrollDownToResults();
    }

    @Then("verify employee {string} and employee_id {string} created successfully")
    public void verifyEmployeeCreated(String firstName, String employeeId) {
        Assert.assertTrue(
            getPimPage().isEmployeePresent(firstName, employeeId),
            "Employee " + firstName + " with ID " + employeeId + " was not found in Employee List table"
        );
    }

    @Then("verify employeeId exist error msg")
    public void verifyDuplicateEmployeeIdError() {
        Assert.assertTrue(getPimPage().verifyAddemployeeIdErrormsg(), "Duplicate Employee Id error message not displayed");
    }

    @Then("required error messages should be displayed")
    public void verifyRequiredErrorsDisplayed() {
        Assert.assertTrue(getPimPage().areRequiredErrorsDisplayed(), "Required field errors for First/Last name not displayed");
    }
    
}