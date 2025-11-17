package com.runner;
 
import org.testng.annotations.DataProvider;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		dryRun =false,
		features = ".\\src\\test\\resources\\com\\Features\\Profile.feature",glue = "com.StepDefinitionTestNG",
			//plugin = {"pretty", "html:Reports/cucumber-reports.html"}
				plugin = {"pretty:reports/prettyReport.html", "html:Reports/cucumber-reports.html",
						"json:reports/json-report.json",
						"junit:reports/junit_report.xml","pretty","html:target/cucumber-reports.html"}
		)
public class TestRunnerParallel extends AbstractTestNGCucumberTests {
@DataProvider(parallel=true)
public Object[][] scenarios()
{
	 return super.scenarios();
}
}
