package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = ".\\src\\test\\resources\\com\\Features\\buy.feature", // Path to feature files
    glue = {"com.stepdefinitiontestng"}, // Step definition package
    plugin = {"pretty", "html:target/cucumber-reports.html"}
    
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}