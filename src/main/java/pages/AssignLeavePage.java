package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class AssignLeavePage extends BasePage {

    public AssignLeavePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final By employeeSuggestions = By.xpath("//div[@role='listbox']//div[@role='option']");

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//button[@title='Assign Leave']")
    private WebElement assignLeaveButton;

    @FindBy(xpath = "//button[normalize-space()='Assign']")
    private WebElement assignButton;

    @FindBy(xpath = "//span[text()='Invalid']")
    private WebElement invalidNameError;

    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
    private WebElement requiredEmployeeNameError;

    @FindBy(xpath = "//label[text()='Leave Type']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
    private WebElement requiredLeaveTypeError;

    @FindBy(xpath = "//label[text()='From Date']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
    private WebElement requiredFromDateError;

    @FindBy(xpath = "//label[text()='To Date']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
    private WebElement requiredToDateError;
    
    @FindBy(xpath = "//span[text()='Ravi M B']")
    private WebElement selectedemployeename;

    public void clickAssignLeave() {
        click(assignLeaveButton);
    }

    public void enterEmployeename(String name) {
        enterText(employeeNameInput, name);
    }

    public boolean isEmployeeDropdownDisplayed() {
        return isDisplayed(employeeSuggestions);
    }

    public void selectEmployeeName(String expectedName) {
        selectOxdAutocompleteOption(employeeNameInput, employeeSuggestions, expectedName);
    }

    public String getSelectedEmployeeName() {
        return getAttribute(employeeNameInput, "value").trim();
    }
    
    public void clickAssignButton() {
        click(assignButton);
    }

    public String verifyAssignErrorName() {
        return getText(invalidNameError);
    }
  
    public boolean isrequiredErrorsisDisplayed() {
        List<WebElement> errors = Arrays.asList(
            requiredEmployeeNameError,
            requiredLeaveTypeError,
            requiredFromDateError,
            requiredToDateError
        );
        return areDisplayed(errors, errors.size());
    }
}