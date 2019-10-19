package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver;

	@Given("user in the Homapage")
	public void user_in_the_Homapage() {
		// For Mac user
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		// For Windows user
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		driver.manage().window().fullscreen();
		waitTime();
	}

	public void waitTime() {
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("user click on SignIn button")
	public void user_click_on_SignIn_button() {
		System.out.println("I click the signIn button");

		driver.findElement(By.id("nav-link-accountList")).click();

		waitTime();
		int size = driver.findElements(By.xpath("//*[@id='nav-flyout-ya-signin']/a")).size();
		if (size != 0) {
			driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a")).click();
		}

	}

	@Then("SignIn page display")
	public void signin_page_display() {
		String actualTitle = driver.getTitle();
		String expectingTitle = "Amazon Sign-In";

		Assert.assertEquals(actualTitle, expectingTitle);

	}

	@Then("email address textbox display")
	public void email_address_textbox_display() {

		int size = driver.findElements(By.id("ap_email")).size();
		Assert.assertTrue("Email Address box is not display in the page!", size > 0);
	}

	@Then("End the test")
	public void end_the_test() {
		driver.close();
		driver.quit();
	}

	@Then("enter email {string}")
	public void enter_email(String email) {

		System.out.println("email address is: " + email);
		driver.findElement(By.id("ap_email")).sendKeys(email);
		driver.findElement(By.id("continue")).click();
	}

	@Then("enter password {string}")
	public void enter_password(String password) {
		System.out.println("password  is: " + password);
	}

}
