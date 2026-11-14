package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import utilities.DriverFactory;

public class AdminStpes {

	private AdminPage adminpage;
	
	public AdminPage getAdminPage() {
		if(adminpage==null) {
			adminpage = new AdminPage(DriverFactory.getDriver());
		}
		return adminpage;
	}
	
	@When("user clicks on admin button")
	public void clickOnAdminbutton() {
		getAdminPage().clickOnAdminbutton();
	}
	
	@Then("user should navigate to admin page")
	public void verifyAdminUrl() {
//		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
		Assert.assertTrue(getAdminPage().verifyAdminUrl(),"expected url doesn't matches");		
	}
	
	@When("user enters the user name {string}")
	public void addusername(String username) {
		getAdminPage().enterAdminUserName(username);
	}
	@When("user click on dropdown and selects admin")
	public void selectUserroleAdmin() {
		getAdminPage().selectUserroleAdminDropDown();
		getAdminPage().selectUserroleAdmin();
	}
		
	@When("user click on status drop down and selects enabled")
	public void clickEnabledStatusAdmin()  {
		getAdminPage().clickSelectStatusAdminDropDown();
		getAdminPage().clickEnabledStatusAdmin();
	}
	
	@When("user click on search button")
	public void clickOnSearchButton()  {
		getAdminPage().clickOnSearchButton();	
	}
	
	@Then("user should be able to see admin user name")
	public void verifyusername() {
		
	}
	
}
