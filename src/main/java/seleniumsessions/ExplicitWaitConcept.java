package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {
	
	static WebDriver driver;
	public static void main(String[] args){
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
			3.	Wait 5 seconds for "E-Mail Address" element to be loaded completely. And send some keys
			Test_data: Sabawoon.S_Tech@gamil.com
			4.	Send some keys at "Password" input field.
			Test_data: S_Automation$$$
			5.	Click on "Login" button. (create this element using driver.findElement) 
			6.	Create a utility for explicit wait, so you don’t need to repeat the wait code when needed to apply the 
				wait for other elements.
			7.	Using the utility wait for "About Us" link for seconds to be loaded and then click on it.
		 */
		
		// Explicit wait 
		//Explicit wait is only a concept of dynamic wait for the specific web element & non-webelement 
		// on the basis of some condition
		
//		Wait (I) until() <---- FluentWait (Class) until() {} + other methods <---- WebDriverWait (Class)
		
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By login = By.xpath("//input[@value='Login']");
		By aboutUsLink = By.linkText("About Us");
		
		// Creation of login element using driver.findElement()
		WebElement logiin = driver.findElement(login);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		email_ele.sendKeys("S_Tech@gmail.com");
		
		driver.findElement(password).sendKeys("S_Automation$$$");
		driver.findElement(login).click();
		
//		wait.until(ExpectedConditions.elementToBeClickable(logiin));

		waitForPresenceOfElement(aboutUsLink, 5).click();
		
	}
	
	// ************** Utility Creation *************//
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. This does not necessarily mean that 
	 * the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return web element
	 */
	public static WebElement waitForPresenceOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return web element
	 */
	public static WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return web elements
	 */
	public static List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
	/**
	 * An expectation for checking that there is at least one element present on a web page.
	 * @param locator
	 * @param timeOut
	 * @return web element
	 */
	public static List<WebElement> waitForPresenceOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	// Using the above generics to create some actions generics like: click, sending keys ..
	
	public static void doClickWithWait(By locator, int timeOut) {
		waitForVisibilityOfElement(locator, timeOut).click();
	}
	
	public static void doSendKeysWithWait(By locator, String value, int timeOut) {
		waitForVisibilityOfElement(locator, timeOut).sendKeys(value);
	}
	
	
}
