package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Setup.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.time.Duration;

public class BasePage {
	static ExtentTest test;
    protected static WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver , ExtentTest test) {
        this.driver = driver;
        this.test=test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
    }

    public void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        
        element.sendKeys(text);
        Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
    }

    public String getText(WebElement element) {
    	Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
        	Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
        	Reports.generateReport(driver, test, Status.FAIL, "Failed to select suggestion: " + e.getMessage());
            return false;
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
        Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
    }

    public String getPageTitle() {
    	Reports.generateReport(driver, test, Status.PASS, "clicked on ask.");
        return driver.getTitle();
        
        
    }
}
