package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcept {
	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/");
//		System.out.println(driver.getTitle());
//		driver.navigate().to("https://www.google.com");
//		System.out.println(driver.getTitle());
//		driver.navigate().back();
//		System.out.println(driver.getTitle());
//		driver.navigate().forward();
//		System.out.println(driver.getTitle());
//		driver.navigate().back();
//		System.out.println(driver.getTitle());
//		driver.navigate().refresh();
		
		// Using the navigate.to (URL url); since URL is a class we have to create its object and capture the possible exception
		driver.navigate().to(new URL ("https://naveenautomationlabs.com/opencart/"));
		driver.close();
	}

}
