package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Open the Browser
			2.	Navigate to http://www.londonfreelance.org/courses/frames/index.html 
			3.	Capture the text "Title bar (top.html)".
			4.	While switching to the frame use all three approaches index, id & name, web element. 
				To interact with frame elements.
			5.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
//		driver.switchTo().frame(2);  frame(index)
//		driver.switchTo().frame("main"); --> frame(Name)
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']"))); // --> frame(web element)
		String text = driver.findElement(By.xpath("//h2[text()='Title bar ']")).getText();
		System.out.println(text);
	}

}
