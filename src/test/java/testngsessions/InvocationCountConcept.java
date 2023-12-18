package testngsessions;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	/*		Business Case  
		1.	Create InvocationCountConcept class
		2.	Develop one @Test method in the class
		3.	Run the test 10 times for one single thread/ or call the test back to back for 10 times
	 */
	
	// Run the given Test case 5 times
	// By default invocationCount time is 1 time
	
	@Test (invocationCount = 5)
	public void searchProductTest() {
		System.out.println("Search Product Test");
	}

}
