package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    private WebElement logoutDropDown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutOption;

    @FindBy(xpath = "//h5[text()='Login']")
    private WebElement loginHeader;

    private final By emptyPasswordErrorMessage =
            By.xpath("//input[@name='password']/following::span[text()='Required']");

    private final By emptyUserErrorMessage =
            By.xpath("//input[@name='username']/following::span[text()='Required'][1]");

    private final By errorMessage = By.xpath("//p[text()='Invalid credentials']");

    public void enterUsername(String usernameValue) {
        enterText(username, usernameValue);
    }

    public void enterPassword(String passwordValue) {
        enterText(password, passwordValue);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String usernameValue, String passwordValue) {
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLogin();
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public boolean isEmptyUserErrorMessageDisplayed() {
        return isDisplayed(emptyUserErrorMessage);
    }

    public boolean isEmptypasswordErrorMessageDisplayed() {
        return isDisplayed(emptyPasswordErrorMessage);
    }

    public void clickLogoutDropdown() {
        click(logoutDropDown);
    }

    public void clickLogoutOption() {
        click(logoutOption);
    }

    public boolean isLoginHeaderDisplayed() {
        return isDisplayed(loginHeader);
    }
}