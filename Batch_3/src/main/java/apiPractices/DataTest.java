package apiPractices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataTest {

	public static void main(String[] args) {
		
		for(HashMap temp: readData()) {
			System.out.println("map in main method: "+temp.toString()+"\n");
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

}
