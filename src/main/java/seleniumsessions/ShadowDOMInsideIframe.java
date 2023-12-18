package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMInsideIframe {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		Thread.sleep(3000);
		
		// Element Hierarchy: Browser -- iframe -- Shadow DOM (open)  -- element
		
		driver.switchTo().frame(driver.findElement(By.id("pact")));
		String tea_script = "return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//HTML Element --- Selenium Element 
		WebElement tea = (WebElement)js.executeScript(tea_script);
		tea.sendKeys("Green tea");
		driver.close();
		
	}

}
