package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PIMAddEmployeePage;
import utilities.DriverFactory;

public class PIMAddEmployeesteps {
	
	private PIMAddEmployeePage pimPage;
	
	private PIMAddEmployeePage getPimAddEmployeePage() {
		if(pimPage==null) {
			pimPage= new PIMAddEmployeePage(DriverFactory.getDriver());
		}
		return pimPage;
	}
	
	@When("user navigates to pim field")
	public void navigateToPimButton() {
		   pimPage = new PIMAddEmployeePage(DriverFactory.getDriver());
		   getPimAddEmployeePage().navigateToPimButton();
	}

	@When("user clicks on add employee")
	public void addEmployeeButton() {
		getPimAddEmployeePage().addEmployeeButton();
	}
	 
	 @When("user enters employee First Name {string}")
	    public void enterFirstName(String FirstName) {
		 getPimAddEmployeePage().enterEmployeeFirstname(FirstName);
	    }
	 
	 @When("user enters employee Second Name {string}")
	 public void entermiddleName(String MiddleName) {
		 getPimAddEmployeePage().enterEmployeemiddleName(MiddleName);
	    }
	 
	 @When("user enters employee Last Name {string}")
	 public void enterLastName(String LastName) {
		 getPimAddEmployeePage().enterEmployeelastName(LastName);
	    }
	 
	 @When("user enters employee_id {string}")
	 public void user_enters_employee_id(String EmployeeId) {
		 getPimAddEmployeePage().enterEmployeePimEmployeeId(EmployeeId);
	    }
	  
	 @When("user click on save button")
	 public void  clickOnsaveButton() {
		 getPimAddEmployeePage().clickOnsaveButton();
	 }
	 
	 @Then("verify employeeId exist error msg")
	 public void  verifyAddemployeeIdErrormsg() {
		 getPimAddEmployeePage().verifyAddemployeeIdErrormsg();
	 }
	 
	 @Then("add employee success msg displayed")
	 public void  verifyAddemployeesuccessmsg() {
		 Assert.assertTrue(
				 getPimAddEmployeePage().verifyAddemployeesuccessmsg(),
			        "Employee creation success message is not displayed"
			    );
	 }
	 
	 
	 @When("user Navigates to employeeList option")
	 public void  clickOnemployeeList() {
		 getPimAddEmployeePage().clickOnemployeeList();;
	 }
	
	 @When("user searches employee {string}")  // and middle name {string}
	 public void searchEmployee(String firstName) throws Exception {  //,String middlename
		 
		 getPimAddEmployeePage().searchEmployee(firstName);  //middlename
	     // Select the matching autocomplete suggestion here if shown.
//	     Thread.sleep(2000);
		 getPimAddEmployeePage().clickSearchButton();
	 }

	 @When("user scroll the page")
	 public void scrollToBottom() {
		 getPimAddEmployeePage().scrollToBottom();
	 }
	 
	 @Then("verify employee {string} and employee_id {string} created successfully")
	 public void verifyEmployee(String firstMiddleName, String employeeId) throws Exception {
		 Assert.assertTrue(
				 getPimAddEmployeePage().isEmployeePresent(firstMiddleName, employeeId),
			        "Employee " + firstMiddleName + " " + employeeId + " was not found"
			    );
	 }
	 
	 @Then("required error messages should be displayed")
	 public void areRequiredErrorsDisplayed() {
		 Assert.assertTrue(
				 getPimAddEmployeePage().areRequiredErrorsDisplayed(),
			        "Required error messages are not displayed"
			    );
	 }
}
