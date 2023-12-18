package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMenuHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://www.bigbasket.com/ 
			3.	Click on "Shop by Category".
			After clicking put one second wait time so the other menu item displays on the screen.
			4.	Hover the mouse over the "Beverages"
			5.	After Beverages, hover the mouse over the "Tea"
			6.	After Tea, click on "Green Tea"
			7.	Create a generic function for it and then move it to ElementUtil class.
			8.	Close driver.
			Use these other combinations with Utility, to see if it is working or not.
				Fruits & Vegetables		--> Mouse Hover
				Fresh Fruits			--> Mouse Hover
				Mangoes	
		*/
		
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		
		By parentMenuShopBy = By.xpath("(//span[text()='Shop by'])[2]");
		By beveragesSecondMenu = By.linkText("Fruits & Vegetables");
		By teaThirdMenu = By.linkText("Fresh Fruits");
		By greenTeaFourthMenu = By.linkText("Mangoes"); 
		
		
		//************ Rough Code Approach ***************//
//		Actions act = new Actions(driver);
//		driver.findElement(parentMenuShopBy).click();
//		Thread.sleep(1000);
//		
//		act.moveToElement(driver.findElement(beveragesSecondMenu)).build().perform();
//		Thread.sleep(1000);
//		
//		act.moveToElement(driver.findElement(teaThirdMenu)).build().perform();
//		Thread.sleep(1000);
//		
//		driver.findElement(greenTeaFourthMenu).click();
//		driver.close();
		
		//*************************** Utility Approach *****************//
		
		multiMenuHandle(parentMenuShopBy, beveragesSecondMenu, teaThirdMenu, greenTeaFourthMenu);
		driver.close();
	}
	
	//**** Utility / Generic Function ****//
	public static void multiMenuHandle(By parentMenuLocator, By firstChildMenuLocator, 
			By secondChildMenuLocator, By thirdChildMenuLocator) throws InterruptedException {
		
		Actions act = new Actions(driver);
		driver.findElement(parentMenuLocator).click();
		Thread.sleep(1000);
		
		act.moveToElement(driver.findElement(firstChildMenuLocator)).build().perform();
		Thread.sleep(1000);
		
		act.moveToElement(driver.findElement(secondChildMenuLocator)).build().perform();
		Thread.sleep(1000);
		
		driver.findElement(thirdChildMenuLocator).click();
	}
	
	// We can also develop the above the utility in builder pattern approach as well.
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void multiMenuHandle1(By parentMenuLocator, By firstChildMenuLocator, 
			By secondChildMenuLocator, By thirdChildMenuLocator) throws InterruptedException {
		
		Actions act = new Actions(driver);
		act.click(getElement(parentMenuLocator))
			.pause(500)
				.moveToElement(getElement(firstChildMenuLocator))
					.pause(500)
						.moveToElement(getElement(secondChildMenuLocator))
							.pause(500)
								.click(getElement(thirdChildMenuLocator)).build().perform();
	
	}

}
