package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = "src\\test\\resources\\Features\\Login.feature",
		//tags="@PGPage",
		//tags="@BDPage",
		//tags="@GetPGList",
		glue = {"com.stepDefinitionTestNG"},
		plugin = {"pretty", "html:Reports/cucumber-reports.html"}
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
}


