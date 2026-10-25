package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class PIMPage extends BasePage {

	public PIMPage(WebDriver driver) {
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
	
}
