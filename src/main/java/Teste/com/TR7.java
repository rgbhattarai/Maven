package Teste.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TR7 {
	@Test 
	public void itemsNumber() {
		System.out.println("Test case 2 to verify no. of items");
		ChromeDriver driver = new ChromeDriver ();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		WebElement user=driver.findElement(By.cssSelector("#user-name"));
		user.sendKeys("standard_user");
		
		WebElement password=driver.findElement(By.cssSelector("#password"));
		password.sendKeys("secret_sauce");
		
		driver.findElement(By.cssSelector("#login-button")).click();
		driver.findElement(By.cssSelector("#login-button")).click();
		List <WebElement> p =  driver.findElements(By.cssSelector("div[class=inventory_item]"));
		Assert.assertEquals(p.size(),6) ;
			System.out.println("Test verify no. of items pass");
}
	}
