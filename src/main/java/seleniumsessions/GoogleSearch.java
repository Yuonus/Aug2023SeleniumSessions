package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		/*			Business Case / Test Scenario
		 		Automate this task both Rough code Approach and Utility code Approach
		 	1: Open Google.com
		 	2: Enter some value in Search field. U can put any Search Key -> "Selenium Automation"
		 	3: Use Thread.sleep() method: To give google server some times to generate the suggestions
		 	4: Find the number of suggestions popped up.
		 	5: Capture the text of each suggestion and print it to console.
		 	6: Click on a specific result/suggestion. (for instance: selenium automation tester jobs)
		 	7: Close the browser.
		 	8: --> Don't forget to move the utility in to the "ElementUtil" class
		 */
	
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		// Rough Code Approach
//		driver.findElement(By.name("q")).sendKeys("Selenium Automation");
//		Thread.sleep(3000);
//		
//		List<WebElement> suggList = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));
//		System.out.println("Number of suggestion available at Search keys are :" + suggList.size());
//		
//		for (WebElement e : suggList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.contains("tester jobs")) {
//				e.click();
//				break;
//			}
//		}
		
		// Using Utility Approach
		By searchField = By.name("q");
		By suggestions = By.xpath("//div[@class='wM6W7d']/span");
		
		search(searchField, suggestions, "Selenium Automation", "tester jobs");
		driver.close();
		
		/*
		 1: U can add any SearchKey and SuggName with this given utility and it will automate it for you
		 2: Try with "Global warming" as SearchKey and "news" as suggName
		 3: or, Select any search key and opt one of the suggestions and click on it
		 */
//		search(searchField, suggestions, "global warming", "news");
	}
	
	public static void search(By searchField, By suggestions, String searchKey, String suggName ) throws InterruptedException {
		driver.findElement(searchField).sendKeys(searchKey);
		Thread.sleep(3000);
		
		List<WebElement> suggList = driver.findElements(suggestions);
		System.out.println("Number of suggestion available at Search keys are :" + suggList.size());
		
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains(suggName)) {
				e.click();
				break;
			}
		}
	}
//	Note: if the e.click(), and break is enabled the print out sentence will give u  5 or sometimes 7 
//	suggestions into the console, but if you comment them both, it will give you 10 suggestions

}
