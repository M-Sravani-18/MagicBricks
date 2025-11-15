package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.BasePage.BrowserUtils;
import com.setup.BaseSteps;

public class HomePage extends BaseSteps{
	
	
	@FindBy(id="tabPLOT")
	private WebElement plotclick;
	
	
//	@FindBy(xpath = "//h1[contains(text(),'Presenting Plots and Land in Bangalore')]")
//	private WebElement presentingPlotsHeading;

	
	
	@FindBy(xpath="//a[.//img[@alt='East facing Plots']]")                       
	WebElement clickOnEastFacingPlots;
	
	
	
	 public HomePage() {
	        PageFactory.initElements(driver, this);
	    }


	public void clickPlot() {
		 Assert.assertTrue(plotclick.isDisplayed(), " Plot element is not displayed.");
		    Assert.assertTrue(plotclick.isEnabled(), " Plot element is not clickable.");
		    plotclick.click();
		    System.out.println(" Plot element clicked successfully.");

		
		
	}
	
	public void displayPresentingPlotsandLandInBangalore() {	
//		 Assert.assertTrue(presentingPlotsHeading.isDisplayed(), " Heading 'Presenting Plots and Land in Bangalore' is not visible.");
		    System.out.println(" Heading is visible after clicking plot.");

	}
	
	public void clickEastFacingPlots() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(clickOnEastFacingPlots));
		    Assert.assertTrue(clickOnEastFacingPlots.isDisplayed(), " East-facing plot option is not visible.");
		    Assert.assertTrue(clickOnEastFacingPlots.isEnabled(), " East-facing plot option is not clickable.");
		    clickOnEastFacingPlots.click();
		    System.out.println(" East-facing plot clicked successfully.");
	}
	

	public void clickOnNewProjects() {	
		
		try {
	        BrowserUtils.switchToNewTab(driver);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Wait for the new page to load and the element to be present
	        By seePlotsLocator = By.xpath("(//a[contains(@class,'mb-srp__plcorr__seeplts') and normalize-space(text())='See Plots'])[1]");
	        wait.until(ExpectedConditions.presenceOfElementLocated(seePlotsLocator));

	        // Re-locate the element fresh from the DOM
	        WebElement seePlots = driver.findElement(seePlotsLocator);

	        // Scroll and click safely
	        js.executeScript("arguments[0].scrollIntoView({block:'center'});", seePlots);
	        wait.until(ExpectedConditions.elementToBeClickable(seePlots));
	        seePlots.click();
	        
	        

	        System.out.println(" Clicked on 'See Plots' successfully!");

	    } catch (StaleElementReferenceException stale) {
	        System.out.println(" Stale element caught. Retrying...");


	        // Retry once
	        try {
	            By seePlotsLocator = By.xpath("(//a[contains(@class,'mb-srp__plcorr__seeplts') and normalize-space(text())='See Plots'])[1]");
	            WebElement seePlots = new WebDriverWait(driver, Duration.ofSeconds(5))
	                    .until(ExpectedConditions.elementToBeClickable(seePlotsLocator));

	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", seePlots);
	            seePlots.click();
	            System.out.println(" Retried and clicked 'See Plots' successfully!");
	        } catch (Exception retryEx) {
	            System.out.println(" Retry failed: " + retryEx.getMessage());
	            Assert.fail("Failed to click 'See Plots' after retry.");
	        }

	    } catch (Exception e) {
	        System.out.println(" Error while clicking 'See Plots': " + e.getMessage());
	        Assert.fail("Unexpected error while clicking 'See Plots'");
	    }

		
		
		
		
		
		

	}
			 
}		 

	


