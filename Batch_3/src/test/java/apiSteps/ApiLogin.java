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
		// add header
		request.headers("Content-type", "Application/json");
		// add body, we add body as JSON type
		// { "email": "john.doe@gmail.com", "password": “123456” }
		JSONObject body = new JSONObject();
		body.put("email", emailId);
		body.put("password", password);
		request.body(body.toJSONString());
		resp = request.post("/api/users/login");
	}

	@Then("veirfy status code {int}")
	public void veirfy_status_code(int status) {
		// get status code from the api call
		// and compare the status code with given code ->status
		int actualStatus = resp.getStatusCode();
		String errorMessage = "Status code mismatch, expecting status is: " + status + "  Actual Status is: "
				+ actualStatus;
		Assert.assertEquals(errorMessage, status, actualStatus);
		System.out.println(resp.getBody().asString());
	}

	@When("register user by {string} {string} {string} {string}")
	public void register_user_by(String userName, String emailAddress, String password, String password2) {

		request.headers("Content-type", "Application/json");

		JSONObject obj = new JSONObject();
		obj.put("name", userName);
		obj.put("email", emailAddress);
		obj.put("password", password);
		obj.put("password2", password2);

		request.body(obj.toJSONString());
		resp = request.post("/api/users/register");
	}

	@Then("verify name {string} and email {string} is correct")
	public void verify_name_and_email_is_correct(String userName, String emailAddress) {

		String nameFromBody = resp.getBody().jsonPath().getString("name");
		String emailFromBody = resp.getBody().jsonPath().getString("email");
		
		Assert.assertTrue("user name is missmatch: "+nameFromBody,
				nameFromBody.equals(userName));
		
		Assert.assertTrue("email address is missmatch :"+emailFromBody, emailFromBody.equals(emailAddress));

	}

}
