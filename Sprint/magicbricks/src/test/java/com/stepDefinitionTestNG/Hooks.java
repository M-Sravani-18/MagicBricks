package com.stepDefinitionTestNG;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.HomePage;
import com.parameters.PropertyReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;
    public static HomePage home;
    public static Properties prop;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        prop = PropertyReader.readProperty(); // Load config.properties
        home = new HomePage(driver, prop);    // Initialize HomePage with driver and properties
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}