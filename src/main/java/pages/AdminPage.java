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
	
@FindBy(xpath = "//li[contains(@class,'oxd-main-menu')]/a[@class='oxd-main-menu-item active']")
private WebElement adminbutton; 

     public void clickOnAdminbutton() {
        click(adminbutton);	
     }

     public String verifyAdminUrl() {  	 
		return driver.getCurrentUrl();    	 
     }
     
 @FindBy(xpath = "//label[text()='Username']/ancestor::div[contains(@class,'oxd-input')]//input")
 private WebElement UsernameField;
     
     public void enterAdminUserName(String adminuserName) {
         click(UsernameField);
         UsernameField.clear();
         enterTextElement(UsernameField,adminuserName);
      }
     
@FindBy(xpath = "//div[contains(@class,'oxd-select-option')]/span[text()='Admin']")
private WebElement selectUserrole;

       public void selectUserroleAdmin() {
          click(selectUserrole);
     }
     
@FindBy(xpath = "//label[normalize-space()='User Role']/ancestor::div[contains(@class, 'oxd-input-group')]//div[contains(@class, 'oxd-select-text--after')]")
private WebElement selectUserroleDropDown;

public void clickSelectUserroleAdmin() {
    click(selectUserroleDropDown);
}

@FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text--after')]")
private WebElement selectStatusDropDown;

public void clickSelectStatusAdmin() {
    click(selectStatusDropDown);
}
 
@FindBy(xpath = "//div[contains(@class, 'oxd-select-dropdown')]//div[contains(@class, 'oxd-select-option')][.//span[text()='Enabled']]")
private WebElement selectStatus;

public void clickEnabledStatusAdmin() {
    click(selectStatusDropDown);
}

}
