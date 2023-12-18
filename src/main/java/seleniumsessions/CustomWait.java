package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
	static WebDriver driver;
	public static void main(String[] args) {
		
		/*		Business Case
			1.	Create the utility
			2.	Launch the browser
			3.	Navigate to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
			4.	Give a 10 seconds of custom wait timeOut for the element, then click on "Forgot your password? "
			5.	Don’t forget to move the utilities into ElementUtil class.
			
		Note:
		To show the exception happening, you will have to add some extra character to the xpath value.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// Page load verification
		if(isPageLoaded(10)) {
			System.out.println("Page is fully loaded.");
		}
		
		By forgotPwd = By.xpath("//p[text()='Forgot your password? 90']");
		
		// Default polling time
//		retryingElement(forgotPwd, 10).click();
		
		//Custom polling time
		retryingElement(forgotPwd, 10, 2000).click();
		
	}
	
	// Base Method
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement retryingElement(By locator, int timeOut) {
		
		WebElement element = null;
		int attempts = 0;
		
		while(attempts < timeOut) {
			try {
				element = getElement(locator);
				System.out.println("Element is found ... " + locator + " in attempt " + attempts);
				break;
			}
			catch(NoSuchElementException e) {
				System.out.println("Element is not found ... " + locator + " in attempt " + attempts);
				try {
					Thread.sleep(500); // Default Polling time after each attempts
				} catch (InterruptedException e1) {
					e1.printStackTrace();// to show where the exception come from
				}
			}
			attempts++;
		}
		
		if(element == null) {
			System.out.println("Element is not found ... tried for " + timeOut + " times " + 
					" with the interval of " + 500 + " milli seconds ");
			throw new AutomationException("No Such Element");
		}
		return element;
		
	}
	
	// If the user want to supply his/her own polling/sleep time, then we can overload the above method.
//	as the above method is having default polling frequency/time of 500 milli seconds.
	
	public static WebElement retryingElement(By locator, int timeOut, int intervalTime) {
		
		WebElement element = null;
		int attempts = 0;
		
		while(attempts < timeOut) {
			try {
				element = getElement(locator);
				System.out.println("Element is found ... " + locator + " in attempt " + attempts);
				break;
			}
			catch(NoSuchElementException e) {
				System.out.println("Element is not found ... " + locator + " in attempt " + attempts);
				try {
					Thread.sleep(intervalTime); // Custom Polling time after each attempts
				} catch (InterruptedException e1) {
					e1.printStackTrace();// to show where the exception come from
				}
			}
			attempts++;
		}
		
		if(element == null) {
			System.out.println("Element is not found ... tried for " + timeOut + " times " + 
					" with the interval of " + intervalTime + " milli seconds ");
			throw new AutomationException("No Such Element");
		}
		return element;
	}
	
	// *** Generic method for page loaded state ****//
	
	public static boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'")).toString();
//		 the String flag needs to be converted to boolean using wrapper Boolean. Why do we change to boolean?
//		because the return of this JS "return document.readyState === 'complete'" is JS true, so our method should also return
//		a java true or false. that is why we first change the Javascript boolean into java String using toString(), and
//		then converted the String into java boolean.
		return Boolean.parseBoolean(flag);
	}
	
}
