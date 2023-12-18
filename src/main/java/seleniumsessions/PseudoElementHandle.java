package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register
			3.	Verify if the first name input field is a mandatory text field or not. (to verify this, you will need to 
				inspect the asterisk signs)
			4.	Close the browser
		 */
//		driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
//		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content');";
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String mand_field = js.executeScript(script).toString();
//		System.out.println(mand_field);
//		if (mand_field.contains("*")) {
//			System.out.println("The first name input field is mandatory");
//		}
		
		//*********** using generic Approach **********//
//		mandatoryFieldsPage("label[for='input-firstname']");

		
		//***************** Assignment 1st **************//
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://monica-official.github.io/Pseudo-Elements/sample-pseudo-element.html
			3.	Maximize the page
			4.	Capture the Pseudo sign / indicator of the "Submit" element and print it to the console
			5.	Close the browser
		 */
		
		driver = new ChromeDriver();
		driver.get("https://monica-official.github.io/Pseudo-Elements/sample-pseudo-element.html");
		driver.manage().window().maximize();
		String script = "return window.getComputedStyle(document.querySelector(\"button.submitButton\"), '::before')"
				+ ".getPropertyValue('content');";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pseudo = js.executeScript(script).toString();
		System.out.println(pseudo);
		driver.close();
	}
	
	public static String mandatoryFieldsPage(String querySelector) {
		String script = "return window.getComputedStyle(document.querySelector('"+querySelector+"'), '::before').getPropertyValue('content');";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(script).toString();
	}

}
