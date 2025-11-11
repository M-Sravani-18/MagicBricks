package com.StepDefinitionTestNG;

import com.Pages.Profilepage;
import com.Setup.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseSteps {
    public static Profilepage profilePage;

    @Before
    public void setUp() {
        launchBrowser();
        profilePage = new Profilepage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}