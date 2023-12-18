package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	/*		Note
	  --> If the test cases are dependent on each other:
	  		If the base test case is failed the dependent will be skipped/ignored
	 */
	
	@Test 
	public void loginTest() {
		System.out.println("login to app");
		int  i = 9/0;
	}
	
	@Test (dependsOnMethods = "loginTest")
	public void searchHomePageTest() {
		System.out.println("Search Test");
	}
	 
	@Test (dependsOnMethods = "searchHomePageTest")
	public void addToCartTest() {
		System.out.println("Add to cart test");
	}

//	AAA --> (Arrange-Act-Assert)
//	No dependency
//	No priority
//	Test cases/methods should be independent. (Meaning the Test methods/cases should be created individually. The reason not to use dependency is, it creates deadlock condition)
	

	
	@Test
	public void searchTest() {
		// login(UN, pwd)		--> Arrange
		// search (Macbook)		--> Act
		// assertion: 			-->	only one assertion per test should be used
	}
}
