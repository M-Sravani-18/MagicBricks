package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
    features = "src/test/resources/Features/Login.feature",
    glue = {"com.stepDefinitionTestNG"},
    plugin = {"pretty", "html:target/cucumber-reports"
    		},monochrome=true
    		
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
}


