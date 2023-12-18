package seleniumsessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptExecutorConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		// Rough Code calling/invoking
//		task1();
//		task2_Alert();
//		task3_Confirm();
//		task4_Prompt();
//		navigationReloadingWithJS();
		wholePageElementText();
		

		
		// ************** JavaScriptUtil methods calling *********************//
//		driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//		
//		//******* Task 1 *********************//
//		String title = jsUtil.getTitleByJs();
//		System.out.println(title);
//		
//		String url = jsUtil.getURLByJs();
//		System.out.println(url);
		
		// ************* task2_Alert() ************//
//		jsUtil.generateJsAlert("Hello S_Tech heros");
		
		// ************task3_Confirm *****************//
//		jsUtil.generateJsConfirm("Are you sure you want to give up on your dreams");
		
		// ***************** task4_Prompt *************//
//		jsUtil.generateJsPrompt("Enter your Goal", "I want to be the strongest SDET after 6 months.");
		
	}
	
	
	//*********** Rough Code Methods
		
	
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
			3.	Capture the page title using Javascript executor
			4.	Capture the page URL using Javascript executor
			5.	Create Utilities for both title & URL 
		 */
		
		// JavaScriptExecutor	--- Interface
		// RemoteWebDriver implements JavaScriptExecutor
		// JavaScriptExecutor	--> executeScript(script)
		// Script	--> execute(script)  -- it will be executed on the browser / page
	public static void task1() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		String title = js.executeScript("return document.title").toString();
		String pageURL = js.executeScript("return document.URL").toString();
		System.out.println("Page title is: " + title);
		System.out.println("Page URL is: " + pageURL);
		
		// Document is the internal object on the browser.
	}
	/*		Business Case
		1.	Launch the browser
		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
		3.	Generate an alert window using JavascriptExecutor.
		4.	Supply this given message to your JavaScript alert. "Hello S_Tech"
		5.	Create a utility for it as well.
	 */
	public static void task2_Alert() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("alert ('Hello S_Tech')");
	}
	
	/*		Business Case
		1.	Launch the browser
		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
		3.	Generate a confirm window using JavascriptExecutor.
		4.	Supply this given message to your JavaScript alert. "Are you sure you want to give up on your dreams"
		5.	Create a utility for it as well.
	 */
	public static void task3_Confirm() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("confirm ('Are you sure you want to give up on your dreams')");
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
//		alert.accept();  // accepting the alert
		alert.dismiss(); // dismissing the alert
	}
	
	public static void task4_Prompt() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("prompt ('Enter your goal')");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("I want to be the strongest SDET after 6 months");
		Thread.sleep(2000);
//		alert.accept();  // accepting the alert
		alert.dismiss(); // dismissing the alert
	}
	
	/*		Business Case
		1.	Launch the browser
		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
		3.	Navigate back and forward.
		4.	Reload the page
		5.	Close the browser.
		6.	Create Utilities for each of them.
	 */

	public static void navigationReloadingWithJS() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("history.go(-1)");
		js.executeScript("history.go(1)");
		js.executeScript("history.go(0)");
	}
	
	/*			Business Case
		1.	Launch the browser
		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
		3.	Capture the text of whole page elements.
		4.	And verify a few key words
		5.	Create Utilities for each of them.
	 */
	public static void wholePageElementText() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		String wholePageText = js.executeScript("return document.documentElement.innerText").toString();
		System.out.println(wholePageText);
//		if(wholePageText.contains("Downloads")) {
//			System.out.println("Test --- PASS");
//		}else {
//			System.out.println("FAIL");
//		}
		

		// This method change string into a list
//		Stream<String> stream = wholePageText.chars().mapToObj(Character::toString);
//		List<String> list = stream.collect(Collectors.toList());
		
		// Changing String using split method into a List
		List<String> stringList = Arrays.asList(wholePageText.split("\\s+"));
		System.out.println(stringList); // Since it prints a comma separated values, the test wo;; get failed.
		
//		To validate a few key words at one time using if condition
		List<String> expectedTexts = Arrays.asList("Site Map", "Customer Service", "Software", "Register", "Login");
		if(stringList.containsAll(expectedTexts)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		/*	Note
		 Can a string contains a list of strings in java?
			No, a string cannot contain a list of strings
			in Java. A string is an immutable sequence of characters, while a list is an ordered collection
			of objects. To represent a list of strings in a string, you can use a comma-separated list of strings, 
			or you can use a string array.
			
		As the string cannot contains a List of strings we will not be able to validate a List of keywords together at one
		time using containsAll(), because contains all accepts list of strings as it is parameter.
		So, for us to do this task is to convert string into List<String> then do the verification.	
		
		Note: these two methods will not work. as of now I should only and only verify one key word per page.
		Naveen couldn't offered the answer. If I could guess the way in the future, I will include it here.
		 */
	}		
	
}
