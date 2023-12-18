package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassicCRMWebTable {
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
		driver.get(" https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("S_Tech");
		driver.findElement(By.name("password")).sendKeys("Selenium11");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
//		driver.findElement(By.linkText("Contacts")).click();  UI --> CONTACTS
		driver.findElement(By.linkText("CONTACTS")).click();
//		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		// Rough CODE Approach
//		driver.findElement(By.xpath("//a[text()='Samantha Young']/parent::td/"
//				+ "preceding-sibling::td/input[@type='checkbox']")).click();
		
//		WebElement userCompany = driver.findElement(By.xpath("//a[text()='Samantha Young']//parent::td/"
//				+ "following-sibling::td/a[@context='company']"));
//		System.out.println("User Company name is: " + userCompany.getText());
		
		// Utilities
		selectUser("Samantha Young"); 
		selectUser("Abaseen Yuonus");
		
		String comName = getUserCompanyName("Samantha Young");
		System.out.println(comName);
		String compName = getUserCompanyName("Abaseen Yuonus");
		System.out.println(compName);
		
	
		driver.close();
		// classic CRM
		//a[text()='Samantha Young']/parent::td/preceding-sibling::td/input[@type='checkbox']
//		following sibling Xpath 
		//table[@class='datacard']//a[text()='Samantha Young']//parent::td/following-sibling::td/a[@context='company']
	}
	
	// Utilities
	
	public static void selectUser(String userName) {
		driver.findElement(By.xpath("//a[text()='"+userName+"']/parent::td/preceding-sibling::td"
				+ "/child::input[@type='checkbox']")).click();
	}
	
	public static String getUserCompanyName(String userName) {
		return
			driver.findElement(By.xpath("//a[text()='"+userName+"']//parent::td/following-sibling::td/a[@context='company']"))
				.getText();
	}
}
