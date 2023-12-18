package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteAsyncScriptScroll {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
		 Using the "executeAsyncScript" method scroll down to the bottom of a webpage.
			1.	Launch the browser
			2.	Navigate to https://www.amazon.com/
			3.	Wait for 2 seconds. --> for visibility purpose
			4.	Scroll all the way to the end of the page using "executeAsyncScript".
			5.	Close the browser.
		 */
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000); // Wait time is added to see the scrolling down
		js.executeAsyncScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.close();
	}

}
