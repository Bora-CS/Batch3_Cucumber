package utilityLibrary;

import org.openqa.selenium.By;
import org.junit.After;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Library {
	public static WebDriver driver;

	public Library() {
		if (driver == null) {
			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				// For Mac user
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			} else {
				// For Windows user
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			}
			driver = new ChromeDriver();

		}
	}

	public void endTest() {
		driver.close();
		driver.quit(); // driver is not != null
		driver = null;
	}

	public String getText(By locator) {
		String text = driver.findElement(locator).getText();
		return text;
	}

}
