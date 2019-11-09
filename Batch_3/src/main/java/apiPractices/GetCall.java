package apiPractices;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCall {

	static RequestSpecification request;
	static Response response;
	static String baseUri = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/";
	static String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVkMGMyMjAyYzdlNDYwMGVjYzYyOTNmNiIsIm5hbWUiOiJKb24gRG9lIiwiYXZhdGFyIjoiLy93d3cuZ3JhdmF0YXIuY29tL2F2YXRhci8zOGU1NDIzZjQwMDIyMTAzZWJkOWUyYWU5M2IyOWExNj9zPTIwMCZyPXBnJmQ9bW0iLCJpYXQiOjE1NzMzMzExNzEsImV4cCI6MTU3MzMzNDc3MX0.iM-N3GdDPYG3QnaCZjJJ7liCYvQz6Uwe_LBzFO_OQQE";
	public static void main(String[] args) {
		
		
		RestAssured.baseURI = baseUri;
		
		request = RestAssured.given();
		
		
		
		
		request.headers("Content-type", "Application/json");
		request.headers("Authorization", token);
		//url = http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/
		response = request.get("api/users/current");
		//url = http://ec2-3-86-91-230.compute-1.amazonaws.com:5000/api/users/current
		
		System.out.println("status code is: "+response.getStatusCode());
		System.out.println("status line is: "+response.getStatusLine());
		
//		System.out.println("body is: "+response.getBody().asString());
//		System.out.println("body is: "+response.getBody().prettyPrint());
		String[] bodyArray = response.getBody().asString().split(",");
		for(String bodyLine : bodyArray) {
//			System.out.println(bodyLine);
		}
		
		/**************** Test 2 ***********/
		
		
		
		
		request = RestAssured.given();
		
		request.headers("Content-type", "Application/json");
		request.headers("Authorization", token);
		
		response = request.get("api/profile");
		
		System.out.println(response.getBody().prettyPrint());
		
		String actualName = response.getBody().jsonPath().get("user.name");
		String actualCompany = response.getBody().jsonPath().get("company");
		
		List<String> companies =response.getBody().jsonPath().getList("experience.company");
		
		for(String com: companies) {
			if(com.equals("Gap")) System.out.println("he work in Gap");
		}
		
		String company = response.getBody().jsonPath().getString("experience.company");
		if(company.contains("Gap")) System.out.println("he work in Gap by string");
	}
	
	
	
	
	
}
