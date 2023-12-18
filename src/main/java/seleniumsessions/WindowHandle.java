package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Launch the browser
			2.	Open the URL https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
			3.	Create a new window/tab
			4.	Open https://www.google.com/ in new window
			5.	Capture the title of the new window
			6.	Close the tab/window.
			7.	Bring the driver back to the parent window, as it is lost after closing the child window.
			8.	Verify if you are on the parent window or not.
			9.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parentWindowId = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB); // will be opened with the parent window 
//		driver.switchTo().newWindow(WindowType.WINDOW); Will be opened in an absolute new window 

		driver.get("https://www.google.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Newly opened page title is: " + pageTitle);
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		String parentWindowTitle = driver.getTitle();
		System.out.println("Parent window title is: " + parentWindowTitle);
		if(parentWindowTitle.equals("OrangeHRM")) {
			System.out.println("Test --- PASS");
		}else {
			System.out.println("Test --- FAIL");
		}
		
		driver.close();
	}

}
