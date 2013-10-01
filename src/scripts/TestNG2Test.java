package scripts;

import lib.Library;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG2Test {
  
	Library lib;
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		lib = new Library();
		driver = lib.startBrowser("firefox");
	}
	
	@Test(description = "SampleTest")
	public void StartBrowserTest() {
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.id("u_0_b")).click();
		System.out.println("Mouse Over Text :"+ driver.findElement(By.linkText("Developers")).getAttribute("title"));
		Assert.assertEquals(driver.findElement(By.linkText("Developers")).getAttribute("title"), "Kopp");
	}
	
	@AfterClass
	public void teardown() {
		
		driver.close();
	}
	
}
 