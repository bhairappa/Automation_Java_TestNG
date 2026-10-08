package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//h6[text()='Dashboard']")
    //"//div[@class='oxd-topbar-header-title']")
    private WebElement dashboardHeader;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
    	 wait.until(ExpectedConditions.visibilityOf(dashboardHeader));
        return dashboardHeader.isDisplayed();
    }
}