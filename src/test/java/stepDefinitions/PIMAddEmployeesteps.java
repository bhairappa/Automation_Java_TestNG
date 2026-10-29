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
	 
	 @When("user Navigates to employeeList option")
	 public void  clickOnemployeeList() {
		 pimPage.clickOnemployeeList();;
	 }
	
	 @When("user searches employee {string}")  // and middle name {string}
	 public void searchEmployee(String firstName) {  //,String middlename
		 
	     pimPage.searchEmployee(firstName);  //middlename
	     // Select the matching autocomplete suggestion here if shown.
	     pimPage.clickSearchButton();
	 }

	 @Then("verify employee {string} and last name {string} created successfully")
	 public void verifyEmployee(String firstMiddleName, String lastName) throws Exception {
		 Assert.assertTrue(
			        pimPage.isEmployeePresent(firstMiddleName, lastName),
			        "Employee " + firstMiddleName + " " + lastName + " was not found"
			    );
	 }
	 
}
