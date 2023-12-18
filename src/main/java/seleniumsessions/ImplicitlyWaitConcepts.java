package seleniumsessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcepts {

	static WebDriver driver;
	public static void main(String[] args){
		driver = new ChromeDriver();	
		
		// Implicitly Wait
		// Dynamic Wait or Global wait
		// applied after driver initialization
		// it is applied for all the webelements. (only web elements)
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Deprecated --> Used at Selenium 3.x
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Selenium 4.x
		
		// Login page = 10 seconds wait
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.id("input-emailtyt")).sendKeys("S_Tech@gmail.com");
		
		// e1 ---> 10 seconds --> 2 seconds:  8 seconds will be ignored
		// e1 ---> 10 seconds --> 10 seconds: NoSuchElementException
		
		//e2	--> Same 10 seconds wait
		//e3	--> Same 10 seconds wait
		//e50	--> Same 10 seconds wait
		// E.x	--> Same 10 seconds wait
//		if you have 100s of elements the wait time for each element will be 10 seconds, that is Y we call it global wait.
		
		// home page = 20 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// e51, e52, e53 ... --> 20 seconds wait 
		
		// Login Page = 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// e1 = 10 seconds
		
		// Register page = 5
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Rele: 5 seconds
		
		// Implicitly wait Nullification  --> Selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		// e1 -- e5o: 0 seconds
		
		// Login page
		// What if you want to go to login page again with 10 seconds wait? you will have to override the login page 
//		implicit wait again.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//********************** Explicit Wait********************//
		
//		To optimized the wait, we use explicit wait.
//		emailID		--> 10 seconds: 	2 seconds		8 seconds will be ignored
//		password	no wait applied
//		login		no wait applied
		
//		It can be used with either web & non web elements
		
		// alert: 5 seconds
		// driver.switchTo.alert();
		

		
		
	}
}
