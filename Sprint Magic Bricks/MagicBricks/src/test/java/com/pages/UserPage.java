package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.BasePage.BrowserUtils;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class UserPage extends BaseSteps {
	
	public void launchBrowserPage() {
		launchBrowser();
		System.out.println("Browser launched sucessfully");
	}
	
	public void navigateToTheApplication() {
		String currentURL=driver.getCurrentUrl();
		Assert.assertNotNull("The current Url is null",currentURL);
		Assert.assertTrue(!currentURL.trim().isEmpty());
        System.out.println("Navigated to application URL: " + currentURL);
	}
	
	 public void verifyHomepageLoaded() {
	        String title = driver.getTitle();
	        Assert.assertNotNull(title, "Page title is null!");
	        Assert.assertFalse(title.trim().isEmpty(), "Page title is empty!");
	        System.out.println("Homepage loaded successfully with title: " + title);
	    }
	 
	 public void verifyApplicationTitle() {
	       // Properties prop = PropertyReader.readProperty();
	        // Optional if you have expectedTitle in properties
	        // String expectedTitle = prop.getProperty("sourceTitle");
	        String actualTitle = driver.getTitle();
	        Assert.assertNotNull(actualTitle, "Application title is null!");
	        Assert.assertFalse(actualTitle.trim().isEmpty(), "Application title is empty!");
	        System.out.println(" Application title verified: " + actualTitle);
	    }
	 
	 public void verifyPlotDisplayed() {
		 
		
		    WebElement plot = driver.findElement(By.id("tabPLOT")); // or use a getter from HomePage
		    boolean isDisplayed = plot.isDisplayed();
		    Assert.assertTrue(isDisplayed, "The plot is not displayed!");
		    System.out.println("The plot is displayed successfully!");

//	        HomePage home = new HomePage();
//	        boolean isDisplayed = .isDisplayed();
//	        Assert.assertTrue(isDisplayed, "The plot is not displayed!");
//	        System.out.println("The plot is displayed successfully!");
    }
	 
	 public void verifyPlotClickable() {
	      
		   WebElement plotElement=driver.findElement(By.id("tabPLOT"));
	        Assert.assertTrue(plotElement.isEnabled(), "The plot is not clickable!");
	        plotElement.click();
	        System.out.println("The plot was clickable and clicked successfully!");
	    }
	 
	 public void clickOnPltsInGatedCommunity() {
		 
		 try {
		        BrowserUtils.switchToNewTab(driver);
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		        verifyPlotClickable();
		        
		        
		        List<WebElement> plots = driver.findElements(By.xpath("//div[@class='mb-home__collection__card__title' and text()='Plots in Gated Community']"));
		        if (!plots.isEmpty()) {
		            plots.get(0).click(); // Clicks the first match
		        }

		        


		        System.out.println("The plot in Gated Community was clicked successfully!");
		    } catch (NoSuchElementException e) {
		        System.out.println("Element not present in DOM: " + e.getMessage());
		    } catch (Exception e) {
		        System.out.println("Unexpected error while clicking plot: " + e.getMessage());
		    }
	    }
	 
	 
	 public static void closeHomepage() {
	        closeBrowser();
	    }
	}


