package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://jqueryui.com/resources/demos/droppable/default.html 
			3.	Drag the source element "Drag me to my target" into target element "Drop here".
			4.	Close the driver.
		We can perform this task using two approaches:
			1: Builder pattern method. Here, series of actions are considered
			2: Directly using drag and drop
		*/
		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		// 1: Builder Pattern Method
		Actions act = new Actions(driver);
		
		WebElement sourceElement = driver.findElement(By.cssSelector("div#draggable"));
		WebElement targetElement = driver.findElement(By.cssSelector("div#droppable"));
		
	    act
			.clickAndHold(sourceElement)
				.moveToElement(targetElement)
					.release(targetElement) // We can also ignore supplying targetElement into the release method. Because we have already move to target element by using moveTo method.
						.build()
							.perform();
	    
	    // ************** Drag and Drop Method *********************//
//		act.dragAndDrop(sourceElement, targetElement).build().perform();
		driver.close();
	}

}
