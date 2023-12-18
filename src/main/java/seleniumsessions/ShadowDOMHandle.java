package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMHandle {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(3000);
		
		// Hierarchy to reach the element. Browser -- Shadow DOM -- Shadow DOM --- element
		
		String pizza_script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\")"
				+ ".shadowRoot.querySelector(\"#pizza\")";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//	HTML element --- Selenium web element
		WebElement pizza = (WebElement)js.executeScript(pizza_script);
		pizza.sendKeys("chicken pizza"); // "Enter pizza name" input field is not inside an iframe
		
		
		
		
	}

}
