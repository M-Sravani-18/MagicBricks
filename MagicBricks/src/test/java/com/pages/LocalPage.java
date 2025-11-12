package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Replace with actual ID or locator



import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.setup.BaseSteps;

public class LocalPage extends BaseSteps{
	private WebElement localityInput;
	private static WebDriverWait wait;
    private static ExtentTest test;
 


    public LocalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
    
    @FindBy(xpath = "//*[@id=\\\"refine_keyword\\")
    private WebElement locality;
    
    
    @FindBy(xpath = "//*[@id=\"topLocalitiesDiv\"]/div[1]") 
    private WebElement firstSuggestion;
    
    @FindBy(xpath = "//*[@id=\"topLocalitiesDiv\"]/div[2]") 
    private WebElement secondSuggestion;

    
    @FindBy(xpath = "//*[@id=\"topLocalitiesDiv\"]/div[3]") 
    private WebElement thirdSuggestion;


    @FindBy(xpath = "//*[@id=\"resultDiv\"]/div[4]/div[1]/ul/li/a") 
    private List<WebElement> pgListings;

    
    public void enterLocality(String localityText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(locality));
        locality.clear();
        locality.sendKeys(localityText);
    }
    
 
    public void selectFirstSuggestion() {
    	//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	//        wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
    	firstSuggestion.click();
    }

    public void selectSecondSuggestion() {
    	//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	//      wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
    	secondSuggestion.click();
    }
    public void selectThirdSuggestion() {
    	//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	//      wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
    	thirdSuggestion.click();
    }

   

    public boolean isPgListDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(pgListings));
            return !pgListings.isEmpty();
        } catch (TimeoutException e) {
            return false;
        }
    }
    
    
	
	

}
