package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class PIMAddEmployeePage extends BasePage {

    public PIMAddEmployeePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and .//span[normalize-space()='PIM']]")
    private WebElement pimButton;

    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement addEmployeeButton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement employeeFirstName;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement employeeMiddleName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement employeeLastName;

    @FindBy(xpath = "//div[contains(@class,'oxd-input-group')][.//label[normalize-space()='Employee Id']]//input")
    private WebElement pimEmployeeId;

    @FindBy(xpath = "//button[contains(@class,'oxd-button--medium')][normalize-space()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast--success')]")
    private WebElement addEmployeeSuccessMsg;

    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement employeeListButton;

    @FindBy(xpath = "//span[contains(@class,'oxd-input-field-error-message') and normalize-space()='Employee Id already exists']")
    private WebElement employeeIdExistErrorMsg;

    @FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
    private WebElement employeeNameSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(@class,'oxd-input-field-error-message') and normalize-space()='Required']")
    private List<WebElement> requiredErrorMessages;

    // Table locators for PIM Employee List
    private final By tableHeaders = By.cssSelector(".oxd-table-header .oxd-table-header-cell");
    private final By tableRows = By.cssSelector(".oxd-table-body .oxd-table-row");
    private final By tableCells = By.cssSelector(".oxd-table-cell");

    public void navigateToPimButton() {
        click(pimButton);
    }

    public void addEmployeeButton() {
        click(addEmployeeButton);
    }

    public void enterEmployeeFirstname(String firstName) {
        enterText(employeeFirstName, firstName);
    }

    public void enterEmployeemiddleName(String middleName) {
        enterText(employeeMiddleName, middleName);
    }

    public void enterEmployeelastName(String lastName) {
        enterText(employeeLastName, lastName);
    }

    public void enterEmployeePimEmployeeId(String employeeId) {
        enterText(pimEmployeeId, employeeId);
    }

    public boolean verifyAddemployeeIdErrormsg() {
        return isDisplayed(employeeIdExistErrorMsg);
    }

    public boolean verifyAddemployeesuccessmsg() {
        return isDisplayed(addEmployeeSuccessMsg);
    }

    public void clickOnemployeeList() {
        click(employeeListButton);
    }

    public void searchEmployee(String firstName) {
        enterText(employeeNameSearch, firstName);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public void scrollDownToResults() {
        scrollToBottom();
    }

    public boolean isEmployeePresent(String firstName, String employeeId) {
        List<Map<String, String>> rows = getTableData(tableHeaders, tableRows, tableCells);
        return rows.stream().anyMatch(row ->
            row.getOrDefault("Id", "").equals(employeeId)
            && row.getOrDefault("First (& Middle) Name", "").contains(firstName)
        );
    }

//    public boolean areRequiredErrorsDisplayed() {
//        return areDisplayed(requiredErrorMessages, 2);
//    }
 // Add to PIMAddEmployeePage.java
    private final By formLoader = By.cssSelector(".oxd-form-loader");
    private final By requiredErrorLocator = By.xpath(
        "//span[contains(@class,'oxd-input-field-error-message') and normalize-space()='Required']"
    );

    public void clickOnsaveButton() {
        waitForElementToDisappear(formLoader);
        click(saveButton);
    }
//-------- can also be used fot  areRequiredErrorsDisplayed method -----------
//    private final By firstNameRequiredError = By.xpath(
//    	    "//input[@name='firstName']/ancestor::div[contains(@class,'oxd-input-group')]//span[normalize-space()='Required']"
//    	);
//    	private final By lastNameRequiredError = By.xpath(
//    	    "//input[@name='lastName']/ancestor::div[contains(@class,'oxd-input-group')]//span[normalize-space()='Required']"
//    	);
//
//    	public boolean areRequiredErrorsDisplayed() {
//    	    return isDisplayed(firstNameRequiredError) && isDisplayed(lastNameRequiredError);
//    	}
    
    public boolean areRequiredErrorsDisplayed() {
        List<WebElement> errors = getVisibleElements(requiredErrorLocator);
        return errors.size() == 2;
    }
}