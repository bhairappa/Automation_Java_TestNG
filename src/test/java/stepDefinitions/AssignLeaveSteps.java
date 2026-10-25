package stepDefinitions;

import org.testng.Assert;

import base.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AssignLeavePage;
import utilities.DriverFactory;

public class AssignLeaveSteps  {
	
	private AssignLeavePage assignLeavePage;
	
	public AssignLeaveSteps() {
	    assignLeavePage = new AssignLeavePage(DriverFactory.getDriver());
	}
	
	  @When ("user navigates to Assign Leave page")
	    public void assignLeavePage() {
		  assignLeavePage.clickAssignLeave();
	    }
	    @When("user enters employee name {string}")
	    public void enterEmployeename(String name) throws InterruptedException {
	    	assignLeavePage.enterEmployeename(name);
	    }
	    
	    @Then("employee suggestions should be displayed")
	    public void EmployeenameSuggestions() {
	        Assert.assertTrue(
	        		assignLeavePage.isEmployeeDropdownDisplayed(),
	                "Employee suggestions are not displayed"
	            );
	    }
	    
	    @When("user selects name {string}")
	    public void selectEmployeeName(String expectedName) {  //
	    	assignLeavePage.selectEmployeeName(expectedName);
	    } 
	 //
	    @Then("selected employee name should be {string}")
	    public void getSelectedEmployeeName(String expectedName) {
	    	Assert.assertEquals(
	    			assignLeavePage.getSelectedEmployeeName(),
	    	        expectedName,
	    	        "Selected employee name does not match"
	    	    );
	    }
	    
	    @When("user click on assign button")
	    public void clickAssignButton() {
	    	assignLeavePage.clickAssignButton();
	    }
	    
	    @Then("user should be able to see invalid {string} error msg")
	    public void verifyAssignErrorName(String expectedError) {
	        Assert.assertEquals(assignLeavePage.verifyAssignErrorName(),
	        		expectedError,
	        		"Selected employee name error does not match");
	    }
	    
	    @Then("user should be able to see Required field error message")
	    public void verifyrequiredFieldsErrormsg() {
	    	 Assert.assertTrue(assignLeavePage.isrequiredErrorsisDisplayed(),
		        		"One or more required field error messages are not displayed");
	    	
	    }
	    
}
