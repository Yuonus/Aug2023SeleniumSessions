package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDownHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://html.com/attributes/select-multiple/
			3.	Scroll down to multi-select dropdown
			4.	Locate the dropdown
			5.	First of all, verify if it is a multi-select drop down or not.
			6.	Select more than one option from the dropdown.
			7.	Use deselect() methods to deselect the dropdown options
				Before deselecting add some wait time to see the deselection clearly
				•	Deselect all
				•	Deselect one value 
		*/
		
		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
		By multiSelectDropD = By.xpath("//select");
		By optionLocator = By.xpath("//select/option");
		
		// Rough Code Approach
//		WebElement multiSelectDropDOptions = driver.findElement(multiSelectDropD);
//		Select select = new Select(multiSelectDropDOptions);
//		
//		if(select.isMultiple()) {
//			System.out.println("It is a multi-select dropdown --- PASS");
//			select.selectByVisibleText("American flamingo");
//			select.selectByVisibleText("James's flamingo");
//			select.selectByVisibleText("Chilean flamingo");
//		}
//		
////	    Now the Deselection methods come in handy here in multi-select dropdowns.
//		
//		Thread.sleep(2000);
////		select.deselectAll();
//		select.deselectByIndex(0);
//		select.deselectByVisibleText("Chilean flamingo");
//		select.deselectByValue("James's");
	
		// ******* Utility Approach **********//
		
		// Test Case 1 --> Selecting Multiple Values
//		selectDropDownMultipleValues(multiSelectDropD, optionLocator, "American flamingo", "Greater flamingo", "James's flamingo", "Lesser flamingo");
		
		// Test Case 2: --> Selecting Single Value
//		selectDropDownMultipleValues(multiSelectDropD, optionLocator, "American flamingo");  // single value call
		
		// Test Case 3: --> Selecting All Values
//		selectDropDownMultipleValues(multiSelectDropD, optionLocator, "all"); 
	}
	
	
	//***************** Utilities ****************//
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean isDropDownMultiple(By locator) {
		Select select = new Select(getElement(locator));
		return select.isMultiple() ? true : false;  // ternary operator
	}
	
//	This is a valid approach but not recommended
//	public static void selectDropDownMultipleValues(By locator, String value1, String value2) {
//		Select select = new Select(getElement(locator));
//		if(isDropDownMultiple(locator)) {
//			select.selectByVisibleText(value1);
//			select.selectByVisibleText(value2);
//		}
//	}
	
	/**
	 * This method is used to select the values from the drop down. It can select:
	 * 	1: Single selection
	 * 	2: Multiple selection
	 * 	3: All selection. Please pass "identifier" as a value to select all values
	 * @param locator
	 * @param values
	 */
	
	public static void selectDropDownMultipleValues(By locator, By optionLocator, String ... values) {
		Select select = new Select(getElement(locator));
		if(isDropDownMultiple(locator)) {
			if(values[0].equalsIgnoreCase("all")) {
				List<WebElement> optionsList = driver.findElements(optionLocator);
					for(WebElement e : optionsList) {
						e.click();
					}
				}else {
					for(String value : values) {
						select.selectByVisibleText(value);
					}
				}
			}
		}

}


