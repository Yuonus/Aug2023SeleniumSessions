package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IFrameHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Open the Browser
			2.	Navigate to https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/
			3.	Scroll down to "Vehicle registration" form.
			4.	Fill the registration form. To fill and inspect the form you will have to click on it first. Because it 
				is an image and you won’t be able to fill it. So, once you click on it will be converted to a regular form. 
				Remember do not submit it. Also upload a file.
			5.	Wait for 2 seconds to let the table be loaded
			6.	Switch the driver to iframe
			7.	Capture this text. "Vehicle Registration Form". Since this text is out of the iframe, we will have to 
				switch back to main frame.
			8.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();
//		in Css we have used space between div#imageTemplateContainer and img 
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		
		driver.findElement(By.xpath("//input[@name='RESULT_TextField-1' and @type='text']")).sendKeys("S_Tech Syllabus");
		driver.findElement(By.xpath("//input[@name='RESULT_TextField-3' and @type='text']")).sendKeys("Vienna");
		
		driver.findElement(By.xpath("(//input[@date='mm/dd/yy'])[2]")).sendKeys("11/10/2023");
		
		driver.findElement(By.xpath("//textarea[@id='RESULT_TextArea-5']")).sendKeys
		("S_Tech is the best academy in USA for 10 consecutive years.");
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys
		("C:\\\\Users\\\\syuon\\\\Desktop\\\\Yuonus Resume.docx");
		
		driver.findElement(By.xpath("//input[@size='22' and @name='RESULT_TextField-8']")).sendKeys("Sabawoon");
		driver.findElement(By.xpath("//input[@size='22' and @name='RESULT_TextField-9']")).sendKeys("Yuonus");
		
		driver.findElement(By.xpath("//input[@size='52' and @name='RESULT_TextField-10']")).
		sendKeys("5001 Seminary rd Alexandria VA");
		
		driver.findElement(By.xpath("//input[@size='52' and @name='RESULT_TextField-11']"))
				.sendKeys("Apt#: 1920");
		
		driver.findElement(By.xpath("//input[@size='30' and @name='RESULT_TextField-12']"))
				.sendKeys("Alexandria");
		By state = By.xpath("//select[@id='RESULT_RadioButton-13' and @name='RESULT_RadioButton-13']");
		WebElement stateOptions = driver.findElement(state);
		Select select = new Select(stateOptions);
		List<WebElement> stateList = select.getOptions();
		for(WebElement e : stateList) {
			String text = e.getText();
			if(text.equals("Virginia")) {
				e.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@size='10' and @name='RESULT_TextField-14']"))
				.sendKeys("22311");
		driver.findElement(By.xpath("//input[@type='tel' and @name='RESULT_TextField-15']"))
//			.sendKeys("202-735-6362"); This will cause the number format issue in App UI
		 		.sendKeys("(202) 735-6362");
		driver.findElement(By.xpath("//input[@type='email' and @name='RESULT_TextField-16']"))
		  		.sendKeys("S_Tech@gmail.com");
		
		String todaysDate = driver.findElement(By.xpath("(//input[@date='mm/dd/yy' and @placeholder='mm/dd/yyyy'])[1]"))
				.getAttribute("value");
		System.out.println("Today's data is: " + todaysDate);
		
		driver.switchTo().parentFrame();
		String text = driver.findElement(By.xpath("//h3[text()='Vehicle Registration Form']")).getText();
		System.out.println(text);
	}

}
