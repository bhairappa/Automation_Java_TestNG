package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import utilities.DriverFactory;

public class AdminStpes {

	private AdminPage adminpage;
	
	private AdminPage getAdminPage() {
		if(adminpage==null) {
			adminpage = new AdminPage(DriverFactory.getDriver());
		}
		return adminpage;
	}
	
	@When("user clicks on admin button")
	private void clickOnAdminbutton() {
		getAdminPage().clickOnAdminbutton();		
	}
	
	@Then("user should navigate to admin page")
	private void verifyAdminUrl() {
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
		Assert.assertEquals(getAdminPage().verifyAdminUrl(),expectedUrl,"expected url doesn't matches");		
	}
	
	
	
}
