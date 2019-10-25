package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/search.feature", 
		glue = "steps", 
		tags = {},
		dryRun = false)
public class SearchRunner {

}
