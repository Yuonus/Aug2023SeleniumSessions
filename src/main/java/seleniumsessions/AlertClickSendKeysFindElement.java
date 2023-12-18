package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertClickSendKeysFindElement {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
//		driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		driver.manage().window().maximize();
//		js.executeScript("document.getElementById('input-email').value='SYG@syg.com'");
//		js.executeScript("document.getElementById('input-password').value='xxxxx'");
//		
//		String pageTitle = js.executeScript("return document.title").toString();
//		System.out.println("Page title is: " + pageTitle);
//		
//		String pageURL = js.executeScript("return document.URL").toString();
//		System.out.println("Page URL is: " + pageURL);
//		
//		WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
//		js.executeScript("arguments[0].click();", login);
//		
//		js.executeScript("alert ('Enter Correct Login Credentials to Continue')");
		
		
	
		/* Assignment
		 		Business Case
			1.	Launch the browser
			2.	Navigate to https://login.yahoo.com/
			3.	Uncheck "Stay signed in" element using JS click method
			4.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/");	
		WebElement checkBox = driver.findElement(By.cssSelector("input#persistent"));

		Thread.sleep(2000);
//		checkBox.click(); //Normal click will not click on this element --> ElementNotInteractableException
//		Actions act = new Actions(driver);
//		act.click(checkBox); // Actions class will also not work here. --> No exception 

	
		// Create the object of JavaScriptUtil class and call the click method
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		jsUtil.clickElementByJS(checkBox);

	}

}
