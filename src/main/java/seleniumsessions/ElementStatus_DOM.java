package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementStatus_DOM {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
//		elementVisible();
//		elementEnable_Disable();
		elementSelected();
		
	}
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register
			3.	Verify if the logo on the page is really visible or not.
			4.	Close the browser
		 */
		public static void elementVisible() {
			driver = new ChromeDriver();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

			By logoSign = By.xpath("//img[@title='naveenopencart']");
			WebElement regLogoSign = driver.findElement(logoSign);
			if (regLogoSign.isDisplayed()) {
				System.out.println("The logo is visible on the page. --- PASS");
			} else {
				System.out.println("The logo is not visible on the page.  --- FAIL");
			}
			driver.close();
		}
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://classic.freecrm.com/
			3.	Click on "Sign Up"
			4.	Verify if the "SUBMIT" button is enabled or not.
				to show the enability of the element click on "I agree with terms and conditions" check box
			5.	Close the browser
		*/
		
		public static void elementEnable_Disable() throws InterruptedException{
			driver = new ChromeDriver();
			driver.get("https://classic.freecrm.com/");
			Thread.sleep(2000);
			driver.findElement(By.linkText("Sign Up")).click();
			
			// This click action is to see if the submit button is enabled, then the test should return true
//			driver.findElement(By.xpath("//input[@name='agreeTerms']")).click();
			
			Thread.sleep(2000);
			By submitBtn = By.cssSelector("button#submitButton");
			WebElement submit = driver.findElement(submitBtn);
			boolean btnEnable = submit.isEnabled();
			System.out.println(btnEnable);
			System.out.println(submit.isDisplayed()); // The reason Y the isDisplayed is used to observe the difference
//			between isEnabled() & isDisplayed()
			driver.close();
		}
		
		/*			Business Case
		 	1.	Launch the browser
			2.	Navigate to https://classic.freecrm.com/
			3.	Click on "Sign Up"
			4.	Verify if the "I agree with the terms and conditions" radio button is selected or not.
			5.	Close the browser
		 */
		public static void elementSelected() {
			driver = new ChromeDriver();
			driver.get("https://classic.freecrm.com/");
			
			driver.findElement(By.linkText("Sign Up")).click();
			WebElement termConditionsBtn = driver.findElement(By.xpath("//input[@name='agreeTerms']"));
			if(termConditionsBtn.isSelected()) {
				System.out.println("The check box is selected --- PASS");
			}else {
				System.out.println("The check box is not selected --- FAIL");
			}
			
			// To show if the check box is selected, simply click on the check box to pass the test
//			termConditionsBtn.click();
//			if(termConditionsBtn.isSelected()) {
//				System.out.println("The check box is selected --- PASS");
//			}else {
//				System.out.println("The check box is not selected --- FAIL");
//			}
			
			driver.close();
		}

}
