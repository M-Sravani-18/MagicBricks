package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EstimatedCostPage extends BasePage {

    public EstimatedCostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // 🔹 Bangalore Design Link
    @FindBy(xpath = "//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[5]/div/div/div/ul/li[2]/a")
    private WebElement bangaloreDesignLink;

    // 🔹 Get Estimate Button
    @FindBy(xpath = "//*[@id=\"intsrpPages\"]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/a")
    private WebElement getEstimateButton;

    // 🔹 BHK Dropdown Label
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div[1]")
    private WebElement bhkDropdownLabel;

    // ✅ Step 1: Click Bangalore Design Link
    public void clickInteriorDesignInBangalore() {
        wait.until(ExpectedConditions.elementToBeClickable(bangaloreDesignLink)).click();
        System.out.println("Clicked on Interior Design in Bangalore link.");
    }

    // ✅ Step 2: Click Get Estimate Now
    public void clickGetEstimateNow() {
        wait.until(ExpectedConditions.elementToBeClickable(getEstimateButton)).click();
        System.out.println("Clicked on Get Estimate Now.");
    }

    // ✅ Step 3: Verify BHK Dropdown Visibility
    public boolean isBHKDropdownVisible() {
        boolean visible = isElementDisplayed(bhkDropdownLabel);
        System.out.println("BHK dropdown visibility: " + visible);
        return visible;
    }
}