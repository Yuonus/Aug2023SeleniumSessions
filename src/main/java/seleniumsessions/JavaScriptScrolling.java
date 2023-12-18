package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptScrolling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		Thread.sleep(1500);
		
		//****** ROUGH CODE WORK ************//
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(1500);
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
		Thread.sleep(1500);
		js.executeScript("window.scrollTo(0, 700)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0, -300)");
		Thread.sleep(1500);
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
		Thread.sleep(1500);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
		Thread.sleep(1500);
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
		Thread.sleep(1500);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight*3/4);");
//		driver.close();
		
		
		// ****** Utility Approach *******//
//		scrollPageDown();
//		Thread.sleep(1500);
//		scrollPageUp();
//		Thread.sleep(1500);
//		scrollPageDown("2000");
//		Thread.sleep(1500);
//		scrollPageDown("-1000");
//		Thread.sleep(1500);

	}
	
	//****************utilities***************//
	
	public static void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public static void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
	}
	
	public static void scrollPageDown(String height) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, '"+height+"');");
	}
	
}
