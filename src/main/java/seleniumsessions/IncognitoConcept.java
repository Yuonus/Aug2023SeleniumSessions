package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoConcept {
	
	public static void main(String[] args) {
		
		// With ChromeDriver
		ChromeOptions co = new ChromeOptions();
		co.addArguments("incognito");
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.amazon.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
	}

}
