package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Open the browser
			2.	Navigate to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
			3.	Notice at the social media links at the end left corner.
			4.	Click on "twitter" icon
			5.	Fetch the window IDs
			6.	Start switching between the Windows
			7.	Print the URL and page titles of both parent and child windows
			8.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		
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
		
//		After closing the child window the driver is lost, we have to bring it back to the parent window
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window URL is: " + driver.getCurrentUrl());
		System.out.println("Parent window title is: " + driver.getTitle());
		driver.quit();
		
		
		// set cannot contain duplicate values, it is not maintaining an order based collection like lists. 
		// it is non-ordered based collection
		
	}
	
//	/*
//	 * Navigate to the URL "https://www.selenium.dev/documentation/webdriver/browser/windows/"
//	 * Get the current window id / handle
//	 * Click on the "new window" link
//	 * Wait for 10 seconds, so the second window could pop up
//	 * Now get the id Of the child  window using this method (driver.getWindowHandles();). And save it in a "set". 
//	 * Loop through the Variable of the Set and get the id of the Child window.
//	 * Verify that you are on the Child window.
//	 * Close the Child window, after you are done.
//	 * Get the focus of the driver back to the Parent window, and verify that you are on the parent window. (Switch back to the parent window)
//	 * 
//	 */
//	
//	public static void letsHandlesWindows() {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.get("https://www.selenium.dev/documentation/webdriver/browser/windows/");
//		
//		// get the current window id / handle 
//		String parentWindowID = driver.getWindowHandle();
//		System.out.println("Parent window ID: " + parentWindowID);
//		
//		// click on the new window link
//		driver.findElement(By.linkText("new window")).click();
//		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//		
//		Set<String> windowIDs = driver.getWindowHandles();
//		
//		// loop through the set of ids and when it's not equal to parent window id,
//		// then switch to new window
//		
//		for (String windowid : windowIDs) {
//			if (!parentWindowID.equals(windowid)) {
//				driver.switchTo().window(windowid);
//				break;
//			}
//			System.out.println("Child window ID is: " + windowid);
//		}
//		
//		String newWindowText = driver.findElement(By.xpath("//h4[@class='alert-heading pb-2 text-center']")).getText().trim();
//		String text = "Selenium Conference Chicago 2023";
//		if (newWindowText.equals(text)) {
//			System.out.println("You are on the Child window, and its text is: " + newWindowText);
//		}else {
//			System.out.println("You have not landed the child window.");
//		}
//		
//		driver.close();
//		
//		driver.switchTo().window(parentWindowID);
//		if(driver.getWindowHandle().equals(parentWindowID)) {
//			System.out.println("You are on the parent window.");
//		}else {
//			System.out.println("You are not on the parent window.");
//		}
//	}


}
