package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NullValueWithSendKeys {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html
			3.	Pass "null" values to the "First name" input field. 
			4.	Close the browser.
		 */
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		WebElement firstName = driver.findElement(By.cssSelector("input#fname"));
//		firstName.sendKeys(null); // IllegalArgumentException
		
		Actions act = new Actions(driver);
		act.sendKeys(firstName, null);  // IllegalArgumentException
		
	}

}

