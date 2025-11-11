package com.pages;
 


import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    Properties prop;

    // Constructor
    public HomePage(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
        PageFactory.initElements(driver, this);
    }

    // Elements initialized via PageFactory
    @FindBy(xpath="/html/body/header/section[2]/div/ul/li[6]/a")
    WebElement mbAdviceLink;

    @FindBy(css = "#commercialIndex > header > section.mb-header__sub.active > div > ul > li.js-menu-container.active > div > div > div:nth-child(3) > ul > li:nth-child(1) > a")
    WebElement localitiesNewDelhiLink;

    @FindBy(xpath = "(//div[contains(@class,'loc-card')]//a)[1]")
    WebElement firstLocalityCard;

    // Actions
    public void openBaseUrl() {
        driver.get(prop.getProperty("base_url"));
    }

    public void clickMbAdviceSection() throws InterruptedException {
        mbAdviceLink.click();
        Thread.sleep(3000);
    }

    public void selectLocalitiesNewDelhi() throws InterruptedException {
        localitiesNewDelhiLink.click();
        Thread.sleep(3000);
    }

    public void clickFirstLocalityCard() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[contains(@class,'loc-card')]//a)[1]")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", card);
            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(card));
            try {
                card.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", card);
            }

            Thread.sleep(2000);
        } catch (TimeoutException e) {
            System.err.println("Locality card not found or not clickable: " + e.getMessage());
        }
    }}