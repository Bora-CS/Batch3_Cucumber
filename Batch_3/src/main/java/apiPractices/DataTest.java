package apiPractices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataTest {

	public static void main(String[] args) {
		int i = 1;
		for (HashMap temp : readData()) {
			createUser(temp);
			System.out.println("Test Case -" + i + " PASS");
			i++;
		}

	}


	// TestData -- sarah, sarah@gmail.com, test1234, t
	// ExpectingTestRsult -- 400, password2, Passwords must match

	public static List<HashMap> readData() {
		List<HashMap> listOfMap = new ArrayList<HashMap>();
		try {
			FileReader file = new FileReader("src/main/resources/TestData.txt");
			BufferedReader reader = new BufferedReader(file);

			String line = "";

			System.out.println("decriptions for this file is: " + reader.readLine() + "\n");
			while ((line = reader.readLine()) != null) {
				HashMap<String, String> testData = new HashMap<>();
//				System.out.println("reader line in the loop: "+line);
				// line = sarah, sarah@gmail.com, test1234, test
				testData.put("name", line.split(",")[0].trim());
				testData.put("email", line.split(",")[1].trim());
				testData.put("password", line.split(",")[2].trim());
				testData.put("password2", line.split(",")[3].trim());
				testData.put("statusCode", line.split(",")[4].trim());
				testData.put("expectingKey", line.split(",")[5].trim());
				testData.put("expectingValue", line.split(",")[6].trim());
//				System.out.println("map in loop: "+testData.toString()+"\n");
				listOfMap.add(testData);
			}

//			System.out.println("first reader line "+reader.readLine());
//			
//			System.out.println("second reader line "+reader.readLine());
//			
//			System.out.println("third reader line "+reader.readLine());
//			
//			System.out.println("fourth reader line "+reader.readLine());
//			
//			System.out.println("fifth reader line "+reader.readLine()); //readLine = null, null != null

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listOfMap;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private static void createUser(HashMap<String, String> testData) {

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

		String actualStatusCode = result.getStatusCode() + "";

		Assert.assertEquals("****fail" + result.getBody().asString(), testData.get("statusCode"), actualStatusCode);

		String actualResponseValue = result.getBody().jsonPath().getString(testData.get("expectingKey"));

		Assert.assertEquals("****fail" + result.getBody().asString(), testData.get("expectingValue"),
				actualResponseValue);
	}

}
