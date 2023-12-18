package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ChainingRelativeLocatorConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://www.browserstack.com/
			3.	Click on "Get a Demo" button which is below the "Text Section" area and to the right of the 
				"Get started free" link.
			4.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		WebElement textSection = driver.findElement(By.cssSelector("div.text-section p"));

		WebElement getStartedFree = driver.findElement(By.cssSelector("a#signupModalButton"));
		WebElement getADemo=driver.findElement(RelativeLocator.with(By.xpath("//*[@id=\"product-text-section\"]/div/div/div/div/span[4]"))
				.below(textSection)
				.toRightOf(getStartedFree));
		getADemo.click();
		

	}
	
}
