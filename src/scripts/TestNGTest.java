package scripts;

import lib.Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGTest {
	Library lib;
	WebDriver driver;
	
	@BeforeClass(timeOut = 600000)
	public void setup() {
		lib = new Library();
		driver = lib.startBrowser("firefox");
	}
	
	@Test(description="Sample Test")
	public void TestOpenBrowser() {
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("");
	}

}
