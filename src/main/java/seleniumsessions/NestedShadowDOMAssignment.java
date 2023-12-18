package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NestedShadowDOMAssignment {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		driver = new ChromeDriver();
//		driver.get("https://books-pwakit.appspot.com/");
//		Thread.sleep(3000);
//		
//		String search_book = "return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")";
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		
//		//HTML Element --- Selenium Element 
//		WebElement search = (WebElement)js.executeScript(search_book);
//		search.sendKeys("Harry potter");
//		search.sendKeys(Keys.ENTER);
//		driver.close();
		
		// *************** 2nd Assignment ******************//
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to "chrome://settings/appearance/"
			3.	Activate "Show home button"
			4.	Hit enter
			5.	Close the driver
		 */
		driver = new ChromeDriver();
		driver.get("chrome://settings/appearance/");		
		Thread.sleep(3000);
		
		String showHomeButton_script = "return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector"
				+ "(\"#main\").shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > "
				+ "settings-section:nth-child(18) > settings-appearance-page\").shadowRoot.querySelector(\"#pages > div > "
				+ "settings-toggle-button:nth-child(4)\").shadowRoot.querySelector(\"#control\").shadowRoot"
				+ ".querySelector(\"#knob\")";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//	HTML element --- Selenium web element
		WebElement buttonClick = (WebElement)js.executeScript(showHomeButton_script);
		buttonClick.click();
		driver.close();
		
	}
}
