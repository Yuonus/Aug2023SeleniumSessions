package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementConcept {
	
	static WebDriver driver;
	public static void main(String[] args) {
		/*	Test Scenarios
		 	1. Launch the browser
		 	2. Launch the URL "https://naveenautomationlabs.com/opencart/index.php?route=account/login"
		 	3. Enter the email ID --> Here u will have to use the "Formula for interacting with web elements"
		 	4. 
		 */
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// 1st Approach/way of web element creation
//		driver.findElement(By.id("input-email")).sendKeys("S_Tech@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("Test123");
		
		/*		2nd Approach of Element Creation: Storing the Elements in WebElement interface
		 *  2nd approach is better because we can use the emailId and Password variables if we want to 
		 *  add new values. but with the first approach we cannot do anything like this.
		 *  2nd approach will give the flexibility to use the same variable again and again
		 *  with 2nd App u don't need to create the web element frequently.
		 */
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("S_Tech@gmail.com");
//		password.sendKeys("Test123");
//		emailId.sendKeys("2323232");
		
		/* 		3rd App: By Locator Approach 
		 	1. We will create By.id() method
		 	2. As by() method returns a By class reference, then we will store it in By reference
		  	3. Create the element using driver.findElement() method, and supply the variables to it.
		  	4. Now, store the created elements in WebElement interface variable and perform the related action on it.
		  	
		  			Benefits of Appr 3 in comparison to Appr 2
		  	i. In the following lines of codes we are not hitting the server unnecessarily
		  				By eId = By.id("input-email");
						By pwd = By.id("input-password");
				with the By.by() we are not hitting the server.
			ii. With 3rd Appr suppose u have 50, elements and you only want to use 10 elements. So, you will only
				be creating the Web elements for 10 elements, and only 10 elements will be hitting the server and we will
				not be hitting the server 40 times unnecessarily.
				But the 2nd approach you will have to create the web elements for each 50 elements and since
				the 50 elements are already created and they will all hit the server unnecessarily 50 times. Even though
				we only need to hit the server 10 times, because I only need 10 elements out of 50.
			iii. Web element creation is optional with 3rd Approach based on necessity, but it is not optional with 2nd
			iiii. Code maintenance is better with 3rd Appr in comparison to 2nd Appr
					Better readability, better performance.
			i5. By locators are behaving as Object Repositories (Collection of all locators)
		 */
		
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		WebElement emailId = driver.findElement(eId);
//		WebElement password = driver.findElement(pwd);
//		
//		emailId.sendKeys("S_Tech@gmail.com");
//		password.sendKeys("Test123");
		
		
		/*			4th Approach: By locators + Generic Methods for Element
		 	1. In this approach we can go with Approach #3 with an addition of generic methods
		 	2. The reason for adding the generic method is to decrease the volume of adding more codes.
		 		Pretend having 50 elements, the programmer should repeat "driver.findElement();" 50 times.
		 	3. In 4th Appr we decreased the code
		 */
		
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		getElement(eId).sendKeys("S_Tech@gmail.com");
//		getElement(pwd).sendKeys("Test123");

		/*			5th Approach: By locators + Generic Methods for Element and Actions
		 	1. In all above 4 Approaches the .sendKeys() action is repetitive, here in 5th Appr we will
		 	 	prevent frequently using the .sendKeys() method.
		 */
		
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		doSendKeys(eId, "S_Tech@gmail.com");
//		doSendKeys(pwd, "Test123");
		
		/*			6th Approach:
		 	1. By locators + Generic Methods for Element and Actions in another Element Util class
		 	2. We will have to transfer both of the bellow generic methods into a new class (ElementUtil).
		 	   Because, if someone want to use these methods, won't be able to use them as they are declared
		 	   in this present Caller class.
		 	3. Upon transferring these two methods into ElementUtil class, the main problem will be; 
		 	   How will you get the driver in ElementUtil class.
		 	   --> We can maintain the "WebDriver driver;" reference in the class level.
		 	   --> Import the WebDriver
		 	   --> As you know the current default value of the "driver" is null in ElementUtil class, and it 
		 	   		is not pointing to any chrome/Firefox ... driver. So, the question is how will you supply
		 	   		driver to the ElementUtil class and let it point out to Chrome, Firefox ... driver?
		 	   		We will use one Parameterized constructor to supply the driver to the ElementUtil class.
		 	   --> Remove the static designators from the methods in ElementUtil class, as we discussed in
		 	   		BrowserUtil class.
		 	   		
		 */
		
//		By eId = By.id("input-email");
//		By pwd = By.id("input-password");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(eId, "S_Tech@gmail.com");
//		eleUtil.doSendKeys(pwd, "Test123");
		
		/*		7th Approach: BrowserUtil + ElementUtil
		 	1. To understand the 7th Approach precisely, we will create a separate class. OpentCartLoginTest
		 	2. We can also comment out the 
		 		WebDriver driver = new ChromeDriver();
		 		driver.get();
		 		and create the object of the BrowserUtil class here and run this scenario.
		 	3. But preferably we wil create a new class.
		 */
		
		/*			8th Approach:By locators Conversion into String Locators
		 	1. As you can see in above Approaches we have the following used as only selenium methods
		 			By eId = By.id("input-email");
					By pwd = By.id("input-password");
		 		and as a user I don't want to use selenium methods, so lets manipulate the code 
		 	2. We will create a utility method in ElementUtil class named as getBy() method, and we will supply
		 		two parameters (String locatorType, String locatorValue)
		 	3. Then we will write one Switch case to fill all the locators like, id, class, name, css ... etc.
		 	4. We also maintain one By reference on the top of the switch case, which will initially reference
		 		a null value.
		 	5. Once the switch case is done we will return "by".
		 	6. Create the object of the ElementUtil class and call the doSendKeys() method
		 	7. As doSendKeys() is asking By locator and String Value as parameters and we want to pass
		 		String values to the method, we will override the doSendKeys method to add String locatorType.
		 	8.
		 
		 */
		String email_Id = "input-email";
		String pwd_Id = "input-password";
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", email_Id, "S_Tech@gmail.com");
		eleUtil.doSendKeys("id", pwd_Id, "Test123");
		
		/*		9th Approach: POM + FrameWork. --> (Page Object Model)
		 	1. This Approach will be covered later with Framework
		 */
		
		
	}
	
//	public static void doSendKeys(By locator, String value) {
//		getElement(locator).sendKeys(value);
//	}
//	
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//	}

}
