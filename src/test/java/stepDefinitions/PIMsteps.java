package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PIMPage;
import utilities.DriverFactory;

public class PIMsteps {
	
	private PIMPage pimPage;
	
	@When("user navigates to pim field")
	public void navigateToPimButton() {
		   pimPage = new PIMPage(DriverFactory.getDriver());
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
	        pimPage.enterEmployeeFirstname(LastName);
	    }
	  
	 @When("user click on save button")
	 public void  clickOnsaveButton() {
		 pimPage.clickOnsaveButton();
	 }
	
	 @Then("employee name should be added")
	 public void  employeegetadded() {
		 
	 }
	 

}
