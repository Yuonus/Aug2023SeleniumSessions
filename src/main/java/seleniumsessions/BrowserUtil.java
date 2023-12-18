package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * 
 * @author syuon
 * BrowserUtils is having multiple generic methods to handle various browser actions.
 *
 */
public class BrowserUtil {
	
	private WebDriver driver;
	
	
	/**
	 * This method launches the browser on the basis of given browserName 
	 * @param browserName
	 * @return this returns the driver instance 
	 */
	public WebDriver launchBrowser(String browserName) {
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
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser ...");
			throw new AutomationException("INVALID BROWSER");
		}
		
		return driver;
	}
	
	/**
	 * This method is used to launch the URL
	 * @param url
	 */
	public void launchURL (String url) {
		if(url == null) {
			System.out.println("URL IS NULL");
			throw new AutomationException("NULL URL");
		}
	/* Note on "if (url.indexOf("http")
	 * 		https://www.S_Tech.com 
	 *--> Don’t use .contains method. Say we want to give the example of Https. This word could come anywhere in
	 *  the URL and the .contains method will check it. So better idea is to use indexOf method. 
	 *  --> http will also capture https.
	 */
		if(url.indexOf("http") == 0) {
			driver.get(url);
		}
		else {
			throw new AutomationException("HTTP is missing");
		}
	}
	
	public void launchURL (URL url) {
		if(url == null) {
			System.out.println("URL IS NULL");
			throw new AutomationException("NULL URL");
		}
		driver.navigate().to(url);
	}
	
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page Title is: " + title);
		return title;
	}
	
	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public boolean getPageSource(String value) {
		String pageSource = driver.getPageSource();
		if(pageSource.contains(value)) {
			return true;
		}
		return false;
	}
	
	public void closeBrowser() {
		driver.close();
		System.out.println("Browser is closed.");
	}
	
	public void quitBrowser() {
		driver.quit();
		System.out.println("Browser is quitted.");
	}
}
