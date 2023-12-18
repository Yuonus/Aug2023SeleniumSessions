package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingBorderAroundEle {
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			
			/*		Business Case
				1.	Launch the browser
				2.	Navigate to https://classic.freecrm.com/
				3.	Create a border around "Calls & Voice" web element.
				First you will need create a web element for it.
				4.	Close the browser
				5.	Create a Utility for it.
			 */
			
//			driver = new ChromeDriver();
//			driver.get("https://classic.freecrm.com/");
//			Thread.sleep(1500);
//
//			JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//			
//			WebElement callingElement = driver.findElement(By.xpath("//h3[normalize-space()='Calls & Voice']"));
////			jsUtil.scrollIntoView(callingElement);
//			jsUtil.drawBorder(callingElement);
//			driver.close();
			
			/*		Business Case		--> Assignment
				1.	Launch the browser
				2.	Navigate to https://app.hubspot.com/login 
				3.	Draw the border from the whole login form
				4.	Close the browser
			 */
			
//			driver = new ChromeDriver();
//			driver.get("https://app.hubspot.com/login");
//			Thread.sleep(1500);
//
//			JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//			WebElement loginForm = driver.findElement(By.id("hs-login"));
//			jsUtil.drawBorder(loginForm);
			
			//**************** Highlighting Web elements **********//
			
			/*		Business case
				1.	Launch the browser
				2.	Navigate to https://app.hubspot.com/login 
				3.	Highlight the "Email address" & "Password" input fields with green color
				4.	Close the browser

			 */
			
//			driver = new ChromeDriver();
//			driver.get("https://app.hubspot.com/login");
//			Thread.sleep(1500);
//			
//			JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//			
//			WebElement emailAdd = driver.findElement(By.cssSelector("input#username"));
//			WebElement password = driver.findElement(By.cssSelector("input#password"));
//			
//			jsUtil.falsh(emailAdd);
//			emailAdd.sendKeys("syuonus@gmail.com");
//			jsUtil.falsh(password);
//			password.sendKeys("S_Tech$$$119");
			
			// 2nd Assignment
//			1.	Launch the browser
//			2.	Navigate to https://app.hubspot.com/login 
//			3.	Highlight the "Login form" completely
//			4.	Close the browser
			
//			driver = new ChromeDriver();
//			driver.get("https://app.hubspot.com/login");
//			Thread.sleep(1500);
//			
//			JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//			
//			WebElement loginForm = driver.findElement(By.cssSelector("form#hs-login"));
//			jsUtil.falsh(loginForm);
			
			
			// **************** Highlighting / Changing Element background Color ******//
			
			/*		Business Case
				1.	Launch the browser
				2.	Navigate to https://app.hubspot.com/login 
				3.	Highlight the "Email address" & "Password" input fields with beige color for Email text field and
					yellow for password text field
				4.	SendKeys to both input fields after flashing/blinking
				5.	Close the browser
			 */
			
//			driver = new ChromeDriver();
//			driver.get("https://app.hubspot.com/login");
//			Thread.sleep(1500);
//			
//			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
//			WebElement emailAdd = driver.findElement(By.cssSelector("input#username"));
//			jsExecutor.executeScript("arguments[0].style.background='beige'", emailAdd);
//			emailAdd.sendKeys("syuonus@gmail.com");
//			
//			WebElement password = driver.findElement(By.cssSelector("input#password"));
//			jsExecutor.executeScript("arguments[0].style.background='yellow'", password);
//			password.sendKeys("success_Guarantedd with S_Tech");
//			driver.close();
			
			// ***** Highlighting and Drawing the border at the same time around an Element ********//
			
			/*		Business Case
				1.	Launch the browser
				2.	Navigate to https://app.hubspot.com/login 
				3.	Highlight the "Email address" & "Password" input fields. Orange color for "Email address" background 
					and turquoise color for its border & yellow color for "Password" and pink color for its border.
				4.	SendKeys to both input fields after highlighting/changing the background color
				5.	Close the browser
			 */
			
			driver = new ChromeDriver();
			driver.get("https://app.hubspot.com/login");
			Thread.sleep(1500);
			
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			WebElement emailAdd = driver.findElement(By.cssSelector("input#username"));
			jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:6px solid turquoise; background:orange')", emailAdd);
			emailAdd.sendKeys("syuonus@gmail.com");
			
			WebElement password = driver.findElement(By.cssSelector("input#password"));
			jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:6px solid pink; background:yellow')", password);
			password.sendKeys("success_Guarantedd with S_Tech");
			
		}	
}
