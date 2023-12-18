package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		driver = new ChromeDriver();
		
	currencyMenu();
//	task1();
//	task2();
//	task3();
//	assignment();
//	ancestorConcept();
//	precedingSiblingCon();
//	precedingSibLoginPage();
//	amazonPrecedingSiblingCon();
//	followingSiblingCon();
//	amazonAssignment();
		
	}
	
	/*	Parent To child Traversing (top to bottom traverse)
		TASK --> Business Case
			1: Navigate to "https://naveenautomationlabs.com/opencart/index.php?route=account/login"
			2: Click on the "Currency" dropdown
			3: Create the Xpath expression for currency form, and locate all three currencies.
			4: Find out how many currencies are there
			5: Capture the text of each currency and print it to console
			6: Use Parent to child Xpath approach for this task
			7: Close the driver.
	The Xpath used in this task can be written into two following ways
	//form[@id='form-currency']//ul[@class='dropdown-menu']//button	
	//form[@id='form-currency']//child::ul[@class='dropdown-menu']//child:: button[@name='EUR']
	 */
	public static void currencyMenu() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.xpath("//button[@data-toggle='dropdown']/parent::div[@class='btn-group']")).click();
		List<WebElement> currencyList = driver.findElements(By.xpath("//form[@id='form-currency']//ul[@class='dropdown-menu']//button"));
		System.out.println(currencyList.size());
		for(WebElement e : currencyList) {
		String currencyText = e.getText();
		System.out.println(currencyText);
		
		}
	}
	
	/* Child To Parent Traversing (backward Traverse)		
			Task 1 --> Business case
		1.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register
		2.	Locate the "Yes" radio button and click on it.
		3.	Capture the text of it.
		4.	Close the driver.
	 */
	public static void task1() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
	}
	
	/*	Child To Parent Traversing 
	 	Task 2
		1.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
		2.	Locate the "E-Mail Address" input field and send some keys. "S_Tech"
		3.	Close the driver.
	*/
	
	public static void task2() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	/*		Task 3 --> Business Case
	1.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
	2.	Locate the "E-Mail Address" input field and send some keys. "S_Tech 
	3.	How will check that the "E-Mail Address" text-field is having E-Mail Address as label?
	4.	Close the driver.
	
	for better Readability we can write this Xpath --> //input[@name='email']/../label[@for='input-email'] 
	like the given below
	//input[@name='email']/parent::div/label[@for='input-email'] --> finally if we replace the child tag
	//input[@name='email']/parent::div/child::label[@for='input-email']
	 */

	public static void task3() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement text = driver.findElement(By.xpath("//input[@name='email']/../label[@for='input-email']"));
		String labelText = text.getText();
		System.out.println("E-Mail Address label is: " + labelText);
		if(labelText.equals("E-Mail Address")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		driver.close();
	}
	
	/*	ASSIGNMENT
		1.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register 
		2.	Locate the "FirstName" input field and how will you check that the "FirstName" text-field 
			is having First Name as label?
		3.	Close the driver.
	*/
	public static void assignment() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement fNameLabel = driver.findElement(By.xpath("//input[@name='firstname']/../../"
				+ "label[@for='input-firstname']"));
		String fNLabel = fNameLabel.getText();
		System.out.println("First name lable is: " + fNLabel);
		if(fNLabel.equals("First Name")) {
			System.out.println("Verified --- PASSED");
		}else {
			System.out.println("FAIL");
		}
		driver.close();
	}
	
	/*
		Do this task by ignoring the immediate parent and jumping directly to the great parent.
		1.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register 
		2.	Locate the "FirstName" input field and how will you check that the "FirstName" text-field is 
			having First Name as label?
		3.	Close the driver.
	*/
	public static void ancestorConcept() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement fNameLabel = driver.findElement(By.xpath("//input[@name='firstname']/ancestor::div[@class='"
				+ "form-group required']/child::label[@for='input-firstname']"));
		String fNLabel = fNameLabel.getText();
		System.out.println("First name lable is: " + fNLabel);
		if(fNLabel.equals("First Name")) {
			System.out.println("Verified --- PASSED");
		}else {
			System.out.println("FAIL");
		}
		driver.close();
	}
	/*	TASK
		Do this task by using preceding sibling concept in Xpath.
		1.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register 
		2.	Locate the "FirstName" input field and how will you check that the "FirstName" text-field is having First Name as label?
		3.	Close the driver.
	*/
	public static void precedingSiblingCon() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement fNameLabel = driver.findElement(By.xpath("//input[@name='firstname']/parent::div/"
				+ "preceding-sibling::label[@for='input-firstname']"));
		String fNLabel = fNameLabel.getText();
		System.out.println("First name lable is: " + fNLabel);
		if(fNLabel.equals("First Name")) {
			System.out.println("Verified --- PASSED");
		}else {
			System.out.println("FAIL");
		}
		driver.close();
	}
	/*
		Task 2:
			Automate this task using preceding sibling concept
			1.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
			2.	Locate the "E-Mail Address" input field. 
			3.	How will check that the "E-Mail Address" text-field is having E-Mail Address as label?
			4.	Close the driver.
	*/
	public static void precedingSibLoginPage() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement text = driver.findElement(By.xpath("//input[@name='email']/preceding-sibling::label[@for='input-email']"));
		String labelText = text.getText();
		System.out.println("E-Mail Address label is: " + labelText);
		if(labelText.equals("E-Mail Address")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		driver.close();
	}
	
	/*	TASK 3:
			1.	Navigate to https://www.amazon.com
			2.	Scroll down to the footers section
			3.	Verify how "Careers" is coming under "Get to Know Us"
			4.	Close the driver.
	*/
	
	public static void amazonPrecedingSiblingCon() throws InterruptedException {
		driver.get("https://www.amazon.com/");
		WebElement careerGetToKnow = driver.findElement(By.xpath("//a[text()='Careers']/ancestor::ul/"
				+ "preceding-sibling::div[text()='Get to Know Us']"));
		Thread.sleep(3000);
		String careerGetToKn = careerGetToKnow.getText();
		System.out.println(careerGetToKn);
		if(careerGetToKn.equals("Get to Know Us")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
	}

	/*			FOLLOWING SIBLING CONCEPT WITH XPATH
		Task 1:
			Automate this task using following sibling concept
			1.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
			2.	Locate the "Password" label.
			3.	Verify that "Password" label is having a text-field. Or
			How will check that the "Password" label having password text-field?
			4.	Close the driver.
	 */
	public static void followingSiblingCon() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement passTextField = driver.findElement(By.xpath("//label[text()='Password']/"
				+ "following-sibling::input"));
		String text = passTextField.getAttribute("placeholder");
		System.out.println("Password label text-field is: " + text);
		if(text.equals("Password")) {
			System.out.println("Test --- PASS");
		}else {
			System.out.println("Test --- FAIL");
		}
		driver.close();
	}

	/*
		Assignment
		1: Go to https://www.amazon.com/
		2: Scroll down to the footers section
		3: Inspect "Get To Know Us", and:
		 a: How many total links are there?
		 b: Capture all its following siblings. (or give me its following siblings texts)
		4: Close the driver.
	*/
	
	public static void amazonAssignment() {
		driver.get("https://www.amazon.com");
		List<WebElement> GetToKnowUsFollowingSiblings = driver.findElements(By.xpath("//div[text()="
				+ "'Get to Know Us']/following-sibling::ul/child::li/child::a[@class='nav_a']"));
		System.out.println("Total number of links under Get To Know Us: are " + GetToKnowUsFollowingSiblings.size());
		for(WebElement e : GetToKnowUsFollowingSiblings) {
			String siblingLinksText = e.getText();
			System.out.println(siblingLinksText);
		}
		driver.close();
	}


}
