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
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.id("u_0_n")).click();
		driver.close();
		driver.quit();
	}
}
