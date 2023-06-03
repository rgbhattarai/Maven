package Teste.com;

import org.testng.annotations.Test;

public class testr2 {

	
		@Test(priority = 1)
		public void loginTest1() {
			System.out.println("first test case");
		}
		@Test(priority = -1)
		public void loginTest2() {
			System.out.println("second test case");
		}
		@Test(priority = 0)
		public void loginTest3() {
			System.out.println("Third test case");
		}
}
