package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to "https://swisnl.github.io/jQuery-contextMenu/demo.html" 
			3.	Do a right click on "right click me" web element.
			4.	Collect all it is options.
			5.	How many options are there after right clicking.
			6.	Print the text of all the options into the console.
			7.	close the driver.
		*/
		
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		By contextClick = By.xpath("//span[text()='right click me']");
		WebElement rightClick = driver.findElement(contextClick);
		
		Actions act = new Actions(driver);
		act.contextClick(rightClick).perform();
		
		List<WebElement> optionsList = driver.findElements(By.cssSelector("li.context-menu-icon > span"));
		System.out.println("Number of options after right clicking: " + optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text );
			if(text.endsWith("Copy")) {
				e.click();
				break;
			}
		}
		
		driver.close();
		
		
		
	}

}
