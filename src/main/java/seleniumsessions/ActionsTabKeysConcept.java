package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTabKeysConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register 
			3.	Fill the registration form as there should be half second wait between each input fields.
				Like fill the first Name input field, wait for half second and then fill the last name 
				and respective text fields.
			4.	Conditions:
					--> Don’t use By locators / Web elements
					--> You can only use one web element / By locator
			5.	Close the driver.
		*/
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement firstName = driver.findElement(By.cssSelector("input#input-firstname"));
		Actions act = new Actions(driver);
		act.sendKeys(firstName, "Sabawoon")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("Yuonus")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("S_Tech@gmail.com")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("202-735-****")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("Test@119$")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys("Test@119$")
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys(Keys.TAB)
					.pause(500)
					.sendKeys(Keys.TAB)
					.pause(500).build().perform();
//		You can keep continue tabing and it will keep tabing in the UI.
					
		
		
		
		
	}

}
