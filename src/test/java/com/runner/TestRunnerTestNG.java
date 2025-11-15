package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = ".\\src\\test\\resources\\com\\Features\\buy.feature", // Path to feature files
    
    glue = {"com.stepdefinitiontestng"}, // Step definition package  
    plugin = {"pretty", "html:target/cucumber-reports.html",
    		"pretty","html:reports/HTMLReports.html",
			"json:reports/json-report.json",
			"junit:reports/junit_report.xml"},  
            // tags="@fifthscenario",
       monochrome= false
    )
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}