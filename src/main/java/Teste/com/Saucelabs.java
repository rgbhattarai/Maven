package Teste.com;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Saucelabs {

	@Test ()
	public void testcase1() {
		
		System.out.println("Login");
		ChromeDriver driver = new ChromeDriver();
	//System.setProperty("Webdriver.chrome.driver", "C:\\Users\\bhatt\\OneDrive\\Desktop\\chromedriver_win32.exe");
	
//	 ChromeOptions options = new ChromeOptions(); 
//	  options.addArguments("--remote-allow-origins=*"); 
//	driver = new ChromeDriver(options); 
	driver.get("https://www.saucedemo.com/");
	WebElement user=driver.findElement(By.cssSelector("#user-name"));
	user.sendKeys("standard_user");
	
	WebElement password=driver.findElement(By.cssSelector("#password"));
	password.sendKeys("secret_sauce");
	
	driver.findElement(By.cssSelector("#login-button")).click();
	List <WebElement> p =  driver.findElements(By.cssSelector("div[class=inventory_item]"));
	Assert.assertEquals(p.size(),6);
		
			
}
}
