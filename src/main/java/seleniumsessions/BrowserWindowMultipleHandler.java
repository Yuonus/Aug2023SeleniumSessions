package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowMultipleHandler {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Open the browser
			2.	Navigate to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
			3.	Notice at the social media links at the end left corner.
			4.	Open all the social media links
			5.	Fetch the window IDs
			6.	Start switching between the Windows
			7.	Print the URL and page titles of both parent and child windows
			8.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String parentWindowId = driver.getWindowHandle();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click();
		
		// First Approach Lengthy way, Using it.next()
		// 1. Fetching IDs
//		Set<String> handles = driver.getWindowHandles();
//		Iterator<String> it = handles.iterator();
//		
//		String parentWindowID = it.next();
//		System.out.println("Parent window Id is: " + parentWindowID);
//		
//		String child1WinID = it.next();
//		System.out.println("Child 1 window Id is: " + child1WinID);
//		
//		String child2WinID = it.next();
//		System.out.println("Child 2 window Id is: " + child2WinID);
//		
//		String child3WinID = it.next();
//		System.out.println("Child 3 window Id is: " + child3WinID);
//		
//		String child4WinID = it.next();
//		System.out.println("Child 4 window Id is: " + child4WinID);
//		
//		// 2. Switching work
//		driver.switchTo().window(child1WinID);
//		System.out.println("Child 1 window URL is: " + driver.getCurrentUrl());
//		System.out.println("Child 1 window title is: " + driver.getTitle());
//		driver.close();
//		
//		driver.switchTo().window(child2WinID);
//		System.out.println("Child 2 window URL is: " + driver.getCurrentUrl());
//		System.out.println("Child 2 window title is: " + driver.getTitle());
//		driver.close();
//		
//		driver.switchTo().window(child3WinID);
//		System.out.println("Child 3 window URL is: " + driver.getCurrentUrl());
//		System.out.println("Child 3 window title is: " + driver.getTitle());
//		driver.close();
//		
//		driver.switchTo().window(child4WinID);
//		System.out.println("Child 4 window URL is: " + driver.getCurrentUrl());
//		System.out.println("Child 4 window title is: " + driver.getTitle());
//		driver.close();
//		
//		driver.switchTo().window(parentWindowID);
//		System.out.println("Parent window URL is: " + driver.getCurrentUrl());
//		System.out.println("Parent window title is: " + driver.getTitle());
//		driver.close();
		
		// Second Approach: Short way using loop
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			Thread.sleep(1500); // Just added to see closing the window after one and half second wait
			
			if(!windowId.equals(parentWindowId)) {
				driver.close();
			}
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window URL is: " + driver.getCurrentUrl());
			
		}

	}

}
