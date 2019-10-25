package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/plp.feature", 
		glue = "steps", 
		tags = {},
		dryRun = true)
public class PLPRunner {

}
