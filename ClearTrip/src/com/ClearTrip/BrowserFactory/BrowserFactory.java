package com.ClearTrip.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public static WebDriver driver = null;
	
	public static WebDriver startBrowser(String browserName, String URL)
	{
		if (browserName.equalsIgnoreCase("firefox"))
		{
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new FirefoxDriver();
				
		}
		if (browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			String path= "D:\\chromedriver_win32";
			System.setProperty("webdriver.chrome.driver", path+"\\chromedriver.exe");
			driver = new ChromeDriver(options);
						
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
	
}
