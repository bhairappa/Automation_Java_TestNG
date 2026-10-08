package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class DashboardSteps extends BasePage {


//    @FindBy(xpath = "//h6[text()='Dashboard']")
//    private WebElement dashboardHeader;
//
    public DashboardSteps(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
//
//    public boolean isDashboardDisplayed() {
//        return dashboardHeader.isDisplayed();
//    }
}