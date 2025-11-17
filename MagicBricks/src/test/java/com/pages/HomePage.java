package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reports;

public class HomePage extends BaseSteps {
	private static WebDriverWait wait;
    private static ExtentTest test;
 

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy( id ="rentheading")
    private WebElement rentDropdown;

    @FindBy(xpath = "//a[text()='PG in Bangalore']")
    private WebElement pgInBangaloreOption;
    
    @FindBy(xpath="//div[text()='What kind of PG accomodation are you looking for?']")
    private WebElement text;
    
   

   
    public void hoverOnRentDropdown() {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(rentDropdown).perform();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(rentDropdown));
        new Actions(driver).moveToElement(rentDropdown).perform();

    }

    public void clickPgInBangalore() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //	wait.until(ExpectedConditions.visibilityOf(pgInBangaloreOption));
    	//wait.until(ExpectedConditions.elementToBeClickable(pgInBangaloreOption)).click();
    	
    	//Thread.sleep(2000);
        pgInBangaloreOption.click();

        //pgInBangaloreOption.click();
        }

    public static boolean getPageTitle() {
    	
            try {
                String currentUrl = driver.getCurrentUrl();
                System.out.println("Current Page URL: " + currentUrl);
                Reports.generateReport(driver, test, Status.PASS, "PG  Page is verified");
                
                // Just check if URL contains 'seat-availability'
                return currentUrl.contains("pg-in-bangalore-pppfr");
            } catch (Exception e) {
                System.out.println("Error verifying PG page: " + e.getMessage());
                Reports.generateReport(driver, test, Status.FAIL, "PG Page is not verified");
                return false;
            }
     
    }
}
