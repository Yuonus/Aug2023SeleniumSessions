package seleniumsessions;

public class TopCastingOptions {
	public static void main(String[] args) {		
		/*
		 1. ChromeDriver driver = new ChromeDriver(); Valid, but only for a specific browser
		 2. WebDriver driver = new ChromeDriver(); --> Valid + Recommended
		 3. SearchContext driver = new ChromeDriver(); --> Valid, not recommended. Y is it not recommended?
		 	Because if you look at the Selenium architecture diagram, You will be only and only able to access 
		 	two methods which are findElement(); & findElements(); 
		 4. RemoteDriver driver = new ChromeDriver(); --> Valid + Recommended. Because you can access all the methods.
		 5. WebDriver driver = new RemoteWebDriver();
		 6.ChromiumDriver driver = new ChromeDriver(); --> Valid + Recommended
		 */
	}

}
