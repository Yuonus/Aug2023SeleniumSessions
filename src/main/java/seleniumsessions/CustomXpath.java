package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	static WebDriver driver;
	public static void main(String[] args){
		
		driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
//		
		
		//Xpath = 
		// 1. Absolute xpath = /html/body/div[2]/div/div/div[2]/div[2]/div/div[2]/h4/a
		// 2. Relative Xpath = 
		
		// Relative Xpath formula
		//tagName[@attribute='value']
		//input[@type='text']
		//input[@placeholder='E-Mail Address']
		
		// Joining two or more Attributes using "and" & "or" logical operators
//		XPath=//tagname[@attribute1='value1' and @attribute2='value2'] 
		//input[@type='text' and @class='form-control input-lg']  --> Target -> "1 of 1"
		//input[@type='text' and @class='form-control input-lg' and @placeholder='Search'] --> "1 of 1"
		//input[@type='text' or @type='email' or @type='password'] --> "1 of 6"
		
//						Xpath Queries
		//input[@id] --> 1 of 6 --> findElements() will be used here.
		//a --> 81 links
//		int registerPageLinksCount = driver.findElements(By.xpath("//a")).size();
//		System.out.println(registerPageLinksCount);
		
		//input[@id and @type] --> 1 of 6
		
		// The assignment that I gave u guys about right side panel links
		// we will solve it using xpath combination now.
		//a[@class='list-group-item']
		
//		List<WebElement> linksList = driver.findElements(By.xpath("//a[@class='list-group-item']"));
//		// We can also use By.className locator
////		List<WebElement> linksList = driver.findElements(By.className("list-group-item"));
//		System.out.println(linksList.size());
//		for(WebElement e : linksList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
			//tagName[@attribute='value']
			//*[@attribute='value']
		
		//* --> Total number of the elements on the page 315
		//input[@class='form-control'] **> 1 of 14
		//*[@class='form-control'] **> 1 of 315
		
		//input[@value]
		
		/*	TASK 1
		 	Formula //tagname[text(),'Text of the Web Element']
		 	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
			Capture the text of "Returning Customer"
			Print the captured text
		 */

//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		WebElement text = driver.findElement(By.xpath("//h2[text()='Returning Customer']"));
//		System.out.println(text.getText());
		
		/*	TASK 2
	 	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
		Capture the text of "Recurring payments" link
		Print the captured text
	 */
	
//		WebElement RecuPayments = driver.findElement(By.xpath("//a[text()='Recurring payments']"));
//		System.out.println(RecuPayments.getText());
		
//		Task 3:
//			How many Forgotten Password links are there in this page?
//			https://naveenautomationlabs.com/opencart/index.php?route=account/login

//		List<WebElement> forPassLinks = driver.findElements(By.xpath("//a[text()='Forgotten Password']"));
//		System.out.println(forPassLinks.size());
		
		// 			text() with Attributes
		// tagname[text() ='Text of the Web Element' and @attribute='value']
		//a[text()='My Account' and @class='list-group-item']
		//a[@class='list-group-item' and text()='My Account']
		
		// tagname[text() ='Text of the Web Element' and @attribute1='value1' and @attribute2='value2']
		
		// contains () in xpath
		// contains() with attribute
		//contains(@attribute, 'Value')
		
		//input[contains(@placeholder,'E-Mail')]
		//input[contains(@placeholder,'Address')]
		//input[contains(@id,'email')]
		
		//tagname[contains(@attribute1, 'AttValue1') and (@attribute2, 'AttValue2')]
		//input[contains(@id,'email') and (@type='text') and (@name='email')] 
		//input[contains(@id,'email') and (@type='text') and (@name='email') and (@class='form-control')]
		//input[contains(@id,'email') and contains(@class,'form-control')]
		
		//contains() with text()
		
		//tagname[contains(text(),'value')]
		
		//h2[contains(text(), 'Returning')]
		//p[contains(text(),'By creating an account')]
		
		//tagname[contains(text(),'Value') and contains@attribute,'value')]
		//a[contains(text(),'Register') and contains(@class,'list-group-item')]
		//a[contains(text(),'Forgotten Password') and contains(@class,'list-group-item')]
		
//		Contains() can be used with Dynamic Elements:
//		<input id = firstname_123>
//				<input id = firstname_123> 	--> Refresh the page
//				<input id = firstname_124>	--> Refresh the page
//				<input id = firstname_125>	--> Refresh the page
//				<input id = firstname_126>	--> Refresh the page
//		driver.findElement(By.id("firstname_123")).sendKeys("S_Tech"); --> Invalid

		//input[contains(@id,'firstname_')]
		
		 //tagname[starts-with(text(), 'value')]
		//tagname[starts-with(@attribute, 'value')]
		
		//p[starts-with(text(), 'By creating an account')]
		//a[starts-with(text(),'Login') and @class='list-group-item'] --> starts-with combination with attributes
		
		// ends-with in Xpath is deprecated --> not valid now.
		
		// Texts with spaces in Xpath --> normalize-space()
		//tagname[normalize-space(),'text of the web element']
		//label[normalize-space(),'Yes'] --> 1 of 1

		// Capture Group / Group Indexing
//		(//tagname[@attribute='Value'])[1]
//		(//input[@class='form-control'])[3]
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.findElement(By.xpath("(//input[@class='form-control'])[3]")).sendKeys("S_Tech");
		driver.findElement(By.xpath("(//input[@class='form-control'])[last()]")).sendKeys("Sabawoon");
		driver.findElement(By.xpath("(//input[@class='form-control'])[last()-5]")).sendKeys("Sabawoon");
		driver.findElement(By.xpath("(//input[@class='form-control'])[position() = 5]")).sendKeys("Sabawoon");
		driver.findElement(By.xpath("(//input[@class='form-control'])[position() = 2]")).sendKeys("Sabawoon");

		
		
		

		
	}	
}
