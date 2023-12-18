package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://jqueryui.com/resources/demos/slider/default.html
			3.	Find the height and width of the slider element
			4.	Move the slider toward + X direction
			5.	Close the driver.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		
		WebElement slider = driver.findElement(By.cssSelector("div#slider"));
		Actions act = new Actions(driver);
		
		// In order to get the height and width of the slider element use getSize() method.
		
		int sliderWidth = slider.getSize().getWidth();
		int sliderHeight = slider.getSize().getHeight();
		System.out.println("Slider height is: " + sliderHeight + " and slider width is: " + sliderWidth  );
		
		act.clickAndHold(slider).moveByOffset(100, 0).build().perform();

		driver.close();
		
	}

}
