package seleniumsessions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon508_ComplianceTabingAssignment {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case

		*/
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("Macbooks")
			.sendKeys(Keys.ENTER).build().perform();
		driver.close();
	}

}
