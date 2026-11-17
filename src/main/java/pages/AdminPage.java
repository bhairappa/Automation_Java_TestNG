package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // --- Locators ---

    @FindBy(xpath = "//li[contains(@class,'oxd-main-menu')]/a[contains(@class,'oxd-main-menu-item')]")
    private WebElement adminButton;

    @FindBy(xpath = "//label[text()='Username']/ancestor::div[contains(@class,'oxd-input')]//input")
    private WebElement usernameField;

    @FindBy(xpath = "//label[normalize-space()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text--after')]")
    private WebElement userRoleDropDown;

    @FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text--after')]")
    private WebElement statusDropDown;

    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Search']")
    private WebElement searchButton;

    // Table locators specific to Admin System Users table
    private final By tableHeaders = By.cssSelector(".oxd-table-header .oxd-table-header-cell");
    private final By tableRows = By.cssSelector(".oxd-table-body .oxd-table-row");
    private final By tableCells = By.cssSelector(".oxd-table-cell");

    // --- Page Actions ---

    public void clickOnAdminbutton() {
        isDisplayed(adminButton);
        click(adminButton);
    }

    public boolean verifyAdminUrl() {
        return waitForUrlContains("/admin/viewSystemUsers");
    }

    public void enterAdminUserName(String adminUserName) {
        click(usernameField);
        enterText(usernameField, adminUserName);
    }

    public void selectUserRole(String role) {
        selectOxdDropdownByText(userRoleDropDown, role);
    }

    public void selectStatus(String status) {
        selectOxdDropdownByText(statusDropDown, status);
    }

    public void clickOnSearchButton() {
        click(searchButton);
    }

    public List<Map<String, String>> getSearchResultRows() {
        return getTableData(tableHeaders, tableRows, tableCells);
    }
}