package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class AdminPage extends BasePage{

	public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath = "//li[contains(@class,'oxd-main-menu')]/a[contains(@class,'oxd-main-menu-item')]")
private WebElement adminbutton; 
 
public void clickOnAdminbutton() {
    	isDisplayed(adminbutton);
        click(adminbutton);	
        System.out.println("clicked on admin button");
     }

     public boolean verifyAdminUrl() {  
    	 String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
    	return waitForUrl(expectedUrl);  	 
     }
     
 @FindBy(xpath = "//label[text()='Username']/ancestor::div[contains(@class,'oxd-input')]//input")
 private WebElement UsernameField;
     
     public void enterAdminUserName(String adminuserName) {
         click(UsernameField);
         UsernameField.clear();
         enterTextElement(UsernameField,adminuserName);
      }
     
     @FindBy(xpath = "//label[normalize-space()='User Role']/ancestor::div[contains(@class, 'oxd-input-group')]//div[contains(@class, 'oxd-select-text--after')]")
     private WebElement selectUserroleDropDown;

     public void selectUserroleAdminDropDown() {
         click(selectUserroleDropDown);
     }
     
@FindBy(xpath = "//div[contains(@class,'oxd-select-option')]/span[text()='Admin']")
private WebElement selectAdminUserrole;

       public void selectUserroleAdmin() {
          click(selectAdminUserrole);
     }
     
@FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text--after')]")
private WebElement selectStatusDropDown;

public void clickSelectStatusAdminDropDown() {
    click(selectStatusDropDown);
}
 
@FindBy(xpath = "//div[contains(@class, 'oxd-select-dropdown')]//div[contains(@class, 'oxd-select-option')][.//span[text()='Enabled']]")
private WebElement selectEnabledStatus;

public void clickEnabledStatusAdmin() {
    click(selectEnabledStatus);
}

@FindBy(xpath = "//button[@type='submit' and normalize-space()='Search']")
private WebElement clickOnSearchButton;

public void clickOnSearchButton() {
    click(clickOnSearchButton);
}



}
