package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsEmpty {
	static WebDriver driver;
	public static void main(String[] args){
		/*		Business Case
				
			1.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register 
			2.	just send some dummy keys with a correct Xpath expression. Do not locate the web element.
			3.	just send another dummy keys with an incorrect Xpath expression. Do not locate the web element.
			4.	Create a utility method where it should look for the existence of one element in the page.
			5.	Then call the method and verify if the log is presented in the page or not.
			6.	Create another method to return the presence of multiple web elements in the page.
			7.	At the end overload the method (multiple web elements) to return the presence of multiple web 
				elements based on the numbers the user give.
			8.	Close the driver.
			9.	Move the utility to ElementUtil class
		*/
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
//		driver.findElement(By.xpath("//input[@class='S_Tech']")).sendKeys("Sabawoon Yuonus");
//		org.openqa.selenium.NoSuchElementException: no such element:
		
//		driver.findElement(By.xpath("//input[@class ....='S_Tech']")).sendKeys("Sabawoon Yuonus");
//		org.openqa.selenium.InvalidSelectorException: invalid selector: Unable
		
//		Change of Scenario with findElements() method 
		
//		List<WebElement> elements = driver.findElements(By.xpath("//input[@class='Sabawoon']"));
//		System.out.println(elements);
//		System.out.println(elements.size());
		
		By logoImage = By.cssSelector(".img-responsive");
		if(checkElementPresent(logoImage)) {
			System.out.println("The logo is present in the page --- PASS");
		}else {
			System.out.println("Logo is not presented in the page --- FAIL");
		}
				
	}
	
	public static boolean checkElementPresent(By locator) {
		return driver.findElements(locator).size() == 1 ? true : false;
	}
	
	public static boolean checkMultipleElementPresent(By locator) {
		return driver.findElements(locator).size() >=1 ? true : false;
	}

}
