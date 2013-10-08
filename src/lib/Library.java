package lib;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
		
		return driver;
	}
	
	public HashMap<String, String> readXML(String file) throws ParserConfigurationException, SAXException, IOException
	{
		String browser = null;
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
			i++;
		}
		
		contents.put("browser", browser);
		return contents;
	}
}
