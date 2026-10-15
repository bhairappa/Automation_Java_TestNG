package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

//    @FindBy(xpath = "//button[@type='submit']")
//    private WebElement loginButton;
    
    private By loginButton =  By.xpath("//button[@type='submit']");
  
    
//    @FindBy(xpath = "//p[text()='Invalid credentials']")
//    private WebElement errormsg;
    
    private By emptypassworderrorMessage =
            By.xpath("//input[@name='password']/following::span[text()='Required']");
    
    private By emptyusererrorMessage =
            By.xpath("//input[@name='username']/following::span[text()='Required'][1]");
    
    private By errorMessage =  By.xpath("//p[text()='Invalid credentials']");

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }
    
    public boolean isEmptyUserErrorMessageDisplayed() {
        return isDisplayed(emptyusererrorMessage);
    }
    
    public boolean isEmptypasswordErrorMessageDisplayed() {
        return isDisplayed(emptypassworderrorMessage);
    }
 
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String usernameValue) {
    	wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
    	wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(passwordValue);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String usernameValue, String passwordValue) {
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
    }

 
    @FindBy(xpath =  "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    private WebElement logoutDropDown;
    
    @FindBy(xpath =  "//a[text()='Logout']")
    private WebElement logoutOption;
    
    @FindBy(xpath = "//h5[text()='Login']")
    private WebElement loginHeader;
    
    public void clickLogoutDropdown() {
        click(logoutDropDown);
    }

    public void clickLogoutOption() {
        click(logoutOption);
    }

    public boolean isLoginHeaderDisplayed() {
        return isDisplayed(loginHeader);
    }
    
//	public boolean isErrorMessageDisplayed() {
//		// TODO Auto-generated method stub
//		 try {
//		        WebDriverWait wait =
//		            new WebDriverWait(driver, Duration.ofSeconds(5));
//
//		        return wait.until(
//		            ExpectedConditions.visibilityOf(errormsg)
//		        ).isDisplayed();
//
//		    } catch (TimeoutException e) {
//		        return false;
//		    }
//	}
}