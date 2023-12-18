package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		/*		Test Scenario --> Use String Approach
		 	1: Launch the browser
		 	2: Launch the URL. "https://naveenautomationlabs.com/opencart/index.php?route=account/login"
		 	3: Locate the "E-Mail Address" and send keys. "S_Tech@gmail.com"
		 	4: Locate the "Password" text field and send keys. "Test123"
		 	5: Locate the "Login" button and click on it.
		 	6: Locate the "Register" link and get the text out of it.
		 */
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String email_Id = "input-email";
		String password_Id = "input-password";
		String loginBtn_Xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input";
		String register_linkText= "Register";
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", email_Id, "S_Tech@gmail.com");
		eleUtil.doSendKeys("id", password_Id, "Test123");
//		eleUtil.doClick(loginBtn_Xpath); doClick() with String is not availabe. So, we have to overload this 
//		method in ElementUtil class.
		eleUtil.doClick("xpath", loginBtn_Xpath);
		String registerValue = eleUtil.doElementGetText("linktext", register_linkText);
		System.out.println(registerValue);
		
		// Conclusion
//		90 % out of 100 % will be using "By locator" Approach in real world jobs. I personally also prefer to
//		work "By locator" Approach. but it is better to know both Approaches, in case you are hired by 
//		a company that uses String approach.
		
		
	}

}
