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
     
}
