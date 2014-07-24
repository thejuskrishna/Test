package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lib.Library;

public class SimpleTest {

	public static void main(String args[]) 
	{
		Library lib = new Library();
		WebDriver driver = lib.startBrowser("chrome");
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("thejusk");
		driver.findElement(By.id("pass")).sendKeys("lifeispc");
		driver.findElement(By.id("u_0_n")).click();
		driver.close();
		driver.quit();
	}
}
