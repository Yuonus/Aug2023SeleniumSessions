package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownHandleWithoutSelect {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to (enter the URL) https://orangehrm.com/en/30-day-free-trial
			3.	Locate the "country" dropdown 
			4.	Find out how many options or <option> tags are there using programmatic concepts. 
				(Here, we are not selecting any values of the dropdown)

		*/
		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		
		By country = By.cssSelector("#Form_getForm_Country>option");
		
		// ***** ROUGH CODE APPROACH ************* //
//		List<WebElement> optionsList = driver.findElements(country);
//		System.out.println("Number of options are: " + optionsList.size());
//		for(WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		//****************** Utility Approach *******//
		selectDropDownValue(country, "Afghanistan");
		
	
	}
	
	//Utility
	public static void selectDropDownValue(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
		
}
