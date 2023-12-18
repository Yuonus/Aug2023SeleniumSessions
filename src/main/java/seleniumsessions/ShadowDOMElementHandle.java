package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMElementHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("chrome://settings/");
		Thread.sleep(3000);
		
//		driver.findElement(By.id("searchInput")).sendKeys("notifications"); // not working as it is a shadow DOM 
		String search_script = "return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#toolbar\")"
				+ ".shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//	HTML element --- Selenium web element
		WebElement search = (WebElement)js.executeScript(search_script);
		search.click();
	}

}
