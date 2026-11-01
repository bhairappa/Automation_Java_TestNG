package base;

//import java.awt.List;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator))
            .click();
    }
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element))
            .click();
    }

    protected boolean isDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element))
                   .isDisplayed();
    }

    protected boolean areDisplayed(List<WebElement> elements, int expectedCount) {

        List<WebElement> visibleElements = wait.until(
            ExpectedConditions.visibilityOfAllElements(elements)
        );

        return visibleElements.size() == expectedCount;
    }
    
    protected void enterText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
            .sendKeys(text);
    }
    
    protected void enterTextElement(WebElement varifyEmployeeName, String text) {
        wait.until(ExpectedConditions.visibilityOf(varifyEmployeeName))
            .sendKeys(text);    
    }

    protected boolean isDisplayed(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isDisplayed();
    }
    protected List<WebElement> getVisibleElements(By locator) {
        return wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)
        );
    }
    
 // Clear existing text
    protected void clearText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
    }

    // Get element text
    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element))
                   .getText().trim();
    }

    // Get attribute value
    protected String getAttribute(WebElement element, String attribute) {
        return wait.until(ExpectedConditions.visibilityOf(element))
                   .getAttribute(attribute);
    }

    // Wait for element to disappear
    protected boolean waitForElementToDisappear(By locator) {
        return wait.until(
            ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    // Scroll to element
    protected void scrollToElement(WebElement element) {
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Handle JavaScript alert
    protected void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    // Dismiss JavaScript alert
    protected void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    // Switch to iframe using locator
    protected void switchToFrame(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    // Switch back to main page
    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Switch to another browser window
    protected void switchToWindow(String windowTitle) {
        wait.until(d -> {
            for (String handle : d.getWindowHandles()) {
                d.switchTo().window(handle);

                if (d.getTitle().equals(windowTitle)) {
                    return true;
                }
            }
            return false;
        });
    }

    // Wait for URL
    protected boolean waitForUrl(String expectedUrl) {
        return wait.until(
            ExpectedConditions.urlToBe(expectedUrl)
        );
    }
}