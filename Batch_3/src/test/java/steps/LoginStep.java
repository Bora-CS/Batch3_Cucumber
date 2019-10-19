package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver;
	
	@Given("user in the Homapage")
	public void user_in_the_Homapage() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com");

	}

	@When("user click on SignIn button")
	public void user_click_on_SignIn_button() {
		System.out.println("I click the signIn button");
	}

	@Then("SignIn page display")
	public void signin_page_display() {

	}

	@Then("email address textbox display")
	public void email_address_textbox_display() {

	}

	@Then("End the test")
	public void end_the_test() {

		driver.close();
		driver.quit();
	}

	
	
	
	
	
	@Then("enter correct email")
	public void enter_correct_email() {

	}

	@Then("enter correct password")
	public void enter_correct_password() {

	}
	
	@Then("enter email {string}")
	public void enter_email(String email) {
	
		System.out.println("email address is: "+email);
	}

	@Then("enter password {string}")
	public void enter_password(String password) {
		System.out.println("password  is: "+password);
	}

}
