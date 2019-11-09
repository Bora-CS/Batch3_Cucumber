package apiSteps;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilityLibrary.ApiLibrary;

public class ApiLogin {

	ApiLibrary api;

	@Given("correct url")
	public void correct_url() {
		api = new ApiLibrary();
	}

	@When("user login with {string} and {string}")
	public void user_login_with_and(String emailId, String password) {
		// add header
		// add body, we add body as JSON type
		// { "email": "john.doe@gmail.com", "password": “123456” }

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

		int actualStatus = api.getStatusCode();
		
		String errorMessage = "Status code mismatch, expecting status is: " + status + "  Actual Status is: "
				+ actualStatus;
		Assert.assertEquals(errorMessage, status, actualStatus);

	}

	@When("register user by {string} {string} {string} {string}")
	public void register_user_by(String userName, String emailAddress, String password, String password2) {
	
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
		String nameFromBody = api.getValueFromBody("name");
		String emailFromBody = api.getValueFromBody("email");
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
	
	@When("user update profile")
	public void user_update_profile() {
		String token = api.getValueFromBody("token");
		api.setUpHeader();
		api.setUpHeader("Authorization", token);
		
		api.setUpBody("handle", "Nafisa");
		api.setUpBody("company", "Bora Tech");
		api.setUpBody("website", "https://www.bora-cs.com/");
		api.setUpBody("location", "Fairfax, VA");
		api.setUpBody("status", "Tester");
		api.setUpBody("skills", "HTML, CSS, JavaScript");
		api.setUpBody("bio","I'm best test automation engineer among developers :)");
		api.setUpBody("githubusername", "Muradil-Erkin");
		api.setUpBody("instagram","https://www.instagram.com/nafisa/");
		api.setUpBody("linkedin", "https://www.linkedin.com/in/aierken-miladili/");
		
//		api.attachBody();
		
		api.postApiCall("api/profile");
		
		System.out.println(api.getBodyAsString());
		

	}
	
	@When("user update expirence in profile")
	public void user_update_expirence_in_profile() {
	    String token = api.getValueFromBody("token");
		api.setUpHeader();
		api.setUpHeader("Authorization", token);
		
		api.postApiCall("api/profile/experience", "src/test/resources/API_Body/addExpirence.txt");
		System.out.println(api.getBodyAsString());
	    
	}
	
	@Then("delete user expirence from profile")
	public void delete_user_expirence_from_profile() {
	    String firstId = api.getValueFromBody("experience[0]._id");
	    System.out.println("************id: "+firstId);
	    
	    api.deleteApiCall("api/profile/experience/"+firstId);
	}
	
	
	@Then("delete all of user expirence from profile")
	public void delete_all_of_user_expirence_from_profile() {
		
		List<String> ids = api.getListOfValueFromBody("experience._id");
		
		for(String id: ids) {
			api.deleteApiCall("api/profile/experience/"+id);
		}
		System.out.println(api.getBodyAsString());
		
		
//		String wholeId = api.getValueFromBody("experience._id");
//		wholeId = wholeId.replace("[", "").replace("]", "");
//		String[] ids = wholeId.split(",");
//		
//		for(String id : ids) {
//			System.out.println("*********id: "+id.trim());
//			api.deleteApiCall("api/profile/experience/"+id.trim());
//		}
//		
//		System.out.println(api.getBodyAsString());
		
	}

	@Then("veirfy all of expirence been delete")
	public void veirfy_all_of_expirence_been_delete() {

		List<String> expirences = api.getListOfValueFromBody("experience");
		System.out.println("expirence********: "+expirences.size());
		Assert.assertEquals(0, expirences.size());
//		String expirence = api.getValueFromBody("experience");
//		System.out.println("expirence********: "+expirence);
//		
//		Assert.assertEquals("[]", expirence);
	}
	
	

}
