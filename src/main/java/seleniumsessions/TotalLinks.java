package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {
	
	public static void main(String[] args) {
		/*			Test Scenarios
			1: Launch the Browser
			2: Launch the URL. "https://www.amazon.com/"
			3: Find the Total numbers of links available in Amazon homepage.
			4: Capture the text of each link, and ignore the blank text links.
			5: Capture the "href" value from each and every link
			6: close the driver.
			
		Hints:
		--> As it is asking for all the page links, and all links are having <a> anchor tag in common, Then we
			can locate/create the web elements using tagName locator.
		--> Finish all the coding and perform bullet number 5 requirement at the end.
			
		Problem:
		--> Amazon is throwing a CAPTCHA. So, it makes it difficult to showcase the blank spaces, it is better 
			idea to go with ebay.com.
			Ebay URL = "https://www.ebay.com/"
			
		Conclusion:
			--> Capturing link texts, href values, URL values of each and every element ... etc. is called 
				Web Scraping.

		 */

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("Total links on the page are: " +  linksList.size());
//		for(int i = 0; i<linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//				if(text.length()!=0) {
//					System.out.println(i + " :" + text);
//				}
//		}
		
		for(WebElement e : linksList) {
			String text = e.getText();
//			we can also use .isBlank metho to check for blank spaces.
				if(!text.isBlank()) {
					String hrefVal = e.getAttribute("href");
					System.out.println(text + "-->" + hrefVal);
				}
		}
	}

}
