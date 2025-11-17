package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public WebDriver driver;
    private Properties prop;
    private WebDriverWait wait;

    @FindBy(xpath = "//li[6]/a[contains(text(),'MB Advice')]")
    private WebElement mbAdviceLink;

    @FindBy(xpath = "(//div[contains(@class,'loc-card')]//a)[1]")
    private WebElement firstLocalityCard;

    public HomePage(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void openBaseUrl() {
        driver.get(prop.getProperty("base_url"));
       
    }

    public void clickMbAdviceSection() {
        wait.until(ExpectedConditions.elementToBeClickable(mbAdviceLink)).click();
        System.out.println("Clicked MB Advice section.");
    }

 // Navigate to Localities page
    public void selectLocalitiesNewDelhi() {
        // Open the localities page URL from config
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(prop.getProperty("localities_url"));

        // Wait until the URL contains "localities" (page loaded)
        wait.until(ExpectedConditions.urlContains("localities"));
    }

    // Click on the first locality card
   public void clickFirstLocalityCard() throws InterruptedException {
        // Wait until the first locality card is visible and clickable
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement card = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(prop.getProperty("first_locality_xpath"))));

        // Click the card directly
        card.click();
        Thread.sleep(3000);
        
        System.out.println("Clicked first locality card.");
    }

    
    public boolean isLocalityPageDisplayed() {
    String expectedKeyword = prop.getProperty("locality_url_keyword"); 
    return wait.until(ExpectedConditions.urlContains(expectedKeyword));
}
//--------------------second scenario--------------------------------------------//
    @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[6]/div/div/div[4]/ul/li[3]/a")
    private WebElement compareLocalitiesLink;

    public void clickMBAdvice() {
        wait.until(ExpectedConditions.elementToBeClickable(mbAdviceLink)).click();
    }

    public void clickCompareLocalities() {
        wait.until(ExpectedConditions.elementToBeClickable(compareLocalitiesLink)).click();
    }

    public boolean isCompareLocalitiesPageLoaded() {
        try {
            return wait.until(ExpectedConditions.urlContains("#compareSectionWrapper"));
        } catch (Exception e) {
            return false;
        }
    
}
       
//-------3rd scenario --------------------------------------------------------------------//
@FindBy(xpath = "//*[normalize-space(text())='Price/Sqft']")
private WebElement priceSqftFilterLabel;

@FindBy(css = "#budgetLi > div.rangeList.toggleList > div.rangeList__done > a")
private WebElement doneButton;

public void clickPriceSqftFilter() {
   wait.until(ExpectedConditions.elementToBeClickable(priceSqftFilterLabel)).click();
   System.out.println(" Price/Sqft filter clicked");
}

public void selectMinPriceAndClickDone(String minPriceValue) {
   // Format Excel value to match UI (5000 -> 5,000)
   minPriceValue = formatPrice(minPriceValue);

   // Click Min tab
   WebElement minTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("budgetPerSqftMin")));
   minTab.click();
   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(text(),'₹')]")));

   // Build XPath for Min Price
   String minXPath = String.format("//li[normalize-space(text())='₹ %s']", minPriceValue);
   WebElement minElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(minXPath)));

   // Click Min Price directly
   minElement.click();
   System.out.println(" Min Price selected: " + minPriceValue);

   // Click DONE button directly
   wait.until(ExpectedConditions.elementToBeClickable(doneButton));
   doneButton.click();
   System.out.println(" DONE clicked successfully");
}

private String formatPrice(String price) {
   price = price.replace(",", "").trim();
   int value = Integer.parseInt(price);
   return String.format("%,d", value);
}

public WebElement getDoneButton() {
   return doneButton;
}
   

  
    
    
//-------------------4th scenario -------------------------//
    @FindBy(xpath = "//a[text()='MB Advice']")
    private WebElement mbAdviceMenu;

    @FindBy(xpath = "/html/body/header/section[2]/div/ul/li[6]/div/div/div[3]/ul/li[1]/a")
    private WebElement localitiesLink;

    @FindBy(xpath = "//input[@class='search-box__input']") 
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id='cityLocalityInput']")
    private WebElement firstDropdownOption;

    @FindBy(xpath = "(//div[@class='loc-card'])[1]")
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
        firstDropdownOption.click();
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
    
//-----------------6th scenario -------------------------------//
    
    
    public void enterSearch(String city) {
        searchBox.clear();
        searchBox.sendKeys(city);
    }

    public boolean isErrorMessageDisplayed() {
        String expectedMessage = prop.getProperty("expected_error_message");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("errorMessageCity")
            ));
            return errorMsg.isDisplayed() && errorMsg.getText().trim().equals(expectedMessage);
        } catch (TimeoutException e) {
            return false;
        }
    }

	
	
    } 