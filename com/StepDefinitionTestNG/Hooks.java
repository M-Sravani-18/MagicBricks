package com.StepDefinitionTestNG;
 
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.Setup.BaseSteps;
 
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
public class Hooks extends BaseSteps {
    public static ExtentSparkReporter spark;
    public static ExtentReports extReports;
    public static ExtentTest test;

    @BeforeAll
    public static void beforeAll() {
        spark = new ExtentSparkReporter("./target/ExtentReport3.html");
        extReports = new ExtentReports();
        extReports.attachReporter(spark);
    }

    @AfterAll
    public static void afterAll() {
        extReports.flush();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        test = extReports.createTest(scenario.getName());
        String configPath = System.getProperty("configPath", "src/test/resources/PropertiesFile/edureka_resources.properties");
        BaseSteps.initializeProperties(configPath);
        launchBrowser();
    }

    @After
    public void afterScenario() throws InterruptedException {
        if (driver != null) {
        	Thread.sleep(5000);
            driver.quit();
            driver = null;
        }
    }
}