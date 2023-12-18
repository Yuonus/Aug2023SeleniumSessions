package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDownHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://jqueryui.com/selectmenu/
			3.	Switch the driver attention to the iframe
			4.	Click on "Select a speed" dropdown
			5.	Find out / verify how many items are there in the dropdown
			6.	Print all the items/options of dropdown to the console.
			7.	Click on any option of the dropdown
			8.	Close the driver.
		*/
		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectmenu/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame"))); // web element 
//		driver.switchTo().frame(0); // since we only have iframe in the page, we can also use index
		Thread.sleep(2000); // Wait is added to see the dropdown
		driver.findElement(By.xpath("//span[text()='Medium']")).click();
		Thread.sleep(3000); // wait is added to see the dropdown expansion
		List<WebElement> optionsList = driver.findElements(By.cssSelector("ul#speed-menu li"));
		System.out.println("Total numbers of options available in the dropdown are: " + optionsList.size());
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals("Fast")) {
				e.click();
				break;
			}
		}
		
		driver.close();
		
		
		// Assignment
//		driver.findElement(By.xpath("//span[text()='jQuery.js']")).click();
//		Thread.sleep(3000);
//		List<WebElement> optionsList = driver.findElements(By.cssSelector("ul#files-menu li"));
//		System.out.println(optionsList.size());
//		for(WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("Some unknown file")) {
//				e.click();
//			}
//		}
//		driver.close();
	}
	

}
