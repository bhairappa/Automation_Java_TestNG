package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class DashboardPage extends BasePage {

   
    //"//div[@class='oxd-topbar-header-title']")
	 @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;
	 
	@FindBy(xpath="//p[text()='Time at Work']")
	private WebElement dashboardWidgetTimeAndWOrk;
	
	@FindBy(xpath="//p[text()='My Actions']")
	private WebElement dashboardWidgetMyActions;
	
	@FindBy(xpath="//p[text()='Quick Launch']")
	private WebElement dashboardWidgetQuickLaunch;
	
	@FindBy(xpath="//p[text()='Buzz Latest Posts']")
	private WebElement dashboardWidgetBuzzLatestPost;
	
	@FindBy(xpath="//p[text()='Employees on Leave Today']")
	private WebElement dashboardWidgetEmployeesonLeaveToday;
	
	@FindBy(xpath="//p[text()='Employee Distribution by Sub Unit']")
	private WebElement dashboardWidgetEmployeeDistributionbySubUnit;
	
	@FindBy(xpath="//p[text()='Employee Distribution by Sub Unit']")
	private WebElement dashboardWidgetEmployeeDistributionbyLocation;

	@FindBy(xpath="//button[@title='Assign Leave']")
	private WebElement  assignLeaveButton;
	
	@FindBy(xpath="//h6[text()='Assign Leave']")
	private WebElement  assignLeave_Name;
	
	@FindBy(xpath="//label[text()='Employee Name']")
	private WebElement  assignLeave_employeeName;
	
	@FindBy(xpath="//label[text()='Leave Type']")
	private WebElement  assignLeave_LeaveType;
	
	@FindBy(xpath="//label[text()='Leave Balance']")
	private WebElement  assignLeave_LeaveBalance;
	
	@FindBy(xpath="//label[text()='From Date']")
	private WebElement  assignLeave_FromDate;
	
	@FindBy(xpath="//label[text()='To Date']")
	private WebElement  assignLeave_ToDate;
	
	@FindBy(xpath="//label[text()='Comments']")
	private WebElement  assignLeave_Comments;
	
	@FindBy(xpath="//p[text()=' * Required']")
	private WebElement  assignLeave_Required;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")
	private WebElement VarifyEmployeeName;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-dropdown --positon-bottom']")
	private WebElement EmployeeNameDropDown;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement AfterselectingName;
	
    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
//    public void QuickLauchClick() {
//    	QuickLauchclick_AssignLeave.click();
//    }
//    
    public boolean isDashboardDisplayed() {
    	 wait.until(ExpectedConditions.visibilityOf(dashboardHeader));
        return dashboardHeader.isDisplayed();
    }
    public String getActualurl() {
    	return driver.getCurrentUrl();
    }
    public boolean isdashboardWidgetsDisplayed() {
   	 wait.until(ExpectedConditions.visibilityOf(dashboardWidgetTimeAndWOrk));
       return dashboardWidgetTimeAndWOrk.isDisplayed()
    		   &&dashboardWidgetMyActions.isDisplayed()
    		   &&dashboardWidgetQuickLaunch.isDisplayed()
    		   &&dashboardWidgetBuzzLatestPost.isDisplayed()
    		   &&dashboardWidgetEmployeesonLeaveToday.isDisplayed()
    		   &&dashboardWidgetEmployeeDistributionbySubUnit.isDisplayed()
    		   &&dashboardWidgetEmployeeDistributionbyLocation.isDisplayed();
   }
    public void clickAssignLeave() {
    	click(assignLeaveButton);
    }
    public boolean isAssignLeaveWidgetsDisplayed() {
      	 wait.until(ExpectedConditions.visibilityOf(assignLeave_Name));
      	System.out.println(assignLeave_Name.getText());
          return assignLeave_Name.isDisplayed()
       		   &&assignLeave_employeeName.isDisplayed()
       		   &&assignLeave_LeaveType.isDisplayed()
       		   &&assignLeave_LeaveBalance.isDisplayed()
       		   &&assignLeave_FromDate.isDisplayed()
       		   &&assignLeave_ToDate.isDisplayed()
       		   &&assignLeave_Comments.isDisplayed()
       		   &&assignLeave_Required.isDisplayed();
      }
   
    public void enterEmployeename() {
    	enterTextElement(VarifyEmployeeName, "vi");
    }
    public boolean isEmployeeDropdownDisplayed() {
		return isDisplayed(EmployeeNameDropDown);
    	
    }
    public boolean isSelectedEmployeeNameDisplyed() {
    	return isDisplayed(AfterselectingName);
    }
    public void EmployeenameSuggestions() {
    	List<WebElement> employeeNameList =new ArrayList<>();
    	for(WebElement employeeNames:employeeNameList) {
    		if(employeeNames.getText().equals("Ravi M B")) {
    			break;
    		}
    	}
    	
    }
}