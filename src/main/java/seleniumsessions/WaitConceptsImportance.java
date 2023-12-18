package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitConceptsImportance {
	static WebDriver driver;
	public static void main(String[] args){
		
		// Wait Hierarchy
//		Wait (I) until() <---- FluentWait (Class) until() {} + other methods <---- WebDriverWait (Class)
		
		driver = new ChromeDriver();		
		driver.get("https://www.easemytrip.com/");
		driver.findElement(By.id("FromSector_show")).sendKeys("Delhi", Keys.ENTER);
		driver.findElement(By.id("Editbox13_show")).sendKeys("Mumbai", Keys.ENTER);
		driver.findElement(By.id("ddate")).click();
		driver.findElement(By.id("snd_4_08/08/2019")).click();
		driver.findElement(By.className("src_btn")).click();
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
	}

}
