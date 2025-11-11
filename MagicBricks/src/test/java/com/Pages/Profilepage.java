package com.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Profilepage extends BasePage {

    public Profilepage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/a")
    private WebElement homeInteriorsDropdown;

    @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/div/div/div/ul/li[1]/a")
    private WebElement homeInteriorDesignServices;

    @FindBy(xpath = "//*[normalize-space()='Hyderabad']")
    private WebElement hyderabadLink;

//    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div/div[2]/h2")
//    private WebElement homeInteriorDesignHeading;

    @FindBy(xpath = "//h1[contains(text(),'Interior Designers in Hyderabad')]")
    private WebElement hyderabadDesignersHeading;

    public void hoverOnHomeInteriorsDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homeInteriorsDropdown));
        Actions actions = new Actions(driver);
        actions.moveToElement(homeInteriorsDropdown).perform();
    }

    public void clickHomeInteriorDesignServices() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homeInteriorDesignServices));
        homeInteriorDesignServices.click();
    }

//    public boolean isHomeInteriorDesignPageDisplayed() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        return wait.until(ExpectedConditions.visibilityOf(homeInteriorDesignHeading)).isDisplayed();
//    }

    public void clickHyderabad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(hyderabadLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hyderabadLink);
        System.out.println("Clicked on Hyderabad option successfully.");
    }

    public boolean isHyderabadDesignersPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(hyderabadDesignersHeading)).isDisplayed();
    }
}