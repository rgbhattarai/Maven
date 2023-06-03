package Teste.com;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TR6 {

	ChromeDriver driver = new ChromeDriver();

	// Verify Logo
	@Test(priority = 1)
	public void verifyLogin() {
		System.out.println("Login verification");
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		WebElement user = driver.findElement(By.cssSelector("#user-name"));
		user.sendKeys("standard_user");

		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("secret_sauce");

		driver.findElement(By.cssSelector("#login-button")).click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
	}
	
	@Test(priority = 2)
	public void verifyLogo() {
		System.out.println("Logo veriffication");
		driver.findElement(By.cssSelector("div[class=app_logo]"));
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	
	@Test(priority = 3)
	public void itemNumber() {
		List<WebElement> p = driver.findElements(By.cssSelector("div[class=inventory_item]"));
		Assert.assertEquals(p.size(), 6);

	}

	@Test(priority = 4)
	public void addToCart() throws InterruptedException {
		List<WebElement> e = driver
				.findElements(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory']"));
		Thread.sleep(2000);
		System.out.println(e.size());
		for (int i = 0; i <= e.size() - 1; i++) {
			e.get(i).click();
		}
	}

	@Test(priority = 5)
	public void filter() throws InterruptedException {
		driver.findElement(By.cssSelector("select[data-test=product_sort_container]")).click();
		List<WebElement> e1 = driver.findElements(By.cssSelector("div[class=inventory_item_name]"));
		ArrayList<String> azlist = new ArrayList<String>();
		for (WebElement azlist1 : e1) {
			azlist.add(azlist1.getText());
		}
		System.out.println(azlist);

		driver.findElement(By.cssSelector("option[value='za']")).click();
		List<WebElement> sortete2 = driver.findElements(By.cssSelector("div[class=inventory_item_name]"));
		ArrayList<String> azlistsorted = new ArrayList<String>();
		for (WebElement azlist2 : sortete2) {
			azlistsorted.add(azlist2.getText());
		}
		System.out.println(azlistsorted);
		Collections.sort(azlistsorted);
		Assert.assertEquals(azlistsorted, azlist);

		driver.findElement(By.cssSelector("option[value='lohi']")).click();
		List<WebElement> lohipricelist = driver.findElements(By.cssSelector("div[class=inventory_item_price]"));
		ArrayList<String> lohipricelist1 = new ArrayList<String>();
		for (WebElement lohi : lohipricelist) {
			lohipricelist1.add(lohi.getText().substring(1));
		}
		ArrayList<Double> doubleList = new ArrayList<Double>();
	      for (String str :lohipricelist1) {
	         doubleList.add(Double.parseDouble(str));
	      }
		System.out.println(doubleList);

		// price hightto low
		driver.findElement(By.cssSelector("option[value='hilo']")).click();
		List<WebElement> hilopricelist = driver.findElements(By.cssSelector("div[class=inventory_item_price]"));
		ArrayList<String> hilopricelist1 = new ArrayList<String>();
		for (WebElement hilo : hilopricelist) {
			hilopricelist1.add(hilo.getText().substring(1));
		}
		ArrayList<Double> doubleList1 = new ArrayList<Double>();
	      for (String strhilow :hilopricelist1) {
	         doubleList1.add(Double.parseDouble(strhilow));
	      }
		
		//System.out.println(doubleList1);
		Collections.sort(doubleList1);
		//System.out.println(doubleList1);

	  Assert.assertEquals(doubleList1, doubleList);
	      
	}

	@Test(priority = 6)
	public void checkout() {
		driver.findElement(By.cssSelector("#shopping_cart_container")).click();
		driver.findElement(By.cssSelector("#checkout")).click();
		driver.findElement(By.cssSelector("#first-name")).sendKeys("Rushie");
		driver.findElement(By.cssSelector("#last-name")).sendKeys("Bhattarai");
		driver.findElement(By.cssSelector("#postal-code")).sendKeys("28752");
		driver.findElement(By.cssSelector("#continue")).click();
		List<WebElement> pricelist = driver.findElements(By.cssSelector("div[class=inventory_item_price]"));
		double sum = 0;
		for (int i = 0; i < pricelist.size(); i++) {

			String num = pricelist.get(i).getText();
			String num1 = num.substring(1);// gets rid of $ sign
			// System.out.println(num1);
			sum = sum + Double.parseDouble(num1);
		}
		sum = (sum + (sum * 0.08));
		DecimalFormat df = new DecimalFormat("#.##");
		double roundedNum = Double.parseDouble(df.format(sum));

		// System.out.println(roundedNum );
		String str = Double.toString(roundedNum);
		String str1 = "Total: " + "$" + str;
		// System.out.println("$"+str);
		WebElement price = driver.findElement(By.cssSelector("div[class='summary_info_label summary_total_label']"));
		System.out.println(price.getText());
		Assert.assertEquals(price.getText(), (str1));
	}

	@Test(priority = 7)
	public void finishorder() {
		driver.findElement(By.cssSelector("#finish")).click();
		WebElement compleorder = driver.findElement(By.cssSelector("#checkout_complete_container"));
		String text = (compleorder.getText());
		Assert.assertEquals(compleorder.getText(), text);
	}
}
