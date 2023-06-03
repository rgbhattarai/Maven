package Teste.com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDependency {

	@Test(dependsOnMethods= {"Tesccase2"})
	public void Tesccase1() {
		System.out.println("Test Case 1 pass");
		
	}

	@Test()
	public void Tesccase2() {
		System.out.println("Test Case 2 pass");
		Assert.fail();
	}

	@Test ()
	public void Tesccase3() {
		System.out.println("Test Case 3 pass");
	}
	
	@Test (dependsOnMethods= {"Tesccase2","Tesccase3"})
	public void Tesccase4() {
			System.out.println("Test Case 4 pass");
		}
	
}
