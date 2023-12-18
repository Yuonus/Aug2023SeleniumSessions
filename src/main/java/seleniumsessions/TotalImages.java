package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {
	public static void main(String[] args) {
		
		/*			Test Scenario
			1: Launch the Browser 
			2: Launch the URL. "https://www.amazon.com/" 
				** > If amazon is throwing CAPTCHA, you can use ebay = "https://www.ebay.com/"
			3: Find the Total numbers of images available in Amazon homepage. 
			4: Capture the values of "alt", and "src" attributes. And print them to the console. 
				Note: 
				For the second time using the enhanced for loop to print the values of "alt" & "src", it should
				look like this: and also add a space after each iteration
		alt: Ring Pop Halloween Candy 20 Count - Bulk Lollipop Individually Wrapped Party Pack - Candy Lollipop Suckers w/ Assorted...
		src: https://m.media-amazon.com/images/I/91eiAEgD4yL._AC_SY200_.jpg
				
			6: Close the driver.
		 */

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		List<WebElement> imageLists = driver.findElements(By.tagName("img"));
		System.out.println("Total numbers of images: " + imageLists.size());
		
//		for(int i = 0; i<imageLists.size(); i++) {
//			String altVal = imageLists.get(i).getAttribute("alt");
//			String srcVal = imageLists.get(i).getAttribute("src");
//			System.out.println("alt: " + altVal + " --> src: " + srcVal);
//		}
		
		// enhanced for each loop
		
		for(WebElement imageList : imageLists) {
			String alt = imageList.getAttribute("alt");
			String src = imageList.getAttribute("src");
				if(alt.length()!=0) {
					System.out.println("alt: " + alt + "\n"); 
				}
				if(src.length() !=0) {
					System.out.println("src: " + src);
				}
		}
		
		driver.close();
		
	}

}
