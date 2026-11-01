package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PIMAddEmployeePage;
import utilities.DriverFactory;

public class PIMAddEmployeesteps {
	
	private PIMAddEmployeePage pimPage;
	
	@When("user navigates to pim field")
	public void navigateToPimButton() {
		   pimPage = new PIMAddEmployeePage(DriverFactory.getDriver());
		pimPage.navigateToPimButton();
	}

	@When("user clicks on add employee")
	public void addEmployeeButton() {
		pimPage.addEmployeeButton();
	}
	 
	 @When("user enters employee First Name {string}")
	    public void enterFirstName(String FirstName) {
	        pimPage.enterEmployeeFirstname(FirstName);
	    }
	 
	 @When("user enters employee Second Name {string}")
	 public void entermiddleName(String MiddleName) {
	        pimPage.enterEmployeemiddleName(MiddleName);
	    }
	 
	 @When("user enters employee Last Name {string}")
	 public void enterLastName(String LastName) {
	        pimPage.enterEmployeelastName(LastName);
	    }
	 
	 @When("user enters employee_id {string}")
	 public void user_enters_employee_id(String EmployeeId) {
	        pimPage.enterEmployeePimEmployeeId(EmployeeId);
	    }
	  
	 @When("user click on save button")
	 public void  clickOnsaveButton() {
		 pimPage.clickOnsaveButton();
	 }
	 
	 @Then("verify employeeId exist error msg")
	 public void  verifyAddemployeeIdErrormsg() {
		 pimPage.verifyAddemployeeIdErrormsg();
	 }
	 
	 @Then("add employee success msg displayed")
	 public void  verifyAddemployeesuccessmsg() {
		 Assert.assertTrue(
			        pimPage.verifyAddemployeesuccessmsg(),
			        "Employee creation success message is not displayed"
			    );
	 }
	 
	 
	 @When("user Navigates to employeeList option")
	 public void  clickOnemployeeList() {
		 pimPage.clickOnemployeeList();;
	 }
	
	 @When("user searches employee {string}")  // and middle name {string}
	 public void searchEmployee(String firstName) throws Exception {  //,String middlename
		 
	     pimPage.searchEmployee(firstName);  //middlename
	     // Select the matching autocomplete suggestion here if shown.
//	     Thread.sleep(2000);
	     pimPage.clickSearchButton();
	 }

	 @When("user scroll the page")
	 public void scrollToBottom() {
		 pimPage.scrollToBottom();
	 }
	 
	 @Then("verify employee {string} and employee_id {string} created successfully")
	 public void verifyEmployee(String firstMiddleName, String employeeId) throws Exception {
		 Assert.assertTrue(
			        pimPage.isEmployeePresent(firstMiddleName, employeeId),
			        "Employee " + firstMiddleName + " " + employeeId + " was not found"
			    );
	 }
	 
	 @Then("required error messages should be displayed")
	 public void areRequiredErrorsDisplayed() {
		 Assert.assertTrue(
			        pimPage.areRequiredErrorsDisplayed(),
			        "Required error messages are not displayed"
			    );
	 }
}
