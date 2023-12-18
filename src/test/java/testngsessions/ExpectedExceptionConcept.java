package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	String name;
	
//	@Test (expectedExceptions = ArithmeticException.class) // single exception
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class })
	public void loginTest() { 
		System.out.println("login step");
		int i = 9/0;
		System.out.println("Good S_Tech hunters");
		
		ExpectedExceptionConcept obj = null;
		System.out.println(obj.name);  // NullPointerExceptions
	}

}
