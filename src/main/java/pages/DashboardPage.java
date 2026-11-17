package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//p[text()='Time at Work']")
    private WebElement dashboardWidgetTimeAndWork;

    @FindBy(xpath = "//p[text()='My Actions']")
    private WebElement dashboardWidgetMyActions;

    @FindBy(xpath = "//p[text()='Quick Launch']")
    private WebElement dashboardWidgetQuickLaunch;

    @FindBy(xpath = "//p[text()='Buzz Latest Posts']")
    private WebElement dashboardWidgetBuzzLatestPost;

    @FindBy(xpath = "//p[text()='Employees on Leave Today']")
    private WebElement dashboardWidgetEmployeesOnLeaveToday;

    @FindBy(xpath = "//p[text()='Employee Distribution by Sub Unit']")
    private WebElement dashboardWidgetEmployeeDistributionBySubUnit;

    @FindBy(xpath = "//p[text()='Employee Distribution by Location']")
    private WebElement dashboardWidgetEmployeeDistributionByLocation;

    @FindBy(xpath = "//button[@title='Assign Leave']")
    private WebElement assignLeaveButton;

    @FindBy(xpath = "//h6[text()='Assign Leave']")
    private WebElement assignLeaveHeader;

    @FindBy(xpath = "//label[text()='Employee Name']")
    private WebElement assignLeaveEmployeeName;

    @FindBy(xpath = "//label[text()='Leave Type']")
    private WebElement assignLeaveLeaveType;

    @FindBy(xpath = "//label[text()='Leave Balance']")
    private WebElement assignLeaveLeaveBalance;

    @FindBy(xpath = "//label[text()='From Date']")
    private WebElement assignLeaveFromDate;

    @FindBy(xpath = "//label[text()='To Date']")
    private WebElement assignLeaveToDate;

    @FindBy(xpath = "//label[text()='Comments']")
    private WebElement assignLeaveComments;

    @FindBy(xpath = "//p[text()=' * Required']")
    private WebElement assignLeaveRequired;

    public void clickAssignLeave() {
        click(assignLeaveButton);
    }

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardHeader);
    }

    public boolean verifyDashboardUrl() {
        return waitForUrlContains("/dashboard/index");
    }

    public boolean isdashboardWidgetsDisplayed() {
        List<WebElement> widgets = Arrays.asList(
            dashboardWidgetTimeAndWork,
            dashboardWidgetMyActions,
            dashboardWidgetQuickLaunch,
            dashboardWidgetBuzzLatestPost,
            dashboardWidgetEmployeesOnLeaveToday,
            dashboardWidgetEmployeeDistributionBySubUnit,
            dashboardWidgetEmployeeDistributionByLocation
        );
        return areDisplayed(widgets, widgets.size());
    }

    public boolean isAssignLeaveWidgetsDisplayed() {
        List<WebElement> leaveElements = Arrays.asList(
            assignLeaveHeader,
            assignLeaveEmployeeName,
            assignLeaveLeaveType,
            assignLeaveLeaveBalance,
            assignLeaveFromDate,
            assignLeaveToDate,
            assignLeaveComments,
            assignLeaveRequired
        );
        return areDisplayed(leaveElements, leaveElements.size());
    }
}