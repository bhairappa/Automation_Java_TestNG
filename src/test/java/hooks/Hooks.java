package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {

        DriverFactory.initializeDriver();

    }

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

        try {

            if (scenario.isFailed() && driver != null) {

                byte[] screenshot =
                    ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.getName()
                );
/*
 * test-output/                       we can implement it late
    screenshots/
        failed-login.png
        failed-employee.png
 */
                System.out.println(
                    "Screenshot captured for failed scenario: "
                    + scenario.getName()
                );
            }

        } finally {

            DriverFactory.quitDriver();

        }
    }
}