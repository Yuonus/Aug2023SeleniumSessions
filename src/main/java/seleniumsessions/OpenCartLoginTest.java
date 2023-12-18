package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartLoginTest {
	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil(); 
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		brUtil.getPageTitle();
		
		ElementUtil eleUtil = new ElementUtil(driver);
		By eId = By.id("input-email");
		By pwd = By.id("input-password");
		
		eleUtil.doSendKeys(eId, "S_Tech@gmail.com");
		eleUtil.doSendKeys(pwd, "Test123");
		
		brUtil.closeBrowser();
		
		
	}

}
