package base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected boolean isDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    protected boolean isDisplayed(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected boolean areDisplayed(List<WebElement> elements, int expectedCount) {
        List<WebElement> visibleElements = wait.until(
            ExpectedConditions.visibilityOfAllElements(elements)
        );
        return visibleElements.size() == expectedCount;
    }

    protected void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        element.sendKeys(text);
    }

    protected void enterText(WebElement element, String text) {
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        visibleElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        visibleElement.sendKeys(text);
    }

    protected List<WebElement> getVisibleElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void clearText(WebElement element) {
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        visibleElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();
    }

    protected String getAttribute(WebElement element, String attribute) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getAttribute(attribute);
    }

    protected boolean waitForElementToDisappear(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    protected void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    protected void switchToFrame(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

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

    protected boolean waitForUrl(String expectedUrl) {
        return wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    protected boolean waitForUrlContains(String partialUrl) {
        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    // Reusable helper for OrangeHRM custom dropdowns
    protected void selectOxdDropdownByText(WebElement dropdownTrigger, String optionText) {
        click(dropdownTrigger);
        By optionLocator = By.xpath(
            "//div[contains(@class,'oxd-select-dropdown')]//div[contains(@class,'oxd-select-option')]//span[normalize-space()='" + optionText + "']"
        );
        click(optionLocator);
    }

 // Add to BasePage.java: Reusable OrangeHRM autocomplete selector (waits until "Searching..." finishes)
    protected void selectOxdAutocompleteOption(WebElement inputField, By suggestionsLocator, String expectedText) {
        // Only re-type if the input field doesn't already have text triggering suggestions
        if (getAttribute(inputField, "value").isEmpty()) {
            enterText(inputField, expectedText);
        }
        wait.until(d -> {
            List<WebElement> options = d.findElements(suggestionsLocator);
            return !options.isEmpty()
                && options.stream().noneMatch(opt -> opt.getText().trim().toLowerCase().contains("searching"));
        });
        for (WebElement suggestion : getVisibleElements(suggestionsLocator)) {
            if (suggestion.getText().trim().equalsIgnoreCase(expectedText)) {
                click(suggestion);
                return;
            }
        }
        throw new AssertionError("Autocomplete option not found: " + expectedText);
    }

    // Add to BasePage.java: Reusable scroll to bottom
    protected void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    
    // Reusable dynamic table reader for any page/table structure
    protected List<Map<String, String>> getTableData(By headerLocator, By rowLocator, By cellLocator) {
        List<WebElement> headers = getVisibleElements(headerLocator);
        List<String> headerNames = new ArrayList<>();
        for (WebElement header : headers) {
            headerNames.add(header.getText().split("\\R")[0].trim());
        }

        List<Map<String, String>> tableData = new ArrayList<>();
        for (WebElement row : getVisibleElements(rowLocator)) {
            List<WebElement> cells = row.findElements(cellLocator);
            Map<String, String> rowMap = new LinkedHashMap<>();

            for (int i = 0; i < headerNames.size() && i < cells.size(); i++) {
                String colName = headerNames.get(i);
                if (!colName.isEmpty() && !colName.equalsIgnoreCase("Actions")) {
                    rowMap.put(colName, cells.get(i).getText().trim());
                }
            }
            tableData.add(rowMap);
        }
        return tableData;
    }
}