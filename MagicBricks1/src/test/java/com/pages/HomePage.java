package com.pages;
 
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
 
public class HomePage {
 
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
 
    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }
 
    //  1. Rent dropdown
    @FindBy(id = "rentheading")
    WebElement rentDropdown;
 
    //  2. PG in Bangalore option
    @FindBy(xpath = "//a[contains(@href,'pg-in-bangalore')]")
    WebElement pgInBangaloreOption;
 //(//div[contains(@class,'mb-srp__card')])[1]
    //  3. First PG card from the listings
    @FindBy(xpath = "(//div[@id='resultBlockWrapper']//div[contains(@class,'srp-card__container')])[5]//div[2]")
    WebElement firstPGCard;
 
    //  4. PG Details page title
    @FindBy(xpath = "//h1[contains(text(),'Paying Guest') or contains(text(),'PG')]")
    WebElement pgDetailsTitle;
 
    //  Hover on Rent dropdown
    public void hoverOnRent() {
        wait.until(ExpectedConditions.visibilityOf(rentDropdown));
        actions.moveToElement(rentDropdown).perform();
        System.out.println("Hovered over Rent dropdown");
    }
 
    //  Click “PG in Bangalore”
    public void clickPGInBangalore() {
        wait.until(ExpectedConditions.elementToBeClickable(pgInBangaloreOption));
        pgInBangaloreOption.click();
        System.out.println(" Clicked on 'PG in Bangalore'");
    }
 
    //  Click on first PG from listings
    public void clickFirstPG() {
        wait.until(ExpectedConditions.elementToBeClickable(firstPGCard));
        //firstPGCard.click();
        wait.until(ExpectedConditions.elementToBeClickable(firstPGCard));
        actions.moveToElement(firstPGCard).click().perform();
        System.out.println(" Clicked the first PG from listings");
    }
 
    //  Verify PG Details page
    public void verifyPGDetailsPage() {
        wait.until(ExpectedConditions.visibilityOf(pgDetailsTitle));
        assertTrue(pgDetailsTitle.isDisplayed(), " PG details page not displayed!");
        System.out.println("PG details page displayed successfully!");
    }
}
 
 