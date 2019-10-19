package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleData {

	@Given("I want to write a step with {string}")
	public void i_want_to_write_a_step_with_name(String text) {
		   System.out.println("test write name step -1");

	}

	@When("I check for the {int} in step")
	public void i_check_for_the_in_step(Integer int1) {
		   System.out.println("test check for step -2");

	}


	@Then("I verify the {string} in step")
	public void i_verify_the_in_step(String string) {
		   System.out.println("test verify step->"+string+"<- -3");

	}

	@Then("I enter {string}")
	public void i_enter_a_search_text(String string) {
		   System.out.println("test verify step -4");

	}





}
