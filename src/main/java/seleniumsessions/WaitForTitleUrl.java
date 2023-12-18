package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleUrl {
	static WebDriver driver;
	public static void main(String[] args){
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
			3.	Click on "About us".
			4.	Wait 5 seconds for the title to be loaded and then capture it.
			5.	Close the browser.
			6.	Create a generic method for it and move it to ElementUtil class.
		 */

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By aboutUsLink = By.linkText("About Us");
		driver.findElement(aboutUsLink).click();
		
		// ********** Rough Code Approach *********//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		if(wait.until(ExpectedConditions.titleContains("About"))) {
//			System.out.println(driver.getTitle());
//		}else {
//			System.out.println("Page title is not found");
//		}
		
		//************ Utility Approach **************************//
		String title = waitForTitleContains("Aboutu", 5);
		System.out.println(title);
		
	}
	
	public static String waitForTitleContains(String titleFractionValue, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
		if(wait.until(ExpectedConditions.titleContains(titleFractionValue))) {
			return driver.getTitle();
		}
		}
		catch(TimeoutException e) {
			System.out.println(titleFractionValue + "Title fraction value is not present");
			e.printStackTrace();
		}
		return null;
	}
	
	public static String waitForTitleIs(String titleCompleteValue, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
		if(wait.until(ExpectedConditions.titleContains(titleCompleteValue))) {
			return driver.getTitle();
		}
		}
		catch(TimeoutException e) {
			System.out.println(titleCompleteValue + "Title full value is not present");
			e.printStackTrace();
		}
		return null;
	}
	
	public static String waitForURLContains(String urlFractionValue, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
		if(wait.until(ExpectedConditions.titleContains(urlFractionValue))) {
			return driver.getCurrentUrl();
			}
		}catch(TimeoutException e) {
			System.out.println(urlFractionValue + "URL fraction value is not present");
			e.printStackTrace();
		}
		return null;
	}
	
	public static String waitForURLToBe(String urlCompleteValue, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
		if(wait.until(ExpectedConditions.titleContains(urlCompleteValue))) {
			return driver.getCurrentUrl();
			}
		}catch(TimeoutException e) {
			System.out.println(urlCompleteValue + "URL complete value is not present");
			e.printStackTrace();
		}
		return null;
	}
	

}
