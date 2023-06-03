package Teste.com;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Teste.com.ListnerMethods.class)
public class Action12 {
	ChromeDriver driver;
	

	@BeforeMethod()
	public void beforetest() {
		driver = new ChromeDriver();
		
		driver.get("http://www.webdriveruniversity.com/Actions/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod()
	public void aftertest() {
		driver.quit();
	}

	@Test(priority = 1)
	public void dragDrop() {
		
		Actions a = new Actions(driver);
		WebElement dragable = driver.findElement(By.cssSelector("div[id=draggable]"));
		WebElement dropable = driver.findElement(By.cssSelector("div[id=droppable]"));
		a.dragAndDrop(dragable, dropable).build().perform();
		Assert.assertEquals(dropable.getText(), "Dropped!");
	}

	@Test(priority = 2)
	public void doubleClick() {
		Actions a = new Actions(driver);
		WebElement douClick = driver.findElement(By.cssSelector("#double-click"));
		a.doubleClick(douClick).build().perform();
		WebElement afterdouClick = driver.findElement(By.cssSelector("div[class='div-double-click double']"));
		Assert.assertEquals(douClick, afterdouClick);
	}

	@Test(priority = 3)
	public void hover() {
		Actions a = new Actions(driver);
		WebElement h1 = driver.findElement(By.xpath("//*[@id=\"div-hover\"]/div[3]/button"));
		a.moveToElement(h1).build().perform();
		WebElement e1 = driver.findElement(By.xpath("//*[@id=\"div-hover\"]/div[3]/div/a[1]"));
		e1.click();
		driver.switchTo().alert().accept();
		// System.out.println(e1.getText());
		Assert.assertEquals(e1.getText(), "Link 1");
	}

	@Test(priority = 4)
	public void cnH() {
		Actions a = new Actions(driver);
		WebElement cH = driver.findElement(By.cssSelector("div[id=click-box]"));
		a.clickAndHold(cH).build().perform();
		// System.out.println(cH.getText());
		Assert.assertEquals(cH.getText(), "Well done! keep holding that click now.....");

	}
}
