package Teste.com;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframe123 {
	ChromeDriver driver;
	
	@BeforeMethod
	public void BeforetestA() {
//	ChromeDriver driver = new ChromeDriver (); //not required
	driver = new ChromeDriver (); //this only required
	driver.get("http://www.webdriveruniversity.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void iframeA() throws InterruptedException {
		
		
	WebElement e= driver.findElement(By.cssSelector("#iframe"));
	e.click();
	Thread.sleep(2000);
	Set<String> w2 = driver.getWindowHandles();
	Iterator <String> ii = w2.iterator();
	String parent = ii.next();
	String child = ii.next();
	driver.switchTo().window(child);
	WebElement ifr = driver.findElement(By.cssSelector("#frame"));
	driver.switchTo().frame(ifr);
	driver.findElement(By.cssSelector("a[href=\"products.html\"]")).click();
	Thread.sleep(2000);
	
	List <WebElement> product = driver.findElements(By.cssSelector("div[data-toggle=\"modal\"]"));
	System.out.println(product.size());
	
	Assert.assertEquals(product.size(), 8);
	}
	@AfterMethod()
	public void aftertest() {
		driver.quit();
	}
}
