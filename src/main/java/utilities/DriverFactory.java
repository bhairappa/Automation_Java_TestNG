package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<String> browserName = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        browserName.set(browser);
    }

    public static void initializeDriver() {
        String browser = browserName.get() != null
                ? browserName.get()
                : System.getProperty("browser", Configreader.getProperty("browser"));

        boolean isHeadless = Boolean.parseBoolean(
                System.getProperty("headless", Configreader.getProperty("headless"))
        );

        WebDriver webDriver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) {
                options.addArguments("--headless=new", "--window-size=1920,1080", "--no-sandbox", "--disable-dev-shm-usage");
            }
            webDriver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless) {
                options.addArguments("--headless=new", "--window-size=1920,1080");
            }
            webDriver = new EdgeDriver(options);

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.set(webDriver);
        if (!isHeadless) {
            getDriver().manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        WebDriver webDriver = driver.get();
        try {
            if (webDriver != null) {
                webDriver.quit();
            }
        } finally {
            driver.remove();
            browserName.remove();
        }
    }
}