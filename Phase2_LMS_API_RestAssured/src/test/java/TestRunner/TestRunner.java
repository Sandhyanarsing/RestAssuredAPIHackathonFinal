package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "json:target/cucmbereport.json","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failedrerun.txt"},
				monochrome = true,
				tags = "",
				features= {"src/test/resources/features"},
				glue = {"StepDefinitions"}
	
		)
public class TestRunner {
	
}

