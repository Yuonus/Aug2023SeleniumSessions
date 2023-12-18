package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasics {

	static WebDriver driver;
	public static void main(String[] args) {
		
		/*
		 *  1. Open the browser  --> I want to use Chrome
		 *  2. Enter URL
		 *  3. Get the Title
		 *  4. Verify the title --> Actual vs Expected
		 *  5. Close the browser
		 */
		
		// Automation Steps
//		ChromeDriver driver = new ChromeDriver(); // Chrome
//		FirefoxDriver driver = new FirefoxDriver(); // Firefox
//		EdgeDriver driver = new EdgeDriver(); // Edge 
		
		String browser = "chrome";
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser ...");
			break;
		}
		driver.get("https://www.google.com");
		String actTitle = driver.getTitle();
		System.out.println("Title is: " + actTitle);
		
		// Verification point/ check point/ Actual Vs Expected result: Testing
		if(actTitle.equals("Google")) {
			System.out.println("Title is correct -- PASS");
		}
		else {
			System.out.println("Title is incorrect -- FAIL ");
		}
		// Automation Steps + Verification Points = Automation Testing
	
		//GetCurrentUrl method
		String appUrl = driver.getCurrentUrl();
		if(appUrl.contains("google")) {
			System.out.println("URL is correct --- PASS");
		}
		
		System.out.println("================================================================================");
		System.out.println("================================================================================");
		System.out.println("================================================================================");
		
		// getPageSource method
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		if(pageSource.contains("Google apps")) {
			System.out.println("Pass");
		}

		driver.close();
	}
	
		/*
		Can selenium launch a URL without a protocol (HTTPS or HTTP)?
		Ans: No. selenium cannot launch a URL without a protocol. If you try to launch a URL without protocol, Selenium will throw Invalid Argument Exception org.openqa.selenium.InvalidArgumentException.
		Can selenium launch a URL without (www)?
		Ans: Yes. Selenium can launch a URL without WWW.
		*/


}
