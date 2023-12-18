package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUp {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://the-internet.herokuapp.com/basic_auth
			3.	Pass the username and password
			4.	Capture the page URL, and print it to the console
			5.	Capture the page title, and print it to the console
			6.	Verify if your credentials are correct or not.
			7.	Close the driver
		 */
		
		driver = new ChromeDriver();
		
		// Hard Coded Approach
//		adding the username and password to the url --> driver.get("https://the-internet.herokuapp.com/basic_auth");
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
//		Passing the value Approach
		String userName = "admin";
		String password = "admin";
		
		driver.get("https://"+userName+":" +password+"@" + "the-internet.herokuapp.com/basic_auth");
		String pageURL = driver.getCurrentUrl();
		System.out.println("The page URL is: " + pageURL);
		String pageTitle = driver.getTitle();
		System.out.println("The page title is: " + pageTitle);
		String text = driver.findElement(By.tagName("p")).getText().trim();
		System.out.println("The verification Text for proper credentials on the page is: " + text);
		
		if(text.equals("Congratulations! You must have the proper credentials.")) {
			System.out.println("Test --- PASS");
		}else {
			System.out.println("Test --- FAIL");
		}
		driver.close();
	}

}
