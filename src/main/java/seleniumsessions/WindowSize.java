package seleniumsessions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSize {
	
	public static void main(String[] args) {
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://www.amazon.com
			3.	Get the Default/current size of the browser window. Please note default size depends on your screen size.
			4.	Set the new size for the window and then capture the newest sizes to see if they are matching or not
			5.	Close the browser 
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		Dimension currentDimension = driver.manage().window().getSize();
		
		//Getting the Default / current size of the browser window
		int height = currentDimension.getHeight();
		int width = currentDimension.getWidth();
		System.out.println("Current height: "+ height);
		System.out.println("Current width: "+width);
		
		
		// Setting the new size of browser window
		Dimension dim = new Dimension(800, 500);
		driver.manage().window().setSize(dim);
		
		// we can also directly set the size of the browser window in one line
//		driver.manage().window().setSize(new Dimension(800, 500));
		
		// Printing new window dimensions --> Testing to see if the new window sizes are really added or not
		Dimension newSetDimension = driver.manage().window().getSize();
		int newHeight = newSetDimension.getHeight();
		int newWidth = newSetDimension.getWidth();
		System.out.println("Current height: "+ newHeight);
		System.out.println("Current width: "+newWidth);
		
		
	}

}
