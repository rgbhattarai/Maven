package Teste.com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testr1 {
	@Test
	public void testCase() {
		System.out.println("This is 1st test case");	
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("This test run Before test");	
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This run Beforemethod test");	
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("This class run Beforeclass test");	
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This suite run Before test");	
	}
	@Test
	public void testCase1() {
		System.out.println("This is 2nd test case");	
	}
	@AfterTest
	public void afterTest() {
		System.out.println("This test run Aftertest");	
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("This run Aftermethod test");	
	}
	@AfterClass
	public void afterClass() {
		System.out.println("This class run Afterclass test");	
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("This class run Aftersuite test");	
	}
	

	
	
}
