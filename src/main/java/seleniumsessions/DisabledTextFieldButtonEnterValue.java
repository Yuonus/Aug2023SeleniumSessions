package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DisabledTextFieldButtonEnterValue {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html
			3.	Pass some values to the disabled "Password(disable)" input field. "S_Tech119$$"
			4.	Close the browser.
		 */
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		WebElement password = driver.findElement(By.cssSelector("input#pass"));
//		password.sendKeys("S_Tech119$$"); // with Normal sendKeys --> ElementNotInteractableException
		
		Actions act = new Actions(driver);
//		act.sendKeys("S_Tech119$$").perform(); // With Actions class no Exception.   Or 
		act.sendKeys(password, "S_Tech119$$").build().perform();
		
		driver.close();
		
	}
}
