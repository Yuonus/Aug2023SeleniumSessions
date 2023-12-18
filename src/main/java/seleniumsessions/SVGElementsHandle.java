package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElementsHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Launch the URL
			2.	Navigate to https://www.flipkart.com/ 
			3.	Type "MacBooks" in search field
			4.	Click on the "search SVG" icon
	In Selenium, SVG elements are identified with the following methods: 
		local-name():
		name():

		 */
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("Macbooks");
		driver.findElement(By.xpath("//span[@role='button']")).click();
//		driver.findElement(By.xpath("//*[local-name()='svg' and @height='24']")).click(); u can also use name() method
		driver.findElement(By.xpath("//*[name()='svg' and @height='24']")).click();
		driver.close();
		
		
	}

}
