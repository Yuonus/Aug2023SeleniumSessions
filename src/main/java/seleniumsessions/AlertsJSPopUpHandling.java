package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsJSPopUpHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Open the browser
			2.	Navigate to https://the-internet.herokuapp.com/javascript_alerts 
			3.	Click on "Click for JS Alert"
			4.	Switch the driver focus to the alert
			5.	Capture the text of the alert
			6.	Accept the alert.
			7.	Close the browser
		 */
		
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		// Alert JS Pop up
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		Thread.sleep(2000);
//		System.out.println("The text of the alert is: " + text);
//		alert.accept();
////		alert.dismiss();
//		driver.close();
	
		//**************************************************************************************************//
		//**************************************************************************************************//
		
		/*	Business Case
			1.	Open the browser
			2.	Navigate to https://the-internet.herokuapp.com/javascript_alerts 
			3.	Click on "Click for JS Confirm"
			4.	Switch the driver focus to the alert
			5.	Capture the text of the alert
			6.	Accept the alert and then cancel the alert
			7.	Close the browser
		 */
		
		// Confirm JS Pop up
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		String confirmText = alert.getText();
//		System.out.println("The confirm pop up text is: " + confirmText);
////		alert.accept();
//		alert.dismiss();
//		driver.close();
		
		//**************************************************************************************************//
		//**************************************************************************************************//
		
		/* Business Case
			1.	Open the browser
			2.	Navigate to https://the-internet.herokuapp.com/javascript_alerts 
			3.	Click on "Click for JS Prompt"
			4.	Switch the driver focus to the alert
			5.	Capture the text of the alert
			6.	Send some keys in pop up input field. "Learning Testing at S_Tech is fun."
			7.	Either accept or cancel the pop up.
			8.	Close the browser
		 */
		
		// Prompt JS Pop Up
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String promptText = alert.getText();
		System.out.println("The prompt pop up text is: " + promptText);
		alert.sendKeys("Learning Testing at S_Tech is fun.");
		alert.accept();
		driver.close();
		
		
	}

}
