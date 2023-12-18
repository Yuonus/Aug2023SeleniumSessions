package mytests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	protected WebDriver driver;
	
	@Parameters({"url", "browser"})
	@BeforeTest
	public void setUp(String url, String browserName) {
		System.out.println("Browser name is: " + browserName);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Please pass the right browser ... " + browserName);
			break;
		}
		
		driver.manage().deleteAllCookies(); // Delete all the cookies for the current domain. And this will also delete 
		// all the previous browser caches, histories .. and it will give us a fresh browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	} 
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
