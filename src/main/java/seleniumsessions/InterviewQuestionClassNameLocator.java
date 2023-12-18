package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewQuestionClassNameLocator {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("S_Tech");
	}
	
	/*
		Can we pass multiple classes with "By.className()" locator?
		No, we cannot pass multiple classes with "By.className()" locator. "By.className()" can only accept one
		class.Further more, find elements based on the value of the "class" attribute. Only one class name 
		should be used. If an element has multiple classes, please use By.cssSelector(String).
		But remember that compound classes are allowed with Xpath.
		And in CSS you will have replace the spaces with dots

		What happens if you still try to locate a web element with "By.className()" locator that has multiple 
		classes?
		The program will throw Invalid Selector Exception
	 */


}
