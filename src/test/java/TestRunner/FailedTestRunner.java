package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed_tests.txt", glue = "StepDefination", monochrome = true, plugin = { "pretty",
		"html:target/Cucumber-Reports/FailedTestReport.html" })
public class FailedTestRunner {
}
