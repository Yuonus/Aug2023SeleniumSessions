package seleniumsessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForBrowserWindow {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Open the browser
			2.	Navigate to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login 
			3.	Notice the social media links at the end left corner.
			4.	Wait 10 seconds for "twitter" to be completely loaded and then click on "twitter" icon
			5.	Wait 10 seconds for "twitter" window to be completely loaded. *** Here the internal switching 
				between windows will not happen. The numberOfWindowsToBe() method will return the boolean, so we can 
				place it inside the if condition.
			6.	Fetch the window IDs
			7.	Start switching between the Windows
			8.	Print the URL and page titles of both parent and child windows
			9.	Close the browser.
		 */

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		By twitter = By.xpath("//a[contains(@href,'twitter')]");
		
		waitForVisibilityOfElement(twitter, 10).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Rough Code
//		if(wait.until(ExpectedConditions.numberOfWindowsToBe(2))) { // Rough Code
		// Note: All the code from line 45 - 65 is shared between both Rough and Utility Approach
		if(checkNewWwindowExist(5, 2)) { // Generic Method
		
		// 1. Fetching Window IDs
				Set<String> handles = driver.getWindowHandles();
				Iterator<String> it = handles.iterator(); // import Iterator from java
				String parentWindowId = it.next();
				System.out.println("Parent window ID is: " + parentWindowId);
				
				String childWindowId = it.next();
				System.out.println("Child Window ID is: " + childWindowId);
				
				// 2. Switching work
				driver.switchTo().window(childWindowId);
				System.out.println("Child window URL is: " + driver.getCurrentUrl());
				System.out.println("Child window title is: " + driver.getTitle());
				driver.close();  // remember not to use driver.quit() here.
				
//				After closing the child window the driver is lost, we have to bring it back to the parent window
				
				driver.switchTo().window(parentWindowId);
				System.out.println("Parent window URL is: " + driver.getCurrentUrl());
				System.out.println("Parent window title is: " + driver.getTitle());
				driver.quit();
				
		}	
		
	}
	
	//****************** Generic Methods **********************//
	
	public static WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static boolean checkNewWwindowExist(int timeOut, int expectedNumberOfWindows) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows))) {
				return true;
			}
		}catch (TimeoutException e) {
			System.out.println("Number of windows are not the same ...");
		}
		return false;
	}
	

}
