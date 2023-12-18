package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		
		/*		Test Scenario --> Use String Approach
		 	1: Launch the browser
		 	2: Launch the URL. "https://naveenautomationlabs.com/opencart/index.php?route=account/login"
		 	3: Locate the "E-Mail Address" and get the placeholder value out of it. -> E-Mail Address
		 	4: Locate the "Register" link and get the values of "href" & "class" attributes out of it.
		 	5: Close the driver
		 	
		 	Note: Create a utility for getAttribute (), move it to the ElementUtil class and automate the
		 		  above script using utility.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By registerLink = By.linkText("Register");
		
//		String placeholderVal = driver.findElement(emailId).getAttribute("placeholder");
//		System.out.println("Placeholder attribute value is: " + placeholderVal);
//		
//		String hrefVal = driver.findElement(registerLink).getAttribute("href");
//		System.out.println("href: " + hrefVal);
//		
//		String className = driver.findElement(registerLink).getAttribute("class");
//		System.out.println("Class attribute value is: " + className);
		
		/*			Interview Question
		 	1: Launch the browser
		 	2: Launch the URL. "https://naveenautomationlabs.com/opencart/index.php?route=account/login"
		 	3: Locate the "E-Mail Address", send some keys and capture those inputted texts and print them
		 		to the console
		 */
//		driver.findElement(emailId).sendKeys("S_Tech@gmail.com");
//		String userInputtedTexts = driver.findElement(emailId).getAttribute("value");
//		System.out.println("User inputted text: " + userInputtedTexts);
		
		String placeholderVal = doGetElementAttribute(emailId, "placeholder");
		System.out.println(placeholderVal);
		
		String hrefVal = doGetElementAttribute(registerLink, "href");
		System.out.println(hrefVal);
		
		// We can also the value of blank "value" attribute.
		String valueVal = doGetElementAttribute(emailId, "value");
		System.out.println(valueVal);
		
		// if you want to print user input, you will have to send the keys first.
		driver.findElement(emailId).sendKeys("S_Tech is my favorite");
		String userInputVal = doGetElementAttribute(emailId, "value");
		System.out.println(userInputVal);
		
		driver.close();
	}
	
	public static String doGetElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/*				ASSIGNMENTS FOR STUDENTS:
	 
	 	1: Same as finding the user inputted texts in E-Mail Address, You will be finding the User inputted text
	 		from "Password" input field.
	 	2: Click on "Register" link, fill the entire form and capture the user inputted texts and print them
	 		to the console.
	 	3:
	 		--> Navigate to amazon. "https://www.amazon.com/"
	 		--> Inspect any image
	 		--> Get the values of "alt" and "src" attributes, and then print them to console.
	 		--> close the driver
	 		--> Use both rough format code and Utility code.
	 */
	
}
