package seleniumsessions;

public class OpenCartTest {
	public static void main(String[] args) {
		/*		Test Script
		 	1. Launch the browser
		 	2. Navigate to "https://naveenautomationlabs.com/opencart/index.php?route=account/login"
		 	3. Get the Title of the page.
		 		3.1 -> Verify if the page title matches the actual page title or not.
		 	4. Get the URL of the page.
		 		4.1 --> Verify if the URL is correct or not.
		 	5. Close the browser.
		 */
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/");
		String actTitle = brUtil.getPageTitle();
		if(actTitle.contains("Your Store")) {
			System.out.println("Page Title is correct --- PASS");
		}
		else {
			System.out.println("Page Title is incorrect --- FAIL");
		}
		
		String actUrl = brUtil.getPageUrl();
		if(actUrl.contains("opencart")) {
			System.out.println("URL is correct --- PASS");
		}
		else {
			System.out.println("URL is incorrect --- FAIL");
		}
		brUtil.closeBrowser();
		
	}
	
	/*		HomeWork
	 * Note: Create your own BrowserUtil class and use it in amazon automation
	 * Automate the amazon page considering following scenarios
	 1. Launch the browser
	 2. Navigate to ""
	 3. Get the Title of the page.
	 	3.1 -> Verify if the Page title matches the actual page title or not.
	 4. Get the URL of the page and verify if it is correct or not.
	 5. Get the source of the page and verify if it is really correct or not.
	 6. Quit the browser.
	 */

}
