package apiSteps;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiLogin {

	RequestSpecification request;

	@Given("correct url")
	public void correct_url() {

		// prepare the URL for api testing
		// URI -> http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/
		// URL ->http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/ api/users/login
		// create class level variable for the URI
		RestAssured.baseURI = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000";
		request = RestAssured.given();
	}

	@When("user login with {string} and {string}")
	public void user_login_with_and(String string, String string2) {
		//add header
		request.headers("Content-type", "Application/json");
		//add body,  we add body as JSON type
		JSONObject body = new JSONObject();
		
	}

	@Then("veirfy status code {int}")
	public void veirfy_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}
}
