//package com.StepDefinitionTestNG;
//
//import com.Pages.Profilepage;
//import com.Setup.BaseSteps;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class Hooks extends BaseSteps {
//    public static Profilepage profilePage;
//
//    @Before
//    public void setUp() {
//        launchBrowser();
//        profilePage = new Profilepage(driver);
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
//package com.StepDefinitionTestNG;
//
//import com.Pages.Profilepage;
//import com.Pages.EstimatedCostPage;
//import com.Parameters.PropertyReader;
//import com.Setup.BaseSteps;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//import java.util.Properties;
//
//public class Hooks extends BaseSteps {
//    public static Profilepage profilePage;
//    public static EstimatedCostPage estimatePage;
//    public static Properties prop;
//
//    @Before
//    public void setUp() {
//        // Launch browser
//        launchBrowser();
//
//        // Load properties
//        prop = PropertyReader.readProperty();
//
//        // Initialize page objects
//        profilePage = new Profilepage(driver);
//        estimatePage = new EstimatedCostPage(driver);
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}


//package com.StepDefinitionTestNG;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.Setup.BaseSteps;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//public class Hooks extends BaseSteps
//{
// 
//    public static WebDriver driver;
//    @Before
// 
//    public void setUp() {
// 
//        driver = new ChromeDriver(); // Set path if needed
// 
//        driver.manage().window().maximize();
// 
//    }
//    @After
// 
//    public void tearDown() {
// 
//        driver.quit();
// 
//    }
//}