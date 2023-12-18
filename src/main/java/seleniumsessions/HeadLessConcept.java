package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessConcept {
	
	public static void main(String[] args) {
		
		// With ChromeDriver
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("headless");
//		WebDriver driver = new ChromeDriver(co);
//		
//		driver.get("https://www.google.com");
//		System.out.println(driver.getTitle());
		
////		// With Firefox driver
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(fo);
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		
	}

}
