package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsFunction {
	
	static WebDriver driver;
	public static void main(String[] args) {
		/*			Test Scenario
		Using the utility methods, automate the following test scenario.
		1: Launch the Browser 
		2: Launch the URL / Navigate to "Your Store" app. "https://naveenautomationlabs.com/opencart/" 
		3: Find the Total numbers of links available in "Your Store" application page. 
		4: Find the total numbers of images available in "Your Store" application page.
		5: Capture the text of each Link and print it to the console.
		6: Verify the links text.
		7: Capture the value of the "href" attribute.
		8: Close the driver.
	 */
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		
		int linksCount = getElementsCount(links);
		System.out.println("Total number of links: " + linksCount);
		int imageCount = getElementsCount(images);
		System.out.println("Total number of links: " + imageCount);
		
		List<String> actualLinksTextList = getElementsTextList(links);
		System.out.println(actualLinksTextList);
//		We can also use actualLinksTextList list for validation purpose as well.
			if(actualLinksTextList.contains("My Account")) {
				System.out.println("My Account -- PASS");
			}
			if(actualLinksTextList.contains("Returns")) {
				System.out.println("Returns -- PASS");
			}
		System.out.println("----------------------------------------");
		List<String> hrefList = getElementsAttributeList(links, "href");
		for(String e : hrefList) {
			System.out.println(e);
		}
		
		driver.close();

	}
	
	// WAF: Capture the text of all page links and return List<String>
	
	/**
	 * This function capture text of all links in a page and return List<String>
	 * @param locator
	 * @return
	 */
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		//Selenium does not have a class to return list of Strings, we will instantiate our own custom method
//		that will return a list of strings and it is physical capacity will be 0.
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String text = e.getText();
				if(text.length()!=0) {
					eleTextList.add(text);
				}
		}
		return eleTextList;
	}
	
	// WAF to capture the value of a specific attribute. getAttribute();
	
	/**
	 * This Method will help to capture the attribute value of any attribute
	 * @param locator
	 * @param attrName
	 * @return List<String>
	 */
	public static List<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>(); // PC = 0
		
		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttrList.add(attrValue);
		}
		return eleAttrList;
	}
	
	/**
	 * This function/method returns the number of available web elements in a page.
	 * @param locator
	 * @return
	 */
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	/**
	 * This Function returns List of WebElements.
	 * @param locator
	 * @return
	 */
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
