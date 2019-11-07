package apiSteps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilityLibrary.ApiLibrary;

public class ApiLogin {

	ApiLibrary api;

	@Given("correct url")
	public void correct_url() {

		// prepare the URL for api testing
		// URI -> http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/
		// URL ->http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/ api/users/login
		// create class level variable for the URI
		api = new ApiLibrary();
	}

	@When("user login with {string} and {string}")
	public void user_login_with_and(String emailId, String password) {
		// add header
//		request.headers("Content-type", "Application/json");
		// add body, we add body as JSON type
		// { "email": "john.doe@gmail.com", "password": “123456” }
//		JSONObject JsonBody = new JSONObject();
//		JsonBody.put("email", emailId);
//		JsonBody.put("password", password);
//		request.body(JsonBody.toJSONString());
//		resp = request.post("/api/users/login");
		
		api.setUpHeader();
		api.setUpBody("email", emailId);
		api.setUpBody("password", password);
		api.attachBody();
		api.postApiCall("api/users/login");
		
		
	}

	@Then("veirfy status code {int}")
	public void veirfy_status_code(int status) {
		// get status code from the api call
		// and compare the status code with given code ->status
//		int actualStatus = resp.getStatusCode();
		int actualStatus = api.getStatusCode();
		
		String errorMessage = "Status code mismatch, expecting status is: " + status + "  Actual Status is: "
				+ actualStatus;
		Assert.assertEquals(errorMessage, status, actualStatus);
		System.out.println(api.getBodyAsString());

	}

	@When("register user by {string} {string} {string} {string}")
	public void register_user_by(String userName, String emailAddress, String password, String password2) {

//		request.headers("Content-type", "Application/json");

//		JSONObject obj = new JSONObject();
//		obj.put("name", userName);
//		obj.put("email", emailAddress);
//		obj.put("password", password);
//		obj.put("password2", password2);

//		request.body(obj.toJSONString());
//		resp = request.post("/api/users/register");
		
		api.setUpHeader();
		api.setUpBody("name", userName);
		api.setUpBody("email", emailAddress);
		api.setUpBody("password", password);
		api.setUpBody("password2", password2);
		api.attachBody();
		api.postApiCall("api/users/register");
	}

	@Then("verify name {string} and email {string} is correct")
	public void verify_name_and_email_is_correct(String userName, String emailAddress) {

//		String nameFromBody = resp.getBody().jsonPath().getString("name");
//		String emailFromBody = resp.getBody().jsonPath().getString("email");

		String nameFromBody = api.getValueFromBody("name");
		String emailFromBody = api.getValueFromBody("email");
		System.out.println("name: "+nameFromBody+"    |  email: "+emailAddress);
		System.out.println("*****body**"+api.getBodyAsString());
		Assert.assertTrue("**********user name is missmatch: " + nameFromBody, nameFromBody.equals(userName));

		Assert.assertTrue("**********email address is missmatch :" + emailFromBody, emailFromBody.equals(emailAddress));

	}

	@When("user login with name {string} and password {string}")
	public void user_login_with_name_and_password(String userName, String password) {

		api.setUpHeader();
		api.setUpBody("email", userName);
		api.setUpBody("password", password);
		api.attachBody();
		api.postApiCall("api/users/login");

	}

	@Then("verify user infomation")
	public void verify_user_infomation() {
		String token = api.getValueFromBody("token");

		api.setUpHeader("Authorization", token);

		api.getApiCall("api/users/current");

		String bodyText = api.getBodyAsString();
		System.out.println(bodyText);
	}

}
