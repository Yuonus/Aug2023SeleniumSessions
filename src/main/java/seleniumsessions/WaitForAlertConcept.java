package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlertConcept {
	static WebDriver driver;
	public static void main(String[] args){
		
		/*		Business Case
			1.	Open the browser
			2.	Navigate to https://the-internet.herokuapp.com/javascript_alerts 
			3.	Click on "Click for JS Alert"
			4.	Wait 5 seconds for alert to be loaded completely 
			5.	Switch the driver focus to the alert. **** You don’t need to switch to the alert pop up explicitly, 
				because the alertIsPresent() method will internally switch to alert.
			6.	Capture the text of the alert
			7.	Accept the alert.
			8.	Close the browser
		 */

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		String alertText = alert.getText();
		System.out.println("Alert text is: " + alertText);
		
		alert.accept();
		driver.close();
		
		
		
	}
	
	// ************** Generic Methods ********** //
	
	public static Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void acceptJSAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}
	
	public static void dismissJSAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}
	
	public static String getJsAlertText(int timeOut) {
		return waitForJSAlert(timeOut).getText();
	}
	
	public static void enterValueOnJsAlert(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}
	
	
	

}
