package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest{

	
	@Test (priority = 1)
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
	

}
