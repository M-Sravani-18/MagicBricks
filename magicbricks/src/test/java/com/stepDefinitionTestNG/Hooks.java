/*-----------package com.stepDefinitionTestNG;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.HomePage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
public class Hooks extends BaseSteps{

public static WebDriver driver;
public static HomePage home;
public static Properties prop;

//
	public static ExtentSparkReporter spark;
    public static ExtentReports extReports;
    public static ExtentTest test;
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        prop = PropertyReader.readProperty(); // Load config.properties
//        home = new HomePage(driver, prop);    // Initialize HomePage with driver and properties
//    }
//    @BeforeAll
//    public static void beforeAll() {
//        spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");
//        extReports = new ExtentReports();
//        extReports.attachReporter(spark);
//    }
////    
//    @AfterAll
//    public static void afterAll() {
//        //after feature file ends this will run
//    	//to generate extent report like commit method
//        extReports.flush();
//    }
//    @Before
//    public void beforeScenario(Scenario scenario) throws Exception {
//       System.out.println("hi...");//before every scenario
//       //on the test track the name of the scenario
//       //Fresh browser will launch
//       home = new HomePage(driver, prop); 
//        test = extReports.createTest(scenario.getName());
////       launchBrowser();
//        launchBrowser();
//    }
// 
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//    public void afterScenario() {
////        sleep(4000);
////        driver.quit();   //after every scenario
//    }
/*
@Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        prop = PropertyReader.readProperty(); // Load config.properties
        home = new HomePage(driver, prop);    // Initialize HomePage with driver and properties
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/

/*----
@Before
public void setUp() {
    driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.magicbricks.com/property-for-sale-rent-in-New-Delhi/residential-real-estate-New-Delhi");

     prop = PropertyReader.readProperty();
     home = new HomePage(driver, prop); // or new HomePage(driver, prop) if you add constructor
 }

 @After
 public void tearDown() {
     if (driver != null) {
         driver.quit();
     }

}
 */
package com.stepDefinitionTestNG;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.HomePage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;

import io.cucumber.java.*;

public class Hooks extends BaseSteps {

    public static WebDriver driver;
    public static HomePage home;
    public static Properties prop;

    public static ExtentSparkReporter spark;
    public static ExtentReports extReports;
    public static ExtentTest test;

    // ✅ Runs once before all scenarios
    @BeforeAll
    public static void beforeAll() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/target/ExtentReport_" + timestamp + ".html";

        spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("MagicBricks Test Execution");

        extReports = new ExtentReports();
        extReports.attachReporter(spark);

        // Add system info
        extReports.setSystemInfo("Tester", "Your Name");
        extReports.setSystemInfo("Browser", "Chrome");
        extReports.setSystemInfo("Environment", "QA");
    }

    // ✅ Runs before each scenario
    @Before
    public void beforeScenario(Scenario scenario) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.magicbricks.com/property-for-sale-rent-in-New-Delhi/residential-real-estate-New-Delhi");

        prop = PropertyReader.readProperty();
        home = new HomePage(driver, prop);

        // Create a test entry in ExtentReport for this scenario
        test = extReports.createTest(scenario.getName());
    }

    // ✅ Runs after each scenario
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture screenshot on failure
            String screenshotPath = Reports.captureScreenshot(driver, scenario.getName());
            test.fail("Scenario Failed", com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.pass("Scenario Passed");
        }

        if (driver != null) {
            driver.quit();
        }
    }

    // ✅ Runs once after all scenarios
    @AfterAll
    public static void afterAll() {
        extReports.flush();
    }


}