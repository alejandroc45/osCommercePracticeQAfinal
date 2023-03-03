package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.System;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ControlDrivers {
	
	protected static WebDriver driver;
	private static WebDriverWait wait;
	private static ChromeOptions chromeOptions ;

	
	
	public ControlDrivers(WebDriver driver)
	{
		ControlDrivers.driver=driver;
	}

	
	public static void createAndStartService() throws IOException {
		WebDriverManager.chromedriver().setup();
  		ArrayList<String> optionsList = new ArrayList<String>();
		chromeOptions = new ChromeOptions();
		optionsList.add("--start-maximized");
		optionsList.add("--incognito");
		optionsList.add("disable-notifications");
		chromeOptions.addArguments(optionsList);
		chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
  		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
  	
	}
	
	public static void createDriver() {
		
		driver = new ChromeDriver(chromeOptions);
	}
	
	public static void quitDriver() {
		  driver.quit();
	}

}
