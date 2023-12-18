package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation {
	
	// All these (@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod) are called pre-conditions.
	// Test cases are written under (@Test) annotation, each @Test represent one test case.
	
	/*	Running Sequence 
	 	Before -- Test --- After
	 	
 --> Now we have four @Before, which one will run first? Always the first preference will be given to BeforeSuite annotation
 --> BeforeMethod: will run before each test method. Now as we have 3 @Test, this before method will run three times, this is  
     the only speciality given to @BeforeMethod. And this annotation will pick the @Test method based on alphabetical order. 
     and remember that (@BeforeSuite, @BeforeTest, @BeforeClass) will only run one time.
 --> AfterMethod: will run after each test method. Now as we have 3 @Test, this after method will run three times, this is  
     the only speciality given to @AfterMethod.	
	 	
	 	Does the writing sequence matter for these annotation?
	 	No, selenium can handle the implementation by its own, no matter if you write the BeforeTest or AfterTest ...Selenium
	 	will observe the sequence itself.
	 	
 -----> See the output of this code and observer the preferences <-----
 	**> This will create three pairs, because we have three test cases.
 		And also remember that pair creation happens with BeforeMethod and AfterMethod annotation
		
		1	BS --- connect with DB
		2	BT --- Create user
		3	BC --- Launch browser
		
				4	BM --- Login to App
				5	Add to cart Test			Pair 1
				6	AM --- logout
		
				7	BM --- Login to App
				8	Check out Test				Pair 2
				9	AM --- logout
		
				10	BM --- Login to App
				11	Search Test					Pair 3
				12	AM --- logout
		
		13	AC --- Close browser
		14	AT --- delete user
		15	AS --- Disconnect with Data base

	 */
	
	// CTRL + SHIFT + O --> used for imports
	
	// 1
	@BeforeSuite  
	public void connectWithDB() {
		System.out.println("BS --- connect with DB");
	}
	
	// 2
	@BeforeTest
	public void createUser() {
		System.out.println("BT --- Create user");
	}
	
	
	// 3
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC --- Launch browser");
	}
	
	// 4 //7 // 10
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM --- Login to App");
	}
	
	// 11
	@Test
	public void searchTest() {
		System.out.println("Search Test");
	}
	
	
	// 5
	@Test
	public void addToCartTest() {
		System.out.println("Add to cart Test");
	}
	
	
	// 8
	@Test
	public void checkOutTest() {
		System.out.println("Check out Test");
	}
	
	
	// 6 //9 //12
	@AfterMethod
	public void logout() {
		System.out.println("AM --- logout");
	}
	
	// 13
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC --- Close browser");
	}
	
	// 14
	@AfterTest
	public void deleteUser() {
		System.out.println("AT --- delete user");
	}
	
	// 15
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS --- Disconnect with Data base");
	}

}
