package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;
import utilityLibrary.Library;

public class ProductListPage extends Library{

	
	@Then("verify sort functionality by {string}")
	public void verify_sort_functionality_by(String sortType) throws InterruptedException {
	   
		String firstName = getText(By.xpath("//a[@class='a-link-normal a-text-normal']"));
		
		WebElement dropdown = driver.findElement(By.id("s-result-sort-select"));
		Select myselect = new Select(dropdown);
		switch(sortType) {
		case "lowToHigh":
			myselect.selectByValue("price-asc-rank");
			break;
		case "hithToLow":   //will fail here later
			myselect.selectByValue("price-desc-rank");
			break;
		default:
			System.out.println("Given Sort type is missmatch: "+sortType);
		}
		
		Thread.sleep(5000);
		
		String secondName = getText(By.xpath("//a[@class='a-link-normal a-text-normal']"));
		
		Assert.assertNotEquals("Product doesn't change after sort by: "+sortType, secondName, firstName);
	}
	
	
	
	
	
	
	
	
	
	
	
}
