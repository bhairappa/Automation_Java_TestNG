package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

	public class DriverFactory {

		 private static final ThreadLocal<WebDriver> driver =
		            new ThreadLocal<>();
	    private static WebDriver webDriver;

	    public static void initializeDriver() {
	    	String browser =System.getProperty(
	                "browser", Configreader.getProperty("browser"));
	    	 Configreader.getProperty("browser");
	    	
	    	 if (browser.equalsIgnoreCase("chrome")) {
	             webDriver = new ChromeDriver();
	         } else if (browser.equalsIgnoreCase("edge")) {
	             webDriver = new EdgeDriver();
	         }else {
	             throw new IllegalArgumentException(
	                     "Unsupported browser: " + browser
	                 );
	             
	             }
	    	  driver.set(webDriver);
	          getDriver().manage().window().maximize();
	    }

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    public static void quitDriver() {
	        WebDriver webDriver = driver.get();

	        if (webDriver != null) {
	            webDriver.quit();
	            driver.remove();
	        }
	    }
	}

