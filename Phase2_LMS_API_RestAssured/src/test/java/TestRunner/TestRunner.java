package TestRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "html:target/cucumberreport.html", "html:target/ExtentReports/Ds-algo.html",
				"rerun:target/failedrerun.txt", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome = true,
				tags = "",
				features= {"src/test/resources/features"},
				glue = {"StepDefinitions"}
		
		
		
		
		)



public class TestRunner {
	
}

