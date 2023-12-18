package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // Delete all the cookies for the current domain. And this will also delete 
		// all the previous browser caches, histories .. and it will give us a fresh browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/");
	}
	
	@Test (priority = -1)
	public void isOpenCarLogoIsVisibleTest() {
		boolean flag = driver.findElement(By.xpath("//img[@title='naveenopencart']")).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	@Test (priority = 3)
	public void openCartTitleTest() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Your Store");
	}
	
	@Test (priority = 1)
	public void openCartURLTest() {
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertEquals(actualURL, "https://naveenautomationlabs.com/opencart/"); // Or we can verify the following way
		Assert.assertTrue(actualURL.contains("opencart"));
	}
	
	@Test
	public void aTest() {
		System.out.println("a test");
	}
	
	@Test
	public void bTest() {
		System.out.println("b test");
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
