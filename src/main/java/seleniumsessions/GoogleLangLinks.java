package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLangLinks {
	static WebDriver driver;
	public static void main(String[] args) {

		/*					Task
		 	1: Navigate to "https://www.google.com/"
		 	2: Capture the count of each and every language link given in the "Google offered in"
		 	3: Capture the text of each and every language link.
		 	4: Keep traversing/looping and click on a certain language.
		 	5: Do the task using both Rough Code and Utility Approaches
		 	6: Move the Utility to "ElementUtil" class.
		*/
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		// Rough code Approach
//		List<WebElement> langLinks = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
//		System.out.println(langLinks.size());		
//		for(WebElement e : langLinks) {
//			String text = e.getText();
//			System.out.println(text);
//			//store in the list<string>
//				if(text.contains("বাংলা")) {
//					e.click();
//					break;
//				}
//		}
//	}
		
		// Utility Approach
		
		By langLinks = By.xpath("//div[@id='SIvCob']/a");
		clikcOnElement(langLinks, "বাংলা");
		
	}
	
	public static void clikcOnElement(By locator, String eleText) {
		List<WebElement> langLinks = driver.findElements(locator);
		System.out.println(langLinks.size());		
		for(WebElement e : langLinks) {
			String text = e.getText();
			System.out.println(text);
			//store in the list<string>
				if(text.contains(eleText)) {
					e.click();
					break;
				}
		}
	}
	
	/*					ASSIGNMENT
	 	1: Navigate to "https://naveenautomationlabs.com/opencart/index.php?route=account/login"
	 	2: Capture the count of the links used in the right panel side.
	 	3: Capture the text of each and every link on the right panel side.
	 	4: Keep traversing/looping and click on a certain link. say "Wish List"
	 	5: Do the task using both Rough Code and Utility Approaches
	 */

}
