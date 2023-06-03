package Teste.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class screenshot1 {

	ChromeDriver driver;

	@Test
	public void screenshote() throws IOException {
		driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File (".//Screenshot/page.png");
		FileUtils.copyFile(src, des);
		driver.quit();
	}
}
