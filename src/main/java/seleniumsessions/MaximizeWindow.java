package seleniumsessions;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeWindow {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
//		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		
		// To minimize window
//		Thread.sleep(2000);
//		driver.manage().window().setPosition(new Point(0, -1000)); // import Point from selenium	
	}

}
