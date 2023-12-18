package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://cgi-lib.berkeley.edu/ex/fup.html
			3.	Click on "Choose File"
			4.	Attach/upload a file.
			5.	Click on "Press" button to upload the file.
			6.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\syuon\\Desktop\\Yuonus Resume.docx");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();
		
		// If you want to upload more files keep repeating the process. If the application allows you to do so.
//		here this application only allows one file upload
//		driver.findElement(By.name("upfile")).sendKeys("C:\Users\syuon\Desktop\Yuonus Resume.docx");
//		driver.findElement(By.name("upfile")).sendKeys("C:\Users\syuon\Desktop\Basir.pdf");
		
	}

}
