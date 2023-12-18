package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementConcept {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		/*			Test Scenario
		 	--> Launch the browser
		 	--> Launch the URL "https://naveenautomationlabs.com/opencart/index.php?route=account/login"
		 	--> Inspect the "E-mail Address" with ID locator.
		 	Question part.
		 		** > The ID locator is: "input-email"
		 		** > What if the user deliberately add 1111 to its end. "input-email1111"
		 		** > Will this Code work?
		 	-->	Type an expected email ID.
		 	
		 	Answer to question:
		 	No, this code will not work, and the selenium will throw NoSuchElementException
		 */
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		driver.findElement(By.id("input-email1111")).sendKeys("S_Tech@gmail.com");
		
		// 2
		/*
		 Can we directly supply the numeric value to .sendKeys() method? Ans: No. we
		 cannot directly supply the numeric values to .sendKeys() method. If we wish
		 to do so; firstly, we need to convert the int or numeric values into a string
		 using "String.vlaueOf();" method and then store it in another String variable
		 and later we can pass this new String variable into the .sendKeys() method.
		 */
//		int totalAmount = 1234;
//		String totalBillAmount = String.valueOf(totalAmount);
//		driver.findElement(By.id("input-email")).sendKeys(totalBillAmount);
		
		/*		3:
		  What happens if you pass "null" to .sendKeys() method? The selenium will
		  throw IllegalArgumentException and will instruct the programmer
		  "keys to send should not be a null CharSequence"
		 */
//		driver.findElement(By.id("input-email")).sendKeys(null);
		
		/*			4:
		 	Can we pass StringBuilder to .sendKeys() Method?
		 	Ans:Yes we can pass/supply StringBuilder to .sendKeys() method
		 */
		StringBuilder sb = new StringBuilder("S_Tech@gmail.com");
		driver.findElement(By.id("input-email")).sendKeys(sb);
//		we can also concatenate more strings with StringBuilder
		driver.findElement(By.id("input-email")).sendKeys(sb + " The best academy");

		
		/*		5:
		 	--> We can supply following to .sendKeys() method in selenium.
				 > String
				 > StringBuilder
				 > StringBuffer
		 */
		
		

	}

}
