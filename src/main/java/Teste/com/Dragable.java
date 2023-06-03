package Teste.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Dragable {
	ChromeDriver driver = new ChromeDriver();

	@Test(priority=1)
	public void verifyTitle() {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), "Droppable | jQuery UI");
	
	}
	@Test(priority=2)
	public void verifyCurrentUrl() {
		String e=driver.getCurrentUrl();
		Assert.assertEquals(e, "https://jqueryui.com/droppable/");
		
	}
	@Test(priority=3)
	public void verifyDragable() {
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(ele);
		WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
		WebElement dropable= driver.findElement(By.cssSelector("#droppable"));
		a.dragAndDrop(draggable, dropable).build().perform();
		String Dropped = dropable.getText();
		System.out.println(Dropped);
		Assert.assertEquals(Dropped,"Dropped!");
	}
}
