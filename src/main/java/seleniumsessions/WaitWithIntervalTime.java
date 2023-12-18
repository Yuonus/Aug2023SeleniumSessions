package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWithIntervalTime {
	static WebDriver driver;
	public static void main(String[] args){
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
			3.	Wait 10 seconds for "E-Mail Address" element to be loaded completely. And send some keys. 
				Give an interval time of 2 seconds for each attempt
				Test_data: Sabawoon.S_Tech@gamil.com
			4.	Repeat step # 3 with default polling time, and observe the output
			5.	To observe the output of default polling and custom polling time through fluent wait, make the value of the "E-Mail Address" element locator wrong
			6.	Create a utility for it and move it to the ElementUtil class
			7.	Close the browser

		 */

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By login = By.xpath("//input[@value='Login']");
		By aboutUsLink = By.linkText("About Us");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(emailId)).sendKeys("sabawoon.S_Tech@gmail.com");
//		driver.close();
		
		waitForPresenceOfElement(password, 10, 4).sendKeys("password");
		
	}
	
	public static WebElement waitForPresenceOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
