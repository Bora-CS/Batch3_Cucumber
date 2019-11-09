package utilityLibrary;

import java.io.File;
import java.util.List;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiLibrary {

	RequestSpecification request;
	
	Response response;
	
	JSONObject JsonBody = new JSONObject();

	public ApiLibrary() {
		RestAssured.baseURI = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/";
		request = RestAssured.given();
	}


	/**********************
	 * Header & Body
	 **********************/
	
	//Method overloading
	public void setUpHeader() {
		request.headers("Content-type", "Application/json");
	}
	public void setUpHeader(String key, String value) {
		request.headers(key, value);
	}
	
	
	public void setUpBody(String key, String value) {
		JsonBody.put(key, value);
	}
	
	public void attachBody() {
//		request.body(JsonBody.toJSONString());
	}
	
	
	
	/**********************
	 * API CALL
	 **********************/
	
	public void postApiCall(String appendUrl) {
		request.body(JsonBody.toJSONString());
		
		response = request.post(appendUrl);
	}
	
	public void postApiCall(String appendUrl, String filePath) {
		File bodyFile = new File(filePath);
		request.body(bodyFile);
		
		response = request.post(appendUrl);
	}
	
	public void getApiCall(String appendUrl) {
		request.body(JsonBody.toJSONString());
		response = request.get(appendUrl);
	}
	
	public void deleteApiCall(String appendUrl) {
		response = request.delete(appendUrl);
	}
	
	
	
	
	
	
	
	
	/**********************
	 * Response
	 **********************/
	
	public Response getResponse() {
		return response;
	}
	
	public int getStatusCode() {
		return response.getStatusCode();
	}
	
	public String getBodyAsString() {
		return response.prettyPrint().toString();
	}
	
	public String getValueFromBody(String path) {
		return response.getBody().jsonPath().getString(path);
	}

	public List<String> getListOfValueFromBody(String path) {
		return response.getBody().jsonPath().getList(path);
	}
	
	
	/**********************
	 * Utility
	 **********************/
	
	public File readBodyFile(String path) {
		File bodyFile = new File(path);
		return bodyFile;
	}
	

}
