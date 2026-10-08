package pages;

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

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

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
        loginButton.click();
    }

    public void login(String usernameValue, String passwordValue) {
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
    }
}