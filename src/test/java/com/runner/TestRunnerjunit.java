package com.runner;
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
	    features = ".\\src\\test\\resources\\com\\Features\\buy.feature", // Path to feature files
	    
	    
	    glue = {"com.stepdefinitiontestng"}, // Step definition package  
	    		 // tags= "@fourthscenario",
	    plugin = {"pretty:reports/prettyReport.html",
	    		"html:target/cucumber-reports.html",
	    		"pretty","html:reports/HTMLReports.html",
				"json:reports/json-report.json",
				"junit:reports/junit_report.xml"}
        
)
public class TestRunnerjunit {
 
}