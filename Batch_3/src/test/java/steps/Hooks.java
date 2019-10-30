package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilityLibrary.Library;

public class Hooks extends Library{


	public void testBefore() {
		System.out.println("This is Cucumber before method");
	}

	public void testAfter() {
		System.out.println("This is Cucumber after method");
		if(driver!=null) {
			driver.quit();
		}
	}
	
}
