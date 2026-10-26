package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "stepDefinitions",
                "hooks"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

@BeforeClass(alwaysRun = true)
@Parameters("browser")
public void setBrowser(String browser) {
    System.setProperty("browser", browser);
}
}