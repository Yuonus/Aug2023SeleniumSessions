package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to (enter the URL) https://orangehrm.com/en/30-day-free-trial
			3.	Create the By locator for Select tag
			4.	Select Afghanistan from the drop down using selectByIndex() method.
			5.	Select United States from the drop down using selectByVisibleText() method.
			6.	Select India from the drop down using selectByValue() method.
			7.	Put one second wait between each selection
			8.	Deselect India. The purpose of bullet # 8 is to showcase to the students that deselection 
				does not happen with single select dropdown and it will cause to throw 
				UnsupportedOperationException. It is applicable for multi selection dropdowns.
			9.	Close the driver.
			10.	Develop a generic utility method for select class single selection. And move it to the 
				ElementUtil
		*/
		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		
		By country = By.cssSelector("#Form_getForm_Country");
		
//		ROUGH CODE APPROACH
//		WebElement country_ele = driver.findElement(country);
//		Select select = new Select(country_ele);
//		
//		select.selectByIndex(1);  // --> using selectByIndex() method
//		Thread.sleep(1000);
//		select.selectByVisibleText("United States"); // --> using selectByVisibleText() method
//		Thread.sleep(1000);
//		select.selectByValue("India");		// --> using selectByValue() method
////		Thread.sleep(1000);
////		select.deselectByValue("India");  //UnsupportedOperationException
		
		// Using Utilities
		doSelectDropDownByIndex(country, 1);
//		doSelectDropDownByIndex(country, 12*10-119); // this will still return Afghanistan
		doSelectDropDownByIndex(country, 217);
		
		doSelectDropDownByVisibleText(country, "United States");
		
		doSelectDropDownByValue(country, "India");
		doSelectDropDownByValue(country, "United Arab Emirates");
	
	}
	
	// Generic methods / Utilities
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
		
//	Note: We cannot overload doSelectDropDownByVisibleText() & doSelectDropDownByValue() because number of 
//	parameters and their type are the same. but we can overload doSelectDropDownByVisibleText() & 
//	doSelectDropDownByIndex(). But we will let them three independent methods.
	}
	
}
