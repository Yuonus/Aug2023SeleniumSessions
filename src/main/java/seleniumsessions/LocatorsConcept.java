package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		 Locators: There are eight locators in selenium that helps to create a web element.
		 
		// 1. Id: is an attribute, and should always be unique, it is not mandatory that each web element 
		// should have the ID.
		
//		driver.findElement(By.id("input-email")).sendKeys("S_Tech@gmail.com");
	
		/*			2. name
		 	--> name: is also an attribute and it could be duplicate and the same name could be given to 
		 		another web element.
		 	--> If name and ID locators are both available preferences should be given to the ID, because ID is
		 		unique
		 */
//			driver.findElement(By.name("email")).sendKeys("S_Tech@gmail.com");
		
		/*			3. className
		 	--> className is an attribute, and most of the times the value of class is duplicate. Y?
		 	--> Since className is duplicate, the selenium will give the preference to the first element 
		 		holding the class.
		 	--> As an example; I did inspect the email-Id input field, but selenium interacted with search input
		 		field. That is because it is the first web element holding the class.
		 	--> Using className is not recommended for locating single web element as it is duplicate.
		 	--> What is the purpose of the class? / Y did the UI developers added the classes to their HTML code?
		 		A Class is actually a CSS file which holds/provides the styles for web elements.
		 		
		 */
		
//		driver.findElement(By.className("form-control")).sendKeys("S_Tech@gmail.com");
		
		/*			4. Xpath locator
		 	--> Here, we will cover the basics of xpath in upcoming chapters we will completely cover it.
		 	--> xpath is not an attribute.
		 	-->
		 */
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("S_Tech@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Test123");
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		// Let's create a utility method for .click methos as we have created for .sendKeys() method. And
		// use By Locator Approach. and move the utility into the ElementUtil class
		
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
//		By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		
//		doSendKeys(eId, "S_Tech@gmail.com");
//		doSendKeys(pwd, "Test123");
//		doClick(loginBtn);
//		 
		
		/*		5. cssSelector
		 	--> CSS is not an attribute
		 	--> To grab the CSS value of an element, right click on the element and click on "Copy", 
		 		and click on "Copy selector".  #input-email
		 */
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("S_Tech@gmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("Test123");
//		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
		
		// By locator Approach
//		By emailId = By.cssSelector("#input-email");
//		By pwd = By.cssSelector("#input-password");
//		By loginBtn = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
//		
//		doSendKeys(emailId , "S_Tech@gmail.com");
//		doSendKeys(pwd, "Test123");
//		doClick(loginBtn);
		
		/*			6. linkText
		 	--> linkText is not an attribute, it is simply the text of a link.
		 	--> Only applicable for links
		 	--> All the links are represented by <a> tag.
		 */
//		driver.findElement(By.linkText("Register")).click();
		
		// By locator Approach
//		By registerLink = By.linkText("Register");
//		doClick(registerLink);
		
		/* 				7. partialLinkText 
			--> partialLinkText is not an attribute, it is simply the part of the text from a link.
			--> Only applicable for links.
			--> It is used when there is a lengthy text for a link. So, the user can grab a part of the 
				text in order to locate/create the web element.

		 */
//		driver.findElement(By.partialLinkText("Forgotten")).click();
		
		// By Locator Approach
//		By forgottenPasswordLink = By.partialLinkText("Forgotten");
//		doClick(forgottenPasswordLink);
		
		/*				8. tagName locator
			--> It is useful when the tag doesn’t have any attributes but only having a text
		 	--> Tag Name locator is used to find the elements matching the specified Tag Name. It is very 
		 		helpful when we want to extract the content within a Tag.
		 		
		 	let's also create the utility for getText() method and next move it to the ElementUtil class, and
		 	remember to remove the static key word.
		 */
		
//		String header = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(header);
		
		//By locator Approach
		By header = By.tagName("h2");
		String headerValue = doElementGetText(header);
		System.out.println("Header Text is: " + headerValue);
		if(headerValue.equals("New Customer")) {
			System.out.println("Header is correct --- PASS");
		}
		else {
			System.out.println("Header is not correct --- FAIL");
		}
	}
	
	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
//		If we don't want to use the "return" we can directly print the value of the header by storing it
//		in a separate variable. and changing the method type to "void"
//		String header = getElement(locator).getText();
//		System.out.println(header);
	}
	
	public static void doClick(By locator) { 
		getElement(locator).click();
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
