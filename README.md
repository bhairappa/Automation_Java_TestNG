# OrangeHRM Enterprise UI Test Automation Framework
Prerequisites
JDK 17 or higher configured in JAVA_HOME

Apache Maven 3.8+ configured in PATH

Google Chrome and/or Microsoft Edge installed

Getting Started & Execution
1. Clone the Repository
Bash
git clone [https://github.com/](https://github.com/)<bhairappa>/<Automation_Java_TestNG>.git
cd <your-repo-name>

2.Run Tests via Maven CLI

Run full cross-browser suite (testng.xml):

Bash
mvn clean test
Run on a specific browser in Headless mode (CI/CD mode):

Bash
mvn clean test -Dbrowser=chrome -Dheadless=true
mvn clean test -Dbrowser=edge -Dheadless=true
Run specific Cucumber tags (e.g., @Priority1 or @recent):

Bash
mvn clean test -Dcucumber.filter.tags="@Priority1"
Test Reports & Logs
Cucumber HTML Report: Generated after every run at target/cucumber-report.html (includes step-by-step execution timings and embedded failure screenshots).

TestNG Suite Report: Generated at test-output/index.html.

Execution Logs: Timestamped thread-level logs saved under logs/automation.log.


![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.25.0-green)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen)
![TestNG](https://img.shields.io/badge/TestNG-7.x-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)

A scalable, thread-safe Behavior-Driven Development (BDD) UI test automation framework built using **Java, Selenium WebDriver, Cucumber, and TestNG** following the **Page Object Model (POM)** design pattern. Designed to validate core HR workflows across **Login, Dashboard, Admin System Users, PIM Employee Management, and Assign Leave** modules.

---

## Key Architectural Highlights

* **Thread-Safe Parallel Execution:** Uses `ThreadLocal<WebDriver>` and `ThreadLocal<String>` in `DriverFactory` to isolate browser sessions and prevent race conditions during cross-browser and parallel suite execution.
* **Resilient Synchronization & Dynamic Table Mapping:** Zero `Thread.sleep()` calls. Uses explicit `WebDriverWait` wrappers (`BasePage`) including custom autocomplete polling and a locator-independent dynamic table reader (`getTableData`) that maps cell values by column header name rather than brittle column indexes.
* **Data-Driven Testing:** Leverages Cucumber `Scenario Outline` with `Examples` tables and externalized environment configuration (`config.properties`) to separate test data from test logic.
* **Automated Failure Diagnostics:** Cucumber `@After` hooks capture full-page byte screenshots on failure and embed them directly into HTML execution reports alongside structured **Log4j2** logs.
* **CI/CD & Headless Ready:** Supports CLI parameter overrides (`-Dbrowser`, `-Dheadless`) via Maven Surefire for seamless execution in GitHub Actions or Jenkins Linux runners.

---

## Tech Stack

| Layer | Technology |
| :--- | :--- |
| **Language** | Java 17 |
| **UI Automation** | Selenium WebDriver 4 (with built-in Selenium Manager) |
| **BDD Framework** | Cucumber JVM (`io.cucumber`) |
| **Test Runner & Assertions** | TestNG (`Assert` & `SoftAssert`) |
| **Build & Dependency Management** | Apache Maven (`maven-surefire-plugin`) |
| **Logging** | Apache Log4j2 |
| **Reporting** | Cucumber HTML Reports / ExtentReports |

---

## Project Directory Structure

```text
Automation_Java_TestNG/
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BasePage.java                 # Reusable explicit waits, React input clear, dynamic table & dropdown helpers
│   │   ├── pages/
│   │   │   ├── LoginPage.java                # Authentication & session logout page objects
│   │   │   ├── DashboardPage.java            # Widget & navigation verification
│   │   │   ├── AdminPage.java                # System Users multi-filter search & results validation
│   │   │   ├── PIMAddEmployeePage.java       # Employee creation, form loader sync & Employee List verification
│   │   │   └── AssignLeavePage.java          # Dynamic autocomplete search & validation error assertions
│   │   └── utilities/
│   │       ├── DriverFactory.java            # ThreadLocal WebDriver lifecycle & headless browser configuration
│   │       └── Configreader.java             # Environment properties loader
│   └── test/
│       ├── java/
│       │   ├── hooks/
│       │   │   └── Hooks.java                # @Before driver setup, @After screenshot capture & teardown
│       │   ├── runners/
│       │   │   └── TestRunner.java           # Cucumber-TestNG bridge with browser parameter injection
│       │   └── stepDefinitions/
│       │       ├── LoginSteps.java
│       │       ├── DashboardSteps.java
│       │       ├── AdminSteps.java
│       │       ├── PIMAddEmployeeSteps.java
│       │       └── AssignLeaveSteps.java
│       └── resources/
│           ├── features/
│           │   ├── Login.feature
│           │   ├── Dashboard.feature
│           │   ├── Admin.feature
│           │   ├── PIMAddEmployee.feature
│           │   └── AssignLeave.feature
│           ├── config.properties             # Default URL, browser, and headless flags
│           └── log4j2.xml                    # Console & rolling file log configuration
├── testng.xml                                # Cross-browser (Chrome & Edge) suite configuration
├── pom.xml                                   # Maven dependencies & Surefire execution profile
└── README.md# Automation_Java_TestNG
Automation_Java_TestNG 
