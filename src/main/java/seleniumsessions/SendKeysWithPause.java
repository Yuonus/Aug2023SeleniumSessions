package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPause {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
			3.	Send these keys into the "E-Mail Address" input field. "S_Tech@gmail.com", as long as there is 
				half second pause between each letter being passed to input field. 
			4.	Send these keys into the "Password" input field. "SabawoonAutomation119$", as long as there is half 
				second pause between each letter being passed to password input field. 
			5.	Click on "Login"
			6.	Close the driver.
			7.	Develop a utility for it.
		*/
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Actions act = new Actions(driver);
		
		//################ Rough Code Approach ###############//
//		WebElement userName = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		String value = "S_Tech@gmail.com";
//		char val[] = value.toCharArray();
//		for(char c : val) {
//			act.sendKeys(userName, String.valueOf(c)).pause(500).build().perform();
//		}
//		
//		String pValue = "SabawoonAutomation119$";
//		char pVal[] = pValue.toCharArray();
//		for(char c : pVal) {
//			act.sendKeys(password, String.valueOf(c)).pause(500).build().perform();
//		}
//		act.click(driver.findElement(By.xpath("//input[@value='Login']"))).perform();
//		driver.close();
		
		//******************* Utility Approach **********************//
		By userName = By.id("input-email");
		By password = By.id("input-password");
		
		String value = "S_Tech@gmail.com";
		String pValue = "SabawoonAutomation119$";

		
		doActionsSendKeysWithPause(userName, value);
		doActionsSendKeysWithPause(password, value);
		
		driver.close();  
	}
	
	//*************** Utility Method *****************//
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeysWithPause(By locator, String value) {
		Actions act = new Actions(driver);
		char val[] = value.toCharArray();
		for(char c : val) {
			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();
		}
	}

}
