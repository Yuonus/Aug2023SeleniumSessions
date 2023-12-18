package seleniumsessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownOptions {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to (enter the URL) https://orangehrm.com/en/30-day-free-trial
			3.	Create the By locator for Select tag
			4.	Find out how many options or <option> tags are there using Select class. 
				(Here, we are not selecting any values of the dropdown)
			5.	Close the driver.
		*/
		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		
		By country = By.cssSelector("#Form_getForm_Country");
		
		//*********** ROUGH Code Approach ************//
//		WebElement country_ele = driver.findElement(country);
//		
//		Select select = new Select(country_ele);
//		List<WebElement> countryList = select.getOptions();
//		System.out.println("There are totally: " + countryList.size() + " options in COUNTRY dropdwon.");
//		for(WebElement e : countryList) {
//			String text = e.getText();
//			System.out.println(text);
//			
//			if(text.contains("Afghanistan")) {
//				e.click();
//				break;
//			// u can also use text.equals("Afghanistan") method
//			}
//		}
//		driver.close();
		
		// ****************** Utility Approach ************** //
		
		// selectDropDownOptions();
//		selectDropDownOptions(country, "Afghanistan");
//		selectDropDownOptions(country, "Finland");
		
		
		// getDropDownOptions();
//		List<String> countryOptions = getDropDownOptions(country);
//		for(String e : countryOptions) {
//			System.out.println(e);
//		}
//		
//		// Verify if a specific country is in the options list or not.
//		if(getDropDownOptions(country).contains("Afghanistan")) {
//			System.out.println("Afghanista --- PASS");
//		}else {
//			System.out.println("FAIL");
//		}
		
		// Verify if five countries if they are really existed in the options or not.
		// give this as a homework to students
//		List<String> expectedCountries = Arrays.asList("Afghanistan", "Finland", "United States", "India", "Zaire");
//		if(getDropDownOptions(country).containsAll(expectedCountries)) {
//			System.out.println("All the five countries were in the options list --- PASS");
//		}else {
//			System.out.println("All the five countries weren't in the options list --- FAIL");
//		}
		
		
		//getDropDownOptionsCount()
		int optionsCount = getDropDownOptionsCount(country);
		System.out.println("All available options are: " + optionsCount);
	}
	
	// ************ Utility Methods ************** //
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	// This is Utility will print the size of the options/ will print the texts of the options
	// and will click on predefined options
	public static void selectDropDownOptions(By locator, String dropDownValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> countryList = select.getOptions();
		System.out.println("There are totally: " + countryList.size() + " options in COUNTRY dropdwon.");
		for(WebElement e : countryList) {
			String text = e.getText();
			System.out.println(text);
			
			if(text.contains(dropDownValue)) {
				e.click();
				break;
			// u can also use text.equals("Afghanistan") method
			}
		}
	}
	
	/* This method will only return the available options in a select tag
	 Note: We have declared an empty List over the enhanced loop which its Physical capacity is zero.
	 then we will add all the options text to this empty array list (the options text we have captured
	 from the countryList). at the end we will return the OptionsTextList 
	 */
	public static List<String> getDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> countryList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		for(WebElement e : countryList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	
	// This method will return the count of dropdown options
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

}
