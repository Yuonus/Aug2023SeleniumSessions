package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case

		*/
		
		// Actions Scrolling --> Selenium 4.xx 
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		Actions act = new Actions(driver);
		
		// Slightly Scroll Down & Scroll Up
//		act.sendKeys(Keys.PAGE_DOWN).perform();  
//		act.pause(1000);
//		act.sendKeys(Keys.PAGE_UP).perform();
		
		// Complete Scroll Down & Scroll Up
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.sleep(1000);
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
//		act.pause(1000);
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		
		
		// ScrollToElement()
		act.scrollToElement(driver.findElement(By.xpath("//a[text()='Help']")))
			.pause(2000)
				.click(driver.findElement(By.xpath("//a[text()='Help']")))
					.build()
						.perform();
		
		// Refreshing page
		act.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).build().perform();
	
	}
	
	

}
