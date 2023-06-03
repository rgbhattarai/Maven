package Teste.com;

import org.testng.annotations.Test;

public class testr3 {

	@Test(groups = {"login"})
	public void login1() {
		System.out.println("Login successful");
	}
	@Test(groups = {"login"})
	public void login2() {
		System.out.println("Login2 successful");
	}
	@Test(groups = {"logout"})
	public void logout1() {
		System.out.println("Logout1 successful");
	}
	@Test(groups = {"portfolio"})
	public void portfolio1() {
		System.out.println("portfolio1 successful");
	}
	@Test
	public void portfolio2() {
		System.out.println("portfolio2 successful");
	}
	@Test(groups = {"logout"})
	public void logout2() {
		System.out.println("Logout2 successful");
}
}
