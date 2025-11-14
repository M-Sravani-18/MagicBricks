
package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
    static WebDriver driver;
    Properties prop;
	private WebDriverWait wait;

    public HomePage(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;

      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[6]/a[contains(text(),'MB Advice')]")
    WebElement mbAdviceLink;

    
//    @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[6]/div/div/div[4]/ul/li[1]/a") // ////*[@id="commercialIndex"]/header/section[2]/div/ul/li[6]/div/div/div[4]/ul/li[1]/a
//    @FindBy(linkText = "Localities in New-Delhi")
//      @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[6]/div/div/div[2]/ul/li[1]/a")
      
  //*[@id="commercialIndex"]/header/section[2]/div/ul/li[6]/div/div/div[4]/ul/li[1]/a
 
//    WebElement localitiesNewDelhiLink;

    @FindBy(xpath = "(//div[contains(@class,'loc-card')]//a)[1]")
    WebElement firstLocalityCard;
  
  public void openBaseUrl() {
       // driver.get(prop.getProperty("base_url"));
        driver.get("https://www.magicbricks.com/property-for-sale-rent-in-New-Delhi/residential-real-estate-New-Delhi");
        waitForPageLoad();
    }


  public void clickMbAdviceSection() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.elementToBeClickable(mbAdviceLink)).click();
	    System.out.println("Clicked MB Advice section.");
	}
 
  
  public boolean selectLocalitiesNewDelhi() {
	  try {
//	    	Thread.sleep(2000);
//	        By localitiesInNewdelhi = By.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[6]/div/div/div[3]/ul/li[1]/a");
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	        wait.until(ExpectedConditions.elementToBeClickable(localitiesInNewdelhi)).click();
	        // Handle new tab if opened
//		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		  driver.get("https://www.magicbricks.com/localities-in-New-Delhi");
		  
//	        wait.until(ExpectedConditions.g("https://www.magicbricks.com/localities-in-New-Delhi")).click();
//		  WebDriverWait wait = driver.get("https://www.magicbricks.com/localities-in-New-Delhi");
	        String originalWindow = driver.getWindowHandle();
	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(originalWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }

	        // Wait for URL to change
	        wait.until(ExpectedConditions.urlContains("localities"));
	        return true;
	    } catch (Exception e) {
	        System.out.println("Error clicking property type: " + e.getMessage());
	        return false;
	    }
  }
   
  
    public void clickFirstLocalityCard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[contains(@class,'loc-card')]//a)[1]")));
            scrollIntoView(card);
            wait.until(ExpectedConditions.elementToBeClickable(card)).click();
            System.out.println("Clicked first locality card.");
        } catch (Exception e) {
            fallbackClick(firstLocalityCard, "First Locality Card");
        }
    }

    public void openCompareLocalitiesPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement compareLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Compare Localities')]")));
            scrollIntoView(compareLink);
            wait.until(ExpectedConditions.elementToBeClickable(compareLink)).click();
            System.out.println("Opened Compare Localities page.");
        } catch (Exception e) {
            fallbackClick(By.xpath("//a[contains(text(),'Compare Localities')]"), "Compare Localities");
        }
    }

    public void verifyCompareLocalitiesPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            waitForPageLoad();
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'compare localities')]")));
            scrollIntoView(heading);
            System.out.println("Compare Localities page loaded: " + heading.getText());
        } catch (Exception e) {
            System.err.println("Compare Localities page not loaded: " + e.getMessage());
        }
    }

    private void scrollIntoView(WebElement element) {
        try {
            if (element != null && element.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            }
        } catch (Exception e) {
            System.err.println("Error during scrollIntoView: " + e.getMessage());
        }
    }

    private void fallbackClick(WebElement element, String name) {
        try {
            scrollIntoView(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            System.out.println("Fallback JS click on: " + name);
        } catch (Exception e) {
            System.err.println("Failed to click " + name + ": " + e.getMessage());
        }
    }
    
    

    private void fallbackClick(By locator, String name) {
        try {
            WebElement element = driver.findElement(locator);
            scrollIntoView(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            System.out.println("Fallback JS click on: " + name);
        } catch (Exception e) {
            System.err.println("Failed to click " + name + ": " + e.getMessage());
        }
    }

    private void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    

    @FindBy(xpath = "//*[normalize-space(text())='Price/Sqft']")
    private WebElement priceSqftFilterLabel;

    @FindBy(css = "#budgetLi > div.rangeList.toggleList > div.rangeList__done > a")
    private WebElement doneButton;

    /**
     * Click Price/Sqft filter
     */
    public void clickPriceSqftFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(priceSqftFilterLabel)).click();
        System.out.println(" Price/Sqft filter clicked");
    }

    /**
     * Select Min Price and click DONE
     */
    public void selectMinPriceAndClickDone(String minPriceValue) {
        try {
            // Format Excel value to match UI (5000 -> 5,000)
            minPriceValue = formatPrice(minPriceValue);

            // Click Min tab
            WebElement minTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("budgetPerSqftMin")));
            minTab.click();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(text(),'₹')]")));

            // Build XPath for Min Price
            String minXPath = String.format("//li[normalize-space(text())='₹ %s']", minPriceValue);
            WebElement minElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(minXPath)));

            // Scroll and click Min Price
            scrollIntoView(minElement);
            scrollAndClick(minElement);
            System.out.println(" Min Price selected: " + minPriceValue);

            // Scroll and click DONE button
            scrollIntoView(doneButton);
            wait.until(ExpectedConditions.elementToBeClickable(doneButton));
            scrollAndClick(doneButton);
            System.out.println(" DONE clicked successfully");

        } catch (Exception e) {
            
            Assert.fail(" Error selecting Min price or clicking DONE: " + e.getMessage());
        }
    }

    /**
     * Formats price by adding commas (e.g., 5000 -> 5,000)
     */
    private String formatPrice(String price) {
        price = price.replace(",", "").trim();
        int value = Integer.parseInt(price);
        return String.format("%,d", value);
    }

    /**
     * Scroll element into view
     */
    private void scrollIntoView1(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    /**
     * Click using JavaScript
     */
    private void scrollAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
  
    public WebElement getDoneButton() {
        return doneButton;
    }
//-------------------4th scenario -------------------------//
    @FindBy(xpath = "//a[text()='MB Advice']")
    private WebElement mbAdviceMenu;

    @FindBy(xpath = "/html/body/header/section[2]/div/ul/li[6]/div/div/div[3]/ul/li[1]/a")
    private WebElement localitiesLink;

    @FindBy(xpath = "//input[@class=\"search-box__input\"]") // Replace with actual ID
    private WebElement searchBox;

    @FindBy(xpath = "(/html/body/div[2]/div[2]/div[2]/div[2]/div[1]")
    private WebElement firstDropdownOption;

    @FindBy(xpath = "(//div[@class='locality-card'])[1]")
    private WebElement firstLocality;

    public void selectLocalities() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mbAdviceMenu).pause(Duration.ofSeconds(2)).perform();
        wait.until(ExpectedConditions.visibilityOf(localitiesLink));
        actions.moveToElement(localitiesLink).click().perform();
    }

    public void clickSearchBox() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)).click();
    }

    public void enterCityInSearch(String city) {
        searchBox.clear();
        searchBox.sendKeys(city);
    }

    

    public void clickFirstLocality() {
        wait.until(ExpectedConditions.elementToBeClickable(firstLocality)).click();
        wait.until(ExpectedConditions.urlContains("locality")); // Confirm navigation
    }
    
   // --------------- 5th scenario ------------------------------//

    

    @FindBy(xpath = "//a[contains(text(),'New Projects in New Delhi')]")
    private WebElement newProjectsLink;

    public WebElement getMbAdviceMenu() {
        return mbAdviceMenu;
    }

    public void selectNewProjects() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mbAdviceMenu).pause(Duration.ofSeconds(2)).perform();
        wait.until(ExpectedConditions.visibilityOf(newProjectsLink));
        actions.moveToElement(newProjectsLink).click().perform();
        wait.until(ExpectedConditions.urlContains("new-projects"));
        System.out.println("Clicked on New Projects successfully.");
    }
    

    
    }