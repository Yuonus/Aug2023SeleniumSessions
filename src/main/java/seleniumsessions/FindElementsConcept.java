package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {
	/*				Test Scenario
	 	1: Launch the Browser
	 	2: Launch the URL. "https://naveenautomationlabs.com/opencart/index.php?route=account/register"
	 	3: Verify how many text fields are there in registration page? or / On the registration page, 
	 		capture all the text fields. 
	 */

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		List<WebElement> textFieldList = driver.findElements(By.className("form-control"));
		System.out.println("Number of Text fields on Registration page are: " + textFieldList.size());
		
	}
}
