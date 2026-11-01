package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class PIMAddEmployeePage extends BasePage {

	public PIMAddEmployeePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@class='oxd-main-menu-item' and .//span[normalize-space()='PIM']]")
	 private WebElement Pimbutton ;
	
	@FindBy(xpath ="//a[text()='Add Employee']")
	private WebElement AddEmployeebutton;
	
	@FindBy(xpath ="//input[@name='firstName']")
	private WebElement EmployeeFirstName;
	
	@FindBy(xpath ="//input[@name='middleName']")
	private WebElement EmployeeMiddleName;
	
	@FindBy(xpath ="//input[@name='lastName']")
	private WebElement EmployeeLastName;
	
//	@FindBy(xpath ="//div[contains(@class,'oxd-input-group') and contains(@class,"
//			+ "'oxd-input-field-bottom-space')]//input[@class='oxd-input oxd-input--active']")
	@FindBy(xpath ="//div[contains(@class,'oxd-input-group')][.//label[normalize-space()='Employee Id']]//input")
	private WebElement PimEmployeeId;
	
	@FindBy(xpath ="//button[contains(@class,'oxd-button oxd-button--medium')][text()=' Save ']")
	private WebElement saveButton;
	
	@FindBy(xpath ="//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
	private WebElement addEmployeeSuccessmsg;
	
	
//	@FindBy(xpath ="//h6[@class='oxd-text oxd-text--h6 --strong']")
//	private WebElement verifyEmployeeName;
	
	@FindBy(xpath ="//a[text()='Employee List']")
	private WebElement employeeList;
	
	@FindBy(xpath =
			"//span[contains(@class,'oxd-input-field-error-message') and (normalize-space()='Employee Id already exists')]")
	private WebElement employeeIdExistErrormsg;
	
	
	public void navigateToPimButton() {
		click(Pimbutton);
	}
	
	public void addEmployeeButton() {
		click(AddEmployeebutton);
	}
	
	public void enterEmployeeFirstname(String FirstName) {
		enterTextElement(EmployeeFirstName,FirstName);
	}
	
	public void enterEmployeemiddleName(String middleName) {
		enterTextElement(EmployeeMiddleName,middleName);
	}
	
	public void enterEmployeelastName(String lastName) {
		
		enterTextElement(EmployeeLastName,lastName);
	}
	
	public void enterEmployeePimEmployeeId(String EmployeeId) {
		isDisplayed(PimEmployeeId);
		PimEmployeeId.click();
	    PimEmployeeId.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    PimEmployeeId.sendKeys(Keys.DELETE);
	    PimEmployeeId.sendKeys(EmployeeId);
//		PimEmployeeId.click();
//	    PimEmployeeId.sendKeys(Keys.CONTROL, "a");
//	    PimEmployeeId.sendKeys(Keys.BACK_SPACE);
		
//		PimEmployeeId.clear();
//	    enterTextElement(PimEmployeeId,EmployeeId);
//	  
	}

	public void clickOnsaveButton() {
		click(saveButton);
	}
	
	public boolean verifyAddemployeeIdErrormsg() {
		return isDisplayed(employeeIdExistErrormsg);
	}
	
	public boolean verifyAddemployeesuccessmsg() {
		return isDisplayed(addEmployeeSuccessmsg);
	}
	
	public void clickOnemployeeList() {
		click(employeeList);
	}
	
//	public String toVerifyEmployeeName() {
//		isDisplayed(verifyEmployeeName);
//		return verifyEmployeeName.getText();		
//	}
	
	
	 @FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
	 private WebElement employeeNameSearch;

	 @FindBy(xpath = "//button[@type='submit']")
	 private WebElement searchButton;
	 
	 @FindBy(xpath = "//span[contains(@class,'oxd-input-field-error-message') and normalize-space()='Required']")
	 private List<WebElement> requiredErrorMessages;

	 public void searchEmployee(String firstName) {  //,String middlename
		 isDisplayed(employeeNameSearch);
	     employeeNameSearch.clear();
	     employeeNameSearch.sendKeys(firstName); //+" "+middlename
	 }
	 
	 public void clickSearchButton() {
		    click(searchButton);
		}
	 
	 public void scrollToBottom() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down by 500 pixels
		js.executeScript("window.scrollBy(0, 500);");

		// Or scroll all the way to the bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	 }
	 public boolean isEmployeePresent(String firstName, String employeeId) throws Exception {
		 By employeeRow =
				 By.xpath("//div[contains(@class,'oxd-table-row')][contains(.,'"+firstName+"')][contains(.,'"+employeeId+"')]");
			    return isDisplayed(employeeRow);
			    }
	 
	 public boolean areRequiredErrorsDisplayed() {
                return areDisplayed(requiredErrorMessages,2);
			}
		 }
