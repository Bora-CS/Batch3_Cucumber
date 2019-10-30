package apiSteps;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiLogin {

	RequestSpecification request;
	Response resp;

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
	public void user_login_with_and(String emailId, String password) {
		//add header
		request.headers("Content-type", "Application/json");
		//add body,  we add body as JSON type
		//{ "email": "john.doe@gmail.com", "password": “123456” }
		JSONObject body = new JSONObject();
		body.put("email", emailId);
		body.put("password", password);
		request.body(body.toJSONString());
		resp =  request.post("/api/users/login");
	}

	@Then("veirfy status code {int}")
	public void veirfy_status_code(int status) {
		// get status code from the api call
		// and compare the status code with given code ->status
		int actualStatus = resp.getStatusCode();
		String errorMessage = "Status code mismatch, expecting status is: "+status+ 
				"  Actual Status is: "+actualStatus ;
		
		
		Assert.assertEquals(errorMessage,status, actualStatus);
		
		System.out.println(resp.getBody().asString());
	}
}
