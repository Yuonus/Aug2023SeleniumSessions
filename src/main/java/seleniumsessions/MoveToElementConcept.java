package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to http://mrbool.com/search/?textsearch=how-to-create-menu-with-submenu-using-css-html
			3.	Hover the mouse over the "CONTENT" 
			4.	Wait for two seconds to give the time for selenium to interact with child menu items.
			5.	Click on "COURSES"
			6.	Close the driver
	As always write/develop a generic method for parent and child menu so it could work for 
	any other application and move it to "ElementUtil" class.
		*/
		
		driver = new ChromeDriver();
		driver.get(" http://mrbool.com/search/?textsearch=how-to-create-menu-with-submenu-using-css-html");
		
		//************* Rough Code Approach ******************//
//		Actions act = new Actions(driver);
//		
//		By parentMenu = By.cssSelector("a.menulink");
//		WebElement parentMenuLocator = driver.findElement(parentMenu);
//		
//		act.moveToElement(parentMenuLocator).build().perform();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.linkText("COURSES")).click(); // In the UI the link Text is in capital letters "COURSES" so 
////		we will have to give the preference to UI "COURSES". But if you use Xpath, you dont need to use Capital letter.
//		
//		driver.close();
//		
//		act.action1.action2.action3.action4.build().perform();  ---> Valid
//		act.a1.build().perform();	---> Valid
//		act.a1.build();	--> Invalid
//		act.a1.perform(); 	--> Valid
		
		
		//******************* Utility Approach *********************//
		
		By parentMenuLocator = By.cssSelector("a.menulink");
		By childMenuLocator = By.linkText("COURSES"); // U can pass any other childMenu options like: ARTICLES, SINGLE VIDEOS
		parentChildMenu(parentMenuLocator, childMenuLocator);
		driver.close();
	}
	
	public static WebElement getElement(By lcoator) {
		return driver.findElement(lcoator);
	}
	
	public static void parentChildMenu(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).build().perform();
		Thread.sleep(2000);
		driver.findElement(childMenuLocator).click();
	}

}
