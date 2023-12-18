package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		/*
			TASK 1
				1.	Navigate to https://selectorshub.com/xpath-practice-page/
				2.	Scroll down to "Users Table"
				3.	Click on the check box for "Joe Root", or any other user name.
				4.	What is the user role of "Joe Root"? locate and print it to console.
				5: 	What are all the other properties for "Joe Root"
				5.	Close the driver
			Create a utility so you can supply rest of the users’ name easily.
		*/
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(3000);
		
//		Rough Code Approach
//		driver.findElement(By.xpath("//a[text()='Joe.Root']/parent::td/preceding-sibling::td"
//				+ "/child::input[@type='checkbox']")).click();
//		WebElement joeUserRole = driver.findElement(By.xpath("//a[text()='Joe.Root']/parent::td/"
//				+ "following-sibling::td[text()='ESS']"));
//		// for the xpath you can also use the capturing Group idea, but the first one is more stable
////		(//a[text()='Joe.Root']/parent::td/following-sibling::td)[1]
//		System.out.println("Joe Root user role is: " + joeUserRole.getText());
//		
//		List<WebElement> columnValues = driver.findElements(By.xpath("//a[text()='Joe.Root']/parent::td/following-sibling::td"));
//		for(WebElement e : columnValues) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		// Utility Approach
		selectUser("Joe.Root");
		selectUser("John.Smith");
		selectUser("Garry.White");
		selectUser("Kevin.Mathews");
		
		List<String> joeDetails = getUserInfo("Joe.Root");
//		System.out.println(joeDetails); // if you want to print Joe Details vertically, use for loop
		for(String e : joeDetails) {
			System.out.println(e);
		}
		
		driver.close();
		
	}
	
	
	// utility methods
	public static void selectUser(String userName) {
		driver.findElement(By.xpath("//a[text()='"+userName+"']/parent::td/preceding-sibling::td"
				+ "/child::input[@type='checkbox']")).click();
	}
	
	public static List<String> getUserInfo(String userName) {
		List<WebElement> colEle = driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
		List<String> colValuesList = new ArrayList<String>();
		for(WebElement e : colEle) {
			String text = e.getText();
			colValuesList.add(text);
		}
		return colValuesList;
	}
	
}
