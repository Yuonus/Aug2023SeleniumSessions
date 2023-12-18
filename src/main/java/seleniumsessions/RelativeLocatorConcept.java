package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

public class RelativeLocatorConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://www.aqi.in/dashboard/canada
			3.	Create the base/main element
			4.	Go to the right side of the base element and capture its text. --> AQI-US Index
			5.	Go to the left side of the base element and capture its text. --> Rank
			6.	Go to the above side of the base element and capture its text. --> could be any text
			7.	Go below side of the base element and capture its text. --> could by any text
			8.	Go to the nearest element of the base element and capture its text. --> could by any text
			9.	Go to the 2nd nearest element of the base element and capture its text. --> could by any text
			10.	Capture all the cities below "Rouyn Noranda, Canada".
				--> Use driver.findElements() method
				--> And start from index 4.
			10.	Close the browser
		 */
		
		driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		
		Thread.sleep(5000);
		WebElement baseElement = driver.findElement(By.linkText("Rouyn Noranda, Canada"));
//		WebElement baseElement = driver.findElement(By.xpath("(//a[text()='Rouyn Noranda, Canada'])[1]"));
		
		// right of base element
		String  rightIndex = driver.findElement(with(By.tagName("p")).toRightOf(baseElement)).getText();
		System.out.println("The AQI-US Index of Rouyn Noranda, Canada is: " + rightIndex);
		
		// left of base element
		String  leftIndex = driver.findElement(with(By.tagName("p")).toLeftOf(baseElement)).getText();
		System.out.println("The Rank of Rouyn Noranda, Canada is: " + leftIndex);
		
		// above of base element
//		String aboveEle = driver.findElement(RelativeLocator.with(By.linkText("Oshawa, Canada")).above(baseElement)).getText();
		String  aboveEle = driver.findElement(with(By.tagName("p")).above(baseElement)).getText();
		System.out.println("The city above of Rouyn Noranda, Canada is: " + aboveEle);
//		Since this Canada weather AQI app is dynamic, I Would recommend locating the web element using the By.tagName locator
//		instead of linkText of any other form xpath. As the text of the element is related to child tag, but if we locate
//		it through the parent <p> tag, it will also capture the child tag text.
		
		// below of base element
		String  belowEle = driver.findElement(with(By.tagName("p")).below(baseElement)).getText();
		System.out.println("The city below of Rouyn Noranda, Canada is: " + belowEle);
		
		// near element --> Will capture the element in 50 pixel distance
		String  nearEle = driver.findElement(with(By.tagName("p")).near(baseElement)).getText();
		System.out.println("The element near to Rouyn Noranda, Canada is: " + nearEle);
		
		
		// For this table, the near element might throw NoSuchElementException. because the table is super dynamic and the 
		// values are keep changing.
//		String nearElement = driver.findElement(with(By.xpath("(//p[text()='49'])[1]")).near(baseElement)).getText();
//		System.out.println("The other near element is: " + nearElement);
		
		List<WebElement> belowElements = driver.findElements(with(By.xpath("//div[@id='most_pollutedCitiesRank']/p")).below(baseElement));
		System.out.println(belowElements.size());
		for(WebElement e : belowElements) {
			String text = e.getText();
			System.out.println(text);
		}
		

	}

}
