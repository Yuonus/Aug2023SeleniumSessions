package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.jdi.Method;

public class NestedIframeHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Open the browser
			2.	Navigate to https://selectorshub.com/iframe-scenario/
			3.	Send some keys at "First Crush" input field.
			4.	Send some keys at "Current Crush Name" input field.
			5.	Send some keys at "Destiny" input field.
			6.	Work with different switching back scenarios
			7.	Grab the text "Memory Test" from main page.
			8.	Validate if the test passes or not.
			9.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario/");
		
		// First Frame  --> F1
		driver.switchTo().frame("pact1");
		driver.findElement(By.cssSelector("input#inp_val")).sendKeys("Becoming a professional Test Automation Engineer");
		
		// Second Frame  --> F2
		driver.switchTo().frame("pact2");
		driver.findElement(By.cssSelector("input#jex")).sendKeys("Automation with Selenium");
		
		// Third Frame	--> F3
		driver.switchTo().frame("pact3");
		driver.findElement(By.cssSelector("input#glaf")).sendKeys("Having the best SDET School in USA");
		
		//*******************Switching back Approaches *************************//
		
//		F3 -> F1		not Valid
//		driver.switchTo().frame("pact1");
//		driver.findElement(By.cssSelector("input#inp_val")).sendKeys("Becoming a professional Test Automation Engineer");
		
//		F3 -> F2 -> F1	Not Valid
//		driver.switchTo().frame("pact2");
//		driver.switchTo().frame("pact1");
//		driver.findElement(By.cssSelector("input#inp_val")).sendKeys("Becoming a professional Test Automation Engineer");
		
//		F3 -> F2		--> Not Valid
//		driver.switchTo().frame("pact2");
//		driver.findElement(By.cssSelector("input#jex")).sendKeys("Automation with Selenium v2.0");
		
//		Lesson taken: We cannot switch back in iframes using "driver.switchTo(). frame();" Method. This method only moves 
//		forward, meaning it is a unidirectional method.
		
//		F3 -> F1 	Not Valid
//		driver.switchTo().parentFrame(); // This method will switch back to immediate parent
//		driver.findElement(By.cssSelector("input#inp_val")).sendKeys("Becoming a professional Test Automation Engineer");
		
//		F3 -> F2	--> Valid
		driver.switchTo().parentFrame();
		driver.findElement(By.cssSelector("input#jex")).sendKeys(" Automation with Selenium v2.0");
		
//		F2  -> F1	--> Valid
		driver.switchTo().parentFrame();
		driver.findElement(By.cssSelector("input#inp_val")).sendKeys(" Becoming a professional Test Automation Engineer V2.0");
		
		// F3 -> Main Page:  We can directly switch from F3 - main page using following method
		driver.switchTo().defaultContent();
		String mainPageText = driver.findElement(By.xpath("//h3[text()='Memory Test']")).getText();
		System.out.println("Main page text is: " + mainPageText);
		if(mainPageText.equals("Memory Test")) {
			System.out.println("Test --- PASS");
		}else {
			System.out.println("Test --- FAIL");
		}
		
		driver.close();
	}

}
