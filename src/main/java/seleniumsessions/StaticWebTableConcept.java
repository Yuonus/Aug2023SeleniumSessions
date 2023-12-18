package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableConcept {
	/*
		1.	Navigate to https://www.w3schools.com/html/html_tables.asp
		2.	Capture (give me) the column specific values.
		3.	This means capture all the values under Company column. Or the interviewer could ask you to return Contact / Country columns values.
		4.	Dfd

	 */
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rowCount = driver.findElements(By.xpath("//table[@id=\"customers\"]//tr")).size();
		
		//table[@id="customers"]/tbody/tr[2]/td[1]
		//table[@id="customers"]/tbody/tr[3]/td[1]
		//table[@id="customers"]/tbody/tr[4]/td[1]
		//table[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeXpath = "//table[@id=\"customers\"]/tbody/tr[";
		String afterXpath = "]/td[1]";
		
		for (int row = 2; row<=rowCount; row++) {
			String actXpath = beforeXpath + row + afterXpath; // //table[@id=\"customers\"]/tbody/tr[2]/td[1]
//			System.out.println(actXpath);
			String compName = driver.findElement(By.xpath(actXpath)).getText();
			System.out.println(compName);
		}

		
//		ASSIGNMENTS
		//Also determine/find out that what is "Alfreds Futterkiste" column name?
//		String text = driver.findElement(By.xpath("//td[text()='Alfreds Futterkiste']/parent::tr/preceding-sibling::tr/th[text()='Company']")).getText();
//		System.out.println("Alfred's:" + text);
		
		
//		List<WebElement> tableData = driver.findElements(By.xpath("//th[text()='Company']"
//				+ "/parent::tr/following-sibling::tr/td"));
//		for(WebElement e : tableData) {
//			String tableAllData = e.getText();
//			System.out.println(tableAllData);
//		}
	}

}
