package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSessionId {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String actTitle = driver.getTitle();
		System.out.println("Title is: " + actTitle);
//		driver.quit();
		driver.close();
		
//		driver.get("https://www.google.com");  
		/*
		  After closing/quitting the driver we will not be able to perform any web actions.
		  it will throw NoSuchSessionException at line number 15 and the Session ID will be null.
		  org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		   			driver.close();
		   	in case of driver.close(), it will throw:
		   	Exception in thread "main" org.openqa.selenium.NoSuchSessionException: invalid session id
		 */
		
	// In order to salve this issue we will have to Re-launch the browser.
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		
	}
}
