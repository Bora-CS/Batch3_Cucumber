package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/getUserInfo.feature", 
		glue = "apiSteps", 
		tags = {}, 
		dryRun = false)
public class ApiRunner {

}
