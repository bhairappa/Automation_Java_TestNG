package pages;

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
	
	@FindBy(xpath ="//div[contains(@class,'oxd-input-group') and contains(@class,"
			+ "'oxd-input-field-bottom-space')]//input[@class='oxd-input oxd-input--active']")
	private WebElement PimEmployeeId;
	
	@FindBy(xpath ="//button[text()=' Save ']")
	private WebElement saveButton;
	
	@FindBy(xpath ="//h6[@class='oxd-text oxd-text--h6 --strong']")
	private WebElement verifyEmployeeName;
	
	@FindBy(xpath ="//a[text()='Employee List']")
	private WebElement employeeList;
	
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
		enterTextElement(PimEmployeeId,EmployeeId);
	}
	
	public void navigateToPimButton() {
		click(Pimbutton);
	}
	
	public void addEmployeeButton() {
		click(AddEmployeebutton);
	}
	
	public void clickOnsaveButton() {
		click(saveButton);
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

	 public void searchEmployee(String firstName) {  //,String middlename
		 isDisplayed(employeeNameSearch);
	     employeeNameSearch.clear();
	     employeeNameSearch.sendKeys(firstName); //+" "+middlename
	 }
	 
	 public void clickSearchButton() {
		    click(searchButton);
		}
	 
	 public boolean isEmployeePresent(String firstMiddleName, String lastName) throws Exception {
		 Thread.sleep(2000);

		 By employeeRow = By.xpath(
			        "//div[@class='oxd-table-body']//div[@role='row']" +
			        "[.//div[@role='cell' and normalize-space()='" + firstMiddleName + "']" +
			        " and .//div[@role='cell' and normalize-space()='" + lastName + "']]"
			    );

			    return isDisplayed(employeeRow);	}
}
