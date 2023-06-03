package Teste.com;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(Teste.com.ListnerMethods.class)

public class customListner {
	
	@Test
	public void Test1() {
		System.out.println("This is Test 1");
		Assert.assertEquals("A","A");
	}
	@Test
	public void Test2() {
		System.out.println("This is Test 2");
		Assert.assertEquals("A","B");
	}
	@Test
	public void Test3() {
		System.out.println("This is Test 3");
		throw new SkipException("This is Skipped");
	}
}
