package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JqueryDropDown {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette 
			3.	Expand "Multi Selection" dropdown. To expand the dropdown, click on it.
			4.	Verify how many options are there in the dropdown.
			5.	Collect/print all the values
			6.	Select "choice 2". To select "choice 2" in this dropdown you will have to click on it.
			7.	In the Rough code Approach Select all choices. (comment out collecting all values and 
				selecting "choice 2".)
			8.	Close the driver.

		*/
		
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette ");
		Thread.sleep(4000); // This wait time is for page load
		driver.findElement(By.cssSelector("input#justAnInputBox")).click();
		Thread.sleep(3000);
		List<WebElement> choicesList =driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
		System.out.println(choicesList.size());
		for(WebElement e : choicesList) {
			String text = e.getText();
			System.out.println(text);
//			if(text.equals("choice 2")) {
//				e.click();
//				break;
//			}
			try {
				e.click(); // after 15th option it throws ElementNotInteractableException
			}
			catch(ElementNotInteractableException ex) {
			System.out.println("The dropdown elements are finished ..."); //better not to print the message, otherwise this
//			message will be printed 15 times. If you want to limit the iteration of printing to 1 time, simply add
//			break keyword.
			break;
			}
			
			}
		
		//************ Utility Approach *****//
		
//		By multiSelectDropDown = By.cssSelector("input#justAnInputBox");
//		By optionsLocator = By.cssSelector("span.comboTreeItemTitle");
		
		// Test Case: Single option
//		selectDropDownMultipleValues(multiSelectDropDown, optionsLocator, "choice 2");
		
		// Test Case: Multiple Options
//		selectDropDownMultipleValues(multiSelectDropDown, optionsLocator, "choice 2", "choice 1", "choice 3");
		
		// Test Case: All options
//		selectDropDownMultipleValues(multiSelectDropDown, optionsLocator, "all");

		}

	
	//***************** Utilities ****************//
		public static WebElement getElement(By locator) {
			return driver.findElement(locator);
		}
		
//		public static boolean isDropDownMultiple(By locator) {
//			Select select = new Select(getElement(locator));
//			return select.isMultiple() ? true : false;  // ternary operator
//		}
		
		/**
		 * This method is used to select the values from the drop down. It can select:
		 * 	1: Single selection
		 * 	2: Multiple selection
		 * 	3: All selection. Please pass "identifier" as a value to select all values
		 * @param locator
		 * @param values
		 */
		
		public static void selectDropDownMultipleValues(By locator, By optionLocator, String ... values) {
			driver.findElement(locator).click();
				if(values[0].equalsIgnoreCase("all")) {
					List<WebElement> optionsList = driver.findElements(optionLocator);
						for(WebElement e : optionsList) {
							System.out.println(e.getText());
							e.click();
						}
					}else {
						for(String value : values) {
							System.out.println(value);
						}
					}
				}
}
