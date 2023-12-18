package seleniumsessions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {
	static WebDriver driver;
	public static void main(String[] args){
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
			3.	Wait 10 seconds for "E-Mail Address" element to be loaded completely with 2 seconds polling frequency. 
				And send some keys
					Test_data: Sabawoon.S_Tech@gamil.com
			4.	Send some keys at "Password" input field.
				Test_data: S_Automation$$$
			5.	Click on "Login" button. 
			6.	Close the browser
		 */
	
		//Wait (I) until() <---- FluentWait (Class) until() {} + other methods <---- WebDriverWait (Class)
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By login = By.xpath("//input[@value='Login']");
		By aboutUsLink = By.linkText("About Us");
		
		/*		Top Casting
		 * Child class object referred by parent interface reference variable
		 */
		
		// ************* ROUGH CODE APPROACH
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))	// --> Total Timeout
//				.pollingEvery(Duration.ofSeconds(2))	// --> Custom Polling/Interval time
//				.withMessage("-- Timeout is done ... Element is not found ...") // Sets the message to be displayed when time expires
//				.ignoring(NoSuchElementException.class); // ignoring the exception
////	Note: You can add different other exceptions to ignore, like: for alerts, windows ...
//		wait.until(ExpectedConditions.visibilityOfElementLocated(emailId)).sendKeys("Sabawoon.S_Tech@gamil.com");
//		driver.findElement(password).sendKeys("S_Automation$$$");
//		driver.findElement(login).click();
//		driver.findElement(aboutUsLink).click();
//		driver.close();
		
		// ************ Utility Approach *************//
		waitForElementWithFluentWait(emailId, 10, 2).sendKeys("Sabawoon.S_Tech@gamil.com");
		// Do not add wait for the following elements
		driver.findElement(password).sendKeys("S_Automation$$$");
		driver.findElement(login).click();
		driver.findElement(aboutUsLink).click();
	}
	
	//***************** Utility *********************//
	
	public static WebElement waitForElementWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(intervalTime))	
				.withMessage("-- Timeout is done ... Element is not found ...") 
				.ignoring(NoSuchElementException.class); 
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
