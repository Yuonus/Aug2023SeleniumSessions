package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest {
	
	/*		Unit Testing tools in different programming language
		 Java   	--> Junit + TestNG
		 Python 	--> PyTest / Unit Test
		 .Net 		--> Nunit
		 JavaScript	--> Mocha / Jasmine
		 
	Test Coverage: How many test cases have you written for a specific feature like --> public int sum(int a, int b) {return a+b;}
	Test Coverage: 100 %
	Code Coverage: 0 % 
	
	 */

	// Feature, Method, API
	public int sum(int a, int b) {
		return a+b;
	}
	
	
	// Unit Tests + Assertions
	@Test
	public void test1() {
		sum(10, 20);
		Assert.assertEquals(sum(10, 20), 30);
	}
	
	@Test
	public void test2() {
//		sum(10, 20); // We can directly supply this part to the assertion 
		Assert.assertEquals(sum(10, 20), 30);
	}
	
	@Test
	public void test3() {
		sum(10, 20);
		Assert.assertEquals(sum(-10, 20), 10);
	}
	
	@Test
	public void test4() {
		sum(10, 20);
		Assert.assertEquals(sum(0, 20), 20);
	}
	
	@Test
	public void test5() {
		sum(10, 20);
		Assert.assertEquals(sum(-10, -20), -30);
	}
}
