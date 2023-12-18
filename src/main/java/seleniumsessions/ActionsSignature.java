package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSignature {
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException{
			
			/*		Business Case
				1.	Launch the browser
				2.	Navigate to https://signature-generator.com/draw-signature/ 
				3.	Automate a signature using your selenium skills.
				4.	Close the browser.
			 */
			
			driver = new ChromeDriver();
			driver.get("https://signature-generator.com/draw-signature/");
			WebElement canvas = driver.findElement(By.cssSelector("canvas#signature-pad"));
			Actions act = new Actions(driver);
			
			act.click(canvas)
			.moveToElement(canvas, 30, 10)
			.clickAndHold(canvas)
			.moveToElement(canvas,20,-50)
            .moveByOffset(50, 50)
            .moveByOffset(80,-50)
            .moveByOffset(100,50)  
			.release(canvas)
			.build().perform();
			driver.close();
			
		}
}
