package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollToViewElementJS {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://classic.freecrm.com/
			3.	Scroll down to "Calls & Voice"
			First you will need create a web element for it.
			4.	Close the browser
			5.	use the method from Utility 
		 */
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		Thread.sleep(1500);

		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		WebElement callingElement = driver.findElement(By.xpath("//h3[normalize-space()='Calls & Voice']"));
		jsUtil.scrollIntoView(callingElement);
		
		driver.close();
		
	}

}
