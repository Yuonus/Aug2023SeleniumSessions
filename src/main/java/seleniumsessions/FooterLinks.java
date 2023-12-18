package seleniumsessions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterLinks {
	
	static WebDriver driver;
	public static void main(String[] args) {
		/*				Business Case / Test Scenario
		 	Automate this BC both with rough code and using the utility
			1: Launch the browser
			2: Navigate to / Launch the URL. "https://naveenautomationlabs.com/opencart/"
			3: Capture the Total numbers of Links from the footer.
			4: Capture the text of each and every links and print it to the console.
			5: Close the driver.
			
		Note:
			Validate if the text links are matching the UI texts or not.
			Validate one text link from each four
		 */
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		By footerLinks = By.xpath("//footer//a");
		
//		List<WebElement> footerLinksList = driver.findElements(footerLinks);
//		System.out.println("Total numbers of links in page footer section are: " + footerLinksList.size());
//		
//		for(WebElement e : footerLinksList) {
//			String linksText = e.getText();
//			System.out.println(linksText);
//		}
		
		// 2nd Approach Using the ElementUtil class
		ElementUtil eleUtil = new ElementUtil(driver);
		int eleLinksCount = eleUtil.getElementsCount(footerLinks);
		System.out.println("Total numbers of links in page footer section are: " + eleLinksCount);
		
		List<String> actFooterLinksText = eleUtil.getElementsTextList(footerLinks);
		for(String e : actFooterLinksText) {
			System.out.println(e);
		}
		
		List<String> expectedFooters = Arrays.asList("About Us", "Returns", "Specials", "Wish List" );
		if(actFooterLinksText.containsAll(expectedFooters)) {
			System.out.println("Important footer links --- pass");
		}

		driver.close();
		
	}

}
