package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingDisabledElements {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://classic.freecrm.com/
			3.	Click on "Sign Up"
			4.	Click on "SUBMIT"
			5.	Close the browser
		 */
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		
		driver.findElement(By.linkText("Sign Up")).click();
		WebElement submit = driver.findElement(By.cssSelector("button#submitButton"));
//		submit.click(); // With Normal click the selenium will throw ElementClickInterceptedException
		
		// but with Actions class, Selenium will not throw any exception
		Actions act = new Actions(driver);
		act.click(submit).perform();
		driver.close();
	
	}

}

