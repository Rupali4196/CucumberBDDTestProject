package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", // Feature files path
		glue = "StepDefination", // Step Definition package
		tags = "@Sanity", monochrome = true, // Clean console output

		plugin = { "pretty", "html:target/Cucumber-Reports/Reports.html", // HTML report
				// "rerun:target/Capture-File/failed_tests.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // ExtentReport
		}, dryRun = false)
public class TestRun {
	// Nothing needed here, annotations do all the work
}
