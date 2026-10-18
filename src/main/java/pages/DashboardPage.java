package pages;

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
	private WebElement  QuickLauchclick;
	
	
    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void QuickLauchClick() {
    	QuickLauchclick.click();
    }

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
    
}