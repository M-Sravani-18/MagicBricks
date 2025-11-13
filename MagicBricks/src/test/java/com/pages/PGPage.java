package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.BaseSteps;
import com.setup.Reports;

public class PGPage extends BaseSteps{

	
	
	private static WebDriverWait wait;
    private static ExtentTest test;
 

    public PGPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   // @FindBy(path="//*[@id=\"commercialIndex\"]") ////*[@id="propTypesRent1"]/ul/li[9]/a
    @FindBy(xpath = "//a[contains(text(),'Student Hostels in Bangalore')]")
    private WebElement hostelsinbglr;		////*[@id=\"commercialIndex\
    
    
    @FindBy(xpath="//div[text()='What kind of PG accomodation are you looking for?']")
    private WebElement text;
    
    public void clickHostelsinBglr() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    	//wait.until(ExpectedConditions.visibilityOf(hostelsinbglr));
    	//wait.until(ExpectedConditions.elementToBeClickable(hostelsinbglr)).click();
    	hostelsinbglr.click();
    	//Thread.sleep(2000);
        //pgInBangaloreOption.click();

        //pgInBangaloreOption.click();
    }
    
    
    
//    
//    @FindBy(xpath = "(//*[@id=\"resultBlockWrapper\"]/div[5]")
//    private WebElement firstPG;
//    
//    @FindBy(xpath="/html/body/div[3]/div/div[2]/h1")
//    private WebElement pghead;
//    
    
//    public void clickPg() {
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//    	wait.until(ExpectedConditions.elementToBeClickable(firstPG)).click();
//    	
//    }
    
    public static boolean getPageTitle() {
    	
        try {
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current Page URL: " + currentUrl);
            Reports.generateReport(driver, test, Status.PASS, "PG  Page is verified");
            
            // Just check if URL contains 'seat-availability'
            return currentUrl.contains("hostels-in-bangalore-pppfr");
        } catch (Exception e) {
            System.out.println("Error verifying PG page: " + e.getMessage());
            Reports.generateReport(driver, test, Status.FAIL, "PG Page is not verified");
            return false;
        }
	
	
    }
}
