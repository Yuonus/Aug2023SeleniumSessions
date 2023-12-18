package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEvents {
	static WebDriver driver;
	public static void main(String[] args) {
		
		/*		Business Case
			1.	First, navigate to "https://demoqa.com/text-box"
			2.	Secondly, enter the Full name: "Sabawoon Yuonus".
			3.	Thirdly, enter the Email: "YuonusS@gmail.com"
			4.	After that, Enter the Current Address: "5001 Seminary rd., Alexandria VA"
			5.	Fifthly, select all Current Address text box and Copy the Current Address.
			6.	After that, paste the copied address in the Permanent Address text box.
			7.	Finally, validate that the text in the Current Address and Permanent Address is the same.
		 */
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		Actions action = new Actions(driver);
		driver.get("https://demoqa.com/text-box");
		
		WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
		fullName.sendKeys("Sabawoon Yuonus");
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
		email.sendKeys("YuonusS@gmail.com");
		
		WebElement currentAdd = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
		currentAdd.sendKeys("5001 Seminary rd., Alexandria VA");
		
		currentAdd.sendKeys(Keys.CONTROL, "a");
		currentAdd.sendKeys(Keys.CONTROL, "c");
		
		//Press the TAB Key to Switch Focus to Permanent Address
        currentAdd.sendKeys(Keys.TAB);
        
        WebElement permanentAdd = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAdd.sendKeys(Keys.CONTROL, "v");
        
        if(currentAdd.getText().equals(permanentAdd.getText())) {
        	System.out.println("Test Passed.");
        }else {
        	System.out.println("Test Failed.");
        }
        driver.close();
	}

}
