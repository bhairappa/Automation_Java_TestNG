package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class AssignLeavePage extends BasePage{

	public AssignLeavePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	private By employeeSuggestions =
	        By.xpath("//div[@role='listbox']//div[@role='option']");
	

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement VarifyEmployeeName;
	
	@FindBy(xpath="//button[@title='Assign Leave']")
	private WebElement  assignLeaveButton;
	
//	@FindBy(xpath="//div[@class='oxd-autocomplete-dropdown --positon-bottom']")
	
//	private By employeeSuggestions =  By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']");
	
	@FindBy(xpath="//button[text()=' Assign ']")
	private WebElement  assignButton;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement AfterselectingName;
	
	@FindBy(xpath="//span[text()='Invalid']")
	private WebElement verifyAssignNameerror;
	
	@FindBy(xpath="//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
	private WebElement verifyrequiredAssignNameeError;
	
	@FindBy(xpath="//label[text()='Leave Type']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
	private WebElement verifyrequiredLeaveTypeeError;
	
	@FindBy(xpath="//label[text()='From Date']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
	private WebElement verifyrequiredFromDateError;
	
	@FindBy(xpath="//label[text()='To Date']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
	private WebElement verifyrequiredToDateError;
	
	public void enterEmployeename(String name) throws InterruptedException {
    	enterTextElement(VarifyEmployeeName, name);
    	Thread.sleep(2000);
    }
    
	   public void clickAssignLeave() {
	    	click(assignLeaveButton);
	    }
	   
	   
    public boolean isEmployeeDropdownDisplayed() {
		return isDisplayed(employeeSuggestions); 	
    }
    
    public String  getSelectedEmployeeName() {
    	return AfterselectingName.getAttribute("value");
    }
    
	 public void selectEmployeeName(String expectedName) {
//    	 wait.until(driver -> {
//    	        List<WebElement> options =
//    	                driver.findElements(employeeSuggestions);
//
//    	        return !options.isEmpty()
//    	                && options.stream().noneMatch(option ->
//    	                    option.getText().trim()
//    	                        .equalsIgnoreCase("Searching..."));
//    	    });	
        List<WebElement> suggestions =
                getVisibleElements(employeeSuggestions);
        System.out.println(suggestions.size());
        for (WebElement suggestion : suggestions) {
        	System.out.println("Suggestion: " + suggestion.getText());
            if (suggestion.getText().trim().equals(expectedName)) {
                click(suggestion);
                return;
          }
        }

        throw new AssertionError("Employee not found: " + expectedName);
    }
	 
	 public void clickAssignButton() {
	    	click(assignButton);
	    }
	 
	 public String verifyAssignErrorName() {
	    	return verifyAssignNameerror.getText();
	    }

	 public boolean isrequiredErrorsisDisplayed() {
			return isDisplayed(verifyrequiredToDateError)
					&&isDisplayed(verifyrequiredFromDateError)
	    	        &&isDisplayed(verifyrequiredLeaveTypeeError)
	    	        &&isDisplayed(verifyrequiredAssignNameeError);
	    }
}
