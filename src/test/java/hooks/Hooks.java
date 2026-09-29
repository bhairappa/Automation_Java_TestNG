package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {

        DriverFactory.initializeDriver();
    }

    @After
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}