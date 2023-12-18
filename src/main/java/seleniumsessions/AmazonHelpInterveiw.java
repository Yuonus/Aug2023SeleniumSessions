package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHelpInterveiw {
	static WebDriver driver;
	public static void main(String[] args){
		
			/*			TASK
				1.	Go to amazon. https://www.amazon.com/
				2.	Scroll down to footer links "Back to Top" section.
				3.	Verify the "Help" link is in the last column and it is the last value of the last column
				    Note: Pretend that "Help" is always the last element of the last column. It does not move 
				    anywhere else in the footer.
				4.	Get the text of "Help" link and print it to console
				5.	Validate if the actual text is equals to expected text.
				6.	Close the driver
			Note:
			if amazon doesn't allow you to automate then go with freshworks.com
			*/
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		WebElement text = driver.findElement(By.xpath("((//div[@class='navFooterLinkCol navAccessibility'])"
				+ "[last()]//a)[last()]"));
		String linkText = text.getText();
		System.out.println("Help link text is: " + linkText);
		if(linkText.equals("Help")) {
			System.out.println("Test PASS");
		}else {
			System.out.println("Test FAIL");
		}
		
//
//		driver.get("https://www.freshworks.com/");
//		WebElement text = driver.findElement(By.xpath("((//div[@class='sc-6293d692-0 eNMhGa'])"
//				+ "[last()]//a)[last()]"));
//		String linkText = text.getText();
//		System.out.println("Freddy AI link text is: " + linkText);
//		if(linkText.equals("Freddy AI")) {
//			System.out.println("Test PASS");
//		}else {
//			System.out.println("Test FAIL");
//		}
	}
	
}
