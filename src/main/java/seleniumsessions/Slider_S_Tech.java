package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider_S_Tech {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		slider();
//		jQuerySlider();
		flipKart();
//		slider_With_ClickAndHold();
	}

		/* Google "dimension extenstion for chrome" or click on the link 
		 "https://chrome.google.com/webstore/detail/dimensions/baocaagndhipibgklemoalmkljaimfdj"
		 * 
		 * 
		 */
		
		/*		First Approach: Using dragAndDropBy() method of Actions class.
		 * Navigate to "https://jqueryui.com/slider/#colorpicker"
		 * Since the element is in an iframe, switch the attention of the driver to the iframe.
		 * Find the slider element and move the element to the given coordinates. (x=20, y=0)
		 * note: remember to put the Offset "Y" value as "0" because the Y is not moving in 
		 *  Horizontal sliders.
		 *  
		 *  Verify if the user is on the "Slider" page or not. and print the text of the element.
		 *  Note: You will have switch the driver back to the main page from the iframe, otherwise you will keep getting the 
		 *  NoSuchElementException.
		 */
		
		public static void slider() throws InterruptedException {
			driver = new ChromeDriver();
			driver.get("https://jqueryui.com/slider/#colorpicker");
			driver.manage().window().maximize();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'demo-frame')]")));
			WebElement slider = driver.findElement(By.xpath("//span[contains(@style,'left: 54.902%;')]"));
			Actions action = new Actions(driver);
			action.dragAndDropBy(slider, 20, 0).perform();
			
			driver.switchTo().defaultContent();
			WebElement sliderOnUI = driver.findElement(By.xpath("//h1[text()='Slider']"));
			String actualText = "Slider";
			if(sliderOnUI.getText().equals(actualText)) {
				System.out.println("The text on the UI: " + sliderOnUI.getText()) ;
				System.out.println("The user is on slider page");
			}else {
				System.out.println("The user is not on the slider page");
			}
		}
		
		/* 		video link https://www.youtube.com/watch?v=48e8KsxF_ns
		 * Navigate to "https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/"
		 * Locate the slider element from left to right
		 * Specify the element's location 
		 * specify the element's height and width
		 * Slide 100 toward x direction
		 * Slide 100 toward x in reverse direction. x = -100
		 * 
		 * What is the difference between Actions & Action?
		 * What is the difference between build() & .perform()?
		 * to get the answer of these questions please refer to the link above
		 */
		public static void jQuerySlider() {
			driver = new ChromeDriver();
			driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

			WebElement leftToRightSlider = driver.findElement(By.xpath("//span[contains(@style,'left: 0%;')]"));
			System.out.println("Location the leftToRightSlider is: " + leftToRightSlider.getLocation());
			System.out.println("Height and width of the leftToRightSlider is: " + leftToRightSlider.getSize());
			
			Actions action = new Actions(driver);
			action.dragAndDropBy(leftToRightSlider, 257, 235).perform();
			
			System.out.println("Location the leftToRightSlider is: " + leftToRightSlider.getLocation());
			System.out.println("Height and width of the leftToRightSlider is: " + leftToRightSlider.getSize());
			
			WebElement rightToLeftSlider = driver.findElement(By.xpath("//span[contains(@style,'left: 100%')]"));
			action.dragAndDropBy(rightToLeftSlider, -100, 0).perform();
			
//			driver.close();
			
		}

		/*		Assignment
		 * Navigate to "https://www.flipkart.com/"    https://www.youtube.com/watch?v=re6F_N_o8no
		 * Find the "Search", type "sofa" and hit enter.
		 * Handle the OTP pop up by simply closing the pop up. (click the "X" mark)
		 * Locate the slider from left to right. (left --->)
		 * Locate the slider from right to left. (<--- Right)
		 * move the slider from left --> to right till x=50
		 * Move the slider from right --> to left till x=-40
		 */
		
		public static void flipKart() throws InterruptedException {
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@role='button']")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("q")).sendKeys("Sofa" + Keys.ENTER);
			
			
			
			WebElement leftToRightSlider = driver.findElement(By.xpath("(//div[contains(@class,'_3FdLqY')])[1]"));
			WebElement rightToLeftSlider = driver.findElement(By.xpath("(//div[contains(@class,'_3FdLqY')])[2]"));
			
			Actions action = new Actions(driver);
			Thread.sleep(1000);
			action.dragAndDropBy(leftToRightSlider, 40, 0);
			Thread.sleep(1000);
			action.dragAndDropBy(rightToLeftSlider, -40, 0);
//			driver.close();
			
		}
		
		/*				Assignment
		 * Navigate to "https://jqueryui.com/slider/#colorpicker"
		 * Since the element is in an iframe, switch the attention of the driver to the iframe.
		 * Find the slider element
		 * drag the element to the given extensions. (x= 40 & y= 0)
		 * Use clickAndHold method in coordination to moveByOffset() and release() to automate this slider.
		 * Verify if the user is on the "Slider" page or not. and print the text of the element. verify by "jQuery user interface"
		 * Note: You will have switch the driver back to the main page from the iframe, otherwise you will keep getting the
		 * NoSuchElementException.
		 */
		
		public static void slider_With_ClickAndHold() throws InterruptedException {
			driver = new ChromeDriver();
			driver.get("https://jqueryui.com/slider/#colorpicker");
			driver.manage().window().maximize();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'demo-frame')]")));
			WebElement slider = driver.findElement(By.xpath("//span[contains(@style,'left: 54.902%;')]"));
			Actions action = new Actions(driver);
			action.clickAndHold(slider).moveByOffset(40, 0).release().perform();
			
			driver.switchTo().defaultContent();
			WebElement jQueryUI = driver.findElement(By.xpath("(//a[text()='jQuery UI'])[2]"));
			String textOnUI = jQueryUI.getText();
			String actualText = "jQuery UI";
			if(textOnUI.equals(actualText)) {
				System.out.println("Text on UI is: " +textOnUI);
				System.out.println("The user is on the slider page.");
			}else {
				System.out.println("The user is not on the UI page.");
			}
			driver.close();

		}
	

}
