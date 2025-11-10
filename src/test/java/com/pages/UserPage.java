package com.pages;
 
import org.openqa.selenium.WebDriver;
 
import com.setup.BaseSteps;
 
public class UserPage {
 
    public WebDriver getDriver() {
        return BaseSteps.driver;   //  Always get updated driver
    }
 
    public String getPageTitle() {
        return getDriver().getTitle();
    }
 
    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }
}
 