package utilityLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class Library {
	public static WebDriver driver;

	
	public void user_in_the_Homapage() {
	   System.out.println("I am in the Homepage");
	   System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
	   driver = new ChromeDriver();
	   driver.get("https://www.amazon.com");
	   try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
}
