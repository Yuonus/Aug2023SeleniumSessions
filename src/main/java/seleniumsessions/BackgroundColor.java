package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackgroundColor {
	public static void main(String[] args) {
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://classic.crmpro.com/ 
			3.	Capture the background color of "Login" element
			4.	Find the height & width of the "Login" element. To find the height and width of an element we can use 
				getRect() method.
			5.	Close the browser
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		WebElement element = driver.findElement(By.xpath("//input[@type='submit']"));
		String bgColor = element.getCssValue("background-color"); // Will return rgba format --> rgba(86, 61, 124, 1)
		// U can also pass --> getCssValue("backgroundColor"); <-- without any dash
		
//		String bgColor = element.getCssValue("background"); // Will return rgba format --> rgb(86, 61, 124)
		System.out.println(bgColor);
		
		// finding Height & Width of "Login" element
		Rectangle ele_size = element.getRect(); // getRect() returns The location and size of the rendered element, import Rectangle from selenium
		System.out.println(ele_size.getHeight());
		System.out.println(ele_size.getWidth());
		
		// location of the "Login" element
		System.out.println(ele_size.getX());
		System.out.println(ele_size.getY());
		
		/*
			 X location = 888
			 Y location = 105
		 Note: These dimension are not fixed, they depend on the screen size of one's machine. bigger screen bigger 
		 dimensions and smaller screens, smaller dimensions sizes
		 */
		
		// You can easily capture the location using getLocation() method as well
		System.out.println(element.getLocation());
		
	}
}
