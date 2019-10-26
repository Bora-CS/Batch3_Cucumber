package steps;

import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import utilityLibrary.Library;

public class ProductDetailPage extends Library{

	

	@Then("user click on first prodcut")
	public void user_click_on_first_prodcut() {
			System.out.println("This is in the Step PDP page");
			Assert.fail();
	}

	@Then("user land on product detail page")
	public void user_land_on_product_detail_page() {
		System.out.println("This is in the Step PDP page");
	}
	
}
