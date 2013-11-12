package lib;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Library {
	
	public WebDriver startBrowser(String browser)
	{
		WebDriver driver;
		driver = null;
		if(browser.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		return driver;
	}
	
	public Screen startSikuli()
	{
		Screen regionToSearch = new Screen();
		return regionToSearch;
	}
	
	public void MouseClick(Match region) throws FindFailed
	{
		
		region.click(new Location(region.getX(), region.getY()));
		
	}
	
	public HashMap<String, String> readXML(String file) throws ParserConfigurationException, SAXException, IOException
	{
		String browser = null;
		String cleanup = "no";
		int i = 0;
		HashMap<String, String> contents = new HashMap<>();;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xml = builder.parse(file);
		xml.getDocumentElement().normalize();
		NodeList nodes = xml.getElementsByTagName("run");
		while(nodes.item(i)!=null)
		{
			Element elem = (Element) nodes.item(i);
			browser = elem.getElementsByTagName("browser").item(0).getChildNodes().item(0).getNodeValue().trim();
			cleanup = elem.getElementsByTagName("cleanup").item(0).getChildNodes().item(0).getNodeValue().trim();
			i++;
		}
		
		contents.put("browser", browser);
		contents.put("cleanup", cleanup);
		
		return contents;
	}
}

