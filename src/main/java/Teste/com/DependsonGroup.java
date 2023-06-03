package Teste.com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsonGroup {

	@Test(groups = "Login")
	public void UserName() {
		System.out.println("John");
		Assert.fail();
	}

	@Test(dependsOnGroups = { "Login" })
	public void PassWord() {
		System.out.println("doe");
	}

	@Test(dependsOnGroups = { "Login" }, dependsOnMethods = { "UserName", "PassWord" })
	public void clickLogin() {
		System.out.println("Click on login button");
	}

	@Test(groups = "Logout", dependsOnGroups = { "Login" })
	public void clickLogout() {
		System.out.println("Click on logout button");
	}

	@Test(dependsOnGroups = { "Logout" }, dependsOnMethods = { "clickLogout" })
	public void loginPage() {
		System.out.println("Navigate to login page");
	}

}
