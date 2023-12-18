package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Open the Browser
			2.	Navigate to https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/ 
			3.	Scroll down to "Vehicle registration" form.  --> just to look the image
			4.	Click on the registration form. Which is an image and wait for 10 seconds
			5.	Wait 10 seconds for iframe to be completely loaded then switch to the frame. *** you don’t need to explicitly 
				switch to iframe, the frameTobeAvailableAndSwitchToIt() method will internally switch to iframe automatically.
			6.	Wait for 5 seconds for "Proposal title" text field and send some keys.
				Test_data = S-Tech Industrial Contract
			7.	Capture this text. "Vehicle Registration Form". Since this text is out of the iframe, we will have to 
				switch back to main frame.
			8.	Close the browser.
			
		Note: Don’t forget to develop a utility for iframe, try to include its four variations in Utilities like
			--> FrameByLocator
			-->	FrameByIndex
			-->	FrameByID_OR_Name
			-->	FrameByWebElement
		 */
		
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
	
		By image = By.cssSelector("div#imageTemplateContainer img");
		By frame = By.xpath("//iframe[contains(@id,'frame-one')]");
		By proposalTitle = By.id("RESULT_TextField-1");
		By header = By.cssSelector("h3.details__form-preview-title");
		
		waitForVisibilityOfElement(image, 10).click();
		
		// Rough Code
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
		// Utility Approach
		waitForFrameByLocator(frame, 10);
		
		waitForVisibilityOfElement(proposalTitle, 5).sendKeys("S_Tech Industrial Contract");
		driver.switchTo().defaultContent();
		String headerValue = waitForVisibilityOfElement(header, 0).getText();
		System.out.println("Header of the page is: " + headerValue);

	}
	
	//************* Generic Methods *********************//
	
	public static void waitForFrameByLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static void waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameByIDOrName(String IDOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IDOrName));
	}
	
	public static void waitForFrameByElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	

	public static WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
