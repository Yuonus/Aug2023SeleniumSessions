package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://selectorshub.com/xpath-practice-page/
			3.	Single Selection:
				Single selection is having two scenarios:
					i.	Click on "Denmark". Denmark is already in the first page. No need to keep clicking the "Next" button. 
					ii.	What if you want to click on the country which is not on the first page, then you will have to 
						keep clicking the "Next" button until you get the country and stop moving ahead. 
						(Stop clicking "Next" button). The pagination concept starts from here 
						Test_data: Click on "Ukraine"
					iii. If the country is not available. 
						Test_data: Sabawoon
			4.	Multiple Selection:
			Go to / paginate to each page and select India
			5.	Close browser.

		 */
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);

		//****************** Single Selection *********************//
//		while (true) {
//			// if element is on the first page
//			if (driver.findElements(By.xpath("//td[text()='Ukraine']")).size() > 0) {
//				selectCountry("Ukraine");
//				break;
//			} else {
//				// Pagination logic starts here
//				// Click on "Next" button
//				WebElement next = driver.findElement(By.linkText("Next"));
//				if (next.getAttribute("class").contains("disabled")) {
//					System.out.println("Pagination is over ... Country is not found ...");
//					break;
//				}
//
//				next.click();
//				Thread.sleep(1000);
//			}
//		}
		
		
		// ************************** Multiple Selection **************************//
		
		while (true) {
			// If element is on the first page
			if(driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
				selectMultipleCountries("India");
			}
			// Pagination Logic:  --> Click on "Next" button
			WebElement next = driver.findElement(By.linkText("Next"));
			if (next.getAttribute("class").contains("disabled")) {
				System.out.println("Pagination is over ... Country is not found ...");
				break;
			}
			
			next.click();
			Thread.sleep(1000);
		}

		
		
	}
	
	// Generic Method for a single selection & single country click. As we have used findElement()
	public static void selectCountry(String countryName) {
		driver.findElement(By.xpath("//td[text()='" + countryName + "']/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

	public static void selectMultipleCountries(String countryName) {
		List<WebElement> elements = driver.findElements(
				By.xpath("//td[text()='" + countryName + "']/preceding-sibling::td/input[@type='checkbox']"));
		for (WebElement e : elements) {
			e.click();
		}
	}	

}
