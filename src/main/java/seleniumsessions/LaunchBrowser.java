package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\syuon\\Documents\\"
				+ "OctoberBatchSeleniumNaveen2023\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(co);
		// 118.0.599  --> 118.0.599.exe
		// Current Selenium version = 4.3.0 --> Here the selenium will not automatically download the chrome
		// Version 118.0.599.exe. We will have to use System.setProperty() to provide the path of the exe file.
		driver.get("https://www.google.com/");
		String actualTitle = driver.getTitle();
		if(actualTitle.equals("Google")) {
			System.out.println("The page title is: " + actualTitle);
		}else {
			System.out.println("Incorrect page title: " + actualTitle);
		}
		driver.close();
	}
	// 4.6.0 --> on wards version
	//browser 118 -> 118.exe in your .cache folder and will start the server automatically.

}
