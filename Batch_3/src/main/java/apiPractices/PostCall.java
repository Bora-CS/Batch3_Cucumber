package apiPractices;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCall {

	public static void main(String arg[]) {

		// create user by api by below combination of data
		HashMap body = new HashMap<String, String>();
		HashMap testData = new HashMap<String, String>();

		/************* Test 1 ****************/

		// name    email           password   password2                        statusCode
		// sarah, sarah@gmail.com, test1234, test ->result password is incorrct 400


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/************* Test 2 ****************/
		// sarah, sarahgmail.com, test1234, test1234 -> email is invalid
		body = new HashMap<String, String>();
		body.put("email", "Email is invalid");
		createUser("sarah", "sarahgmail.com", "test1234", "test1234", 400, body);

		/************* Test 3 ****************/
		// sarah, sarah@gmail.com, t, t -> password is too short
		body = new HashMap<String, String>();
		body.put("password", "Password must be at least 6 characters");

		createUser("sarah", "sarah@gmail.com", "t", "t", 400, body);

		/************* Test 4 ****************/
		// sarah, sarah@gmail.com, test1234, test1234 -> succesfully passed 200

//		createUser("sarah", "sarah23@gmail.com", "test1234", "test1234", 200, body);

	}

	private static void createUser(
			HashMap<String,String> testData, HashMap<String,String> body) {

		RestAssured.baseURI = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/";
		RequestSpecification request = RestAssured.given();

		request.headers("Content-type", "Application/json");

		JSONObject obj = new JSONObject();
		obj.put("name", testData.get("name"));
		obj.put("email", testData.get("email"));
		obj.put("password", testData.get("password"));
		obj.put("password2", testData.get("password2"));

		request.body(obj.toJSONString());

		Response result = request.post("api/users/register");

		Assert.assertEquals("****fail"+result.getBody().asString()
				,testData.get("statusCode"), result.getStatusCode()+"");

		for (String key : body.keySet()) {
			Assert.assertEquals("body is: " + result.getBody().asString(), body.get(key),
					result.getBody().jsonPath().getString(key));

		}

		
	}

	public static void createUser(String name, String emailAddress, String password, String password2, int expectedCode,
			HashMap<String, String> body) {

		RestAssured.baseURI = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/";
		RequestSpecification request = RestAssured.given();

		request.headers("Content-type", "Application/json");

		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("email", emailAddress);
		obj.put("password", password);
		obj.put("password2", password2);

		request.body(obj.toJSONString());

		Response result = request.post("api/users/register");

//		Assert.assertEquals("****fail"+result.getBody().asString()
//				,expectedCode, result.getStatusCode());

		for (String key : body.keySet()) {
//			body.get(key); // value from hashMap
//			result.getBody().jsonPath().getString(key); //value from response body
			Assert.assertEquals("body is: " + result.getBody().asString(), body.get(key),
					result.getBody().jsonPath().getString(key));

		}

	}

}
