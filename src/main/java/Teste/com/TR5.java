package Teste.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TR5 {

	@DataProvider(name = "logindata")
	public Object[][] datasetone() {
		return new Object[][] { { "standard_user", "secret_sauce" },
								{ "locked_out_user", "secret_sauce" },
								{ "problem_user", "secret_sauce" }, 
								{ "performance_glitch_user", "secret_sauce" } };

	}
	@Test (dataProvider="logindata")
	
	public void login (String username, String pswd) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(pswd);
		driver.findElement(By.cssSelector("#login-button")).click();
		List <WebElement> p =  driver.findElements(By.cssSelector("div[class=inventory_item]"));
		Assert.assertEquals(p.size(), 6);
		driver.quit();
	}
}
