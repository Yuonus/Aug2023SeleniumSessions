package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGGraphElements {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");
		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 400)");
		

		String stateXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g' "
				+ "and @class='region']";
		//51
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		List<WebElement> statesList = driver.findElements(By.xpath(stateXpath));
		System.out.println(statesList.size());
		
		Actions act = new Actions(driver);
		for(WebElement e : statesList) {
			act.moveToElement(e).build().perform();  // With chromeDrivr it will throw exception
			Thread.sleep(500);
			String idAttrVal = e.getAttribute("id");
			System.out.println(idAttrVal);
				if(idAttrVal.contains("virginia")) {
					e.click();
					break;
				}
		}
		
	}

}
