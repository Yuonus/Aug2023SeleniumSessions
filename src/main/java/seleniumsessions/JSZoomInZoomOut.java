package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSZoomInZoomOut {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case

		 */
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		Thread.sleep(2000);
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("document.body.style.zoom='140%';");
//		Thread.sleep(2000);
//		js.executeScript("document.body.style.zoom='30%';");
//		driver.close();
		
		
		// *********** Utility *****************//
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		jsUtil.zoomChromeEdgeSagari("150");
		Thread.sleep(2000);
		jsUtil.zoomChromeEdgeSagari("30");

		
	}

}
