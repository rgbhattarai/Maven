package Teste.com;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestR4 {

	@Test ()
	@Parameters({"username","password"})
	public void testcaseOne(String un,String pasw) {
		System.out.println(un);
		System.out.println(pasw);
		System.out.println("test case 1");
	}
	@Test()
	public void testcaseTwo() {
		System.out.println("Test case two");
	}
}
