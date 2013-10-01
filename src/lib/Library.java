package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Library {
	
	public WebDriver startBrowser(String browser)
	{
		WebDriver driver;
		driver = null;
		if(browser.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
	
}
