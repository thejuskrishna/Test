package scripts;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import lib.Library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class DataTest {

	Library lib;
	WebDriver driver;
	String cleanup;
	
	@DataProvider(name="data")
	public Object[][] init1() 
	{
		HashMap<String, String> xmlValues = new HashMap<String, String>();
		try {
			xmlValues = lib.readXML("src/config/conf.xml");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Parser exception - Parser problem");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sax exception - Parser problem");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IO exception - Check file");
		}
		return new Object[][]{{ xmlValues }};
	}
	
	@BeforeClass
	public void setup()
	{
		lib = new Library();
		cleanup = "no";
		
	}
	
	@Test(dataProvider = "data", description = "Testing data provider")
	public void TestingDataProvider(HashMap<String, String> xmlVal)
	{
		String browser =  xmlVal.get("browser");
		cleanup = xmlVal.get("cleanup");
		System.out.println("Browser received : " + browser);
		driver = lib.startBrowser(browser);
		driver.get("http://facebook.com");
	}
	
	@AfterClass
	public void tearDown()
	{
		if(cleanup.equalsIgnoreCase("yes"))
		{
			try {
				Runtime.getRuntime().exec("taskkill -f -im chromedriver.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
