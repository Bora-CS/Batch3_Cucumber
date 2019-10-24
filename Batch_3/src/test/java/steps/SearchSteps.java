package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilityLibrary.Library;

public class SearchSteps extends Library{

	@When("user type {string} in the searchBox")
	public void user_type_in_the_searchBox(String searchTerm) {

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchTerm);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		
	}

	@Then("user should able to land on search result page")
	public void user_should_able_to_land_on_search_result_page() {

		String title = driver.getTitle();
		System.out.println("we are land on SRP : " + title);
	}

	@Then("search result should match {string}")
	public void search_result_should_match(String searchResult) {
		String result = driver.findElement(By.xpath("(//*[contains(@class,'a-spacing-top-small')]/span)[1]")).getText();
		
		Assert.assertTrue("Fail due to search result not match : "+result, result.contains(searchResult));
	}

}
