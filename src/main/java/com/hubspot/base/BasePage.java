package com.hubspot.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author newuser
 *
 */

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	/**
	 * 
	 * @return
	 */
	public WebDriver initialize_driver(Properties prop) {
		
		//String browser = "chrome";
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	   }
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 return driver;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Properties initialize_properties() {
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("/Users/newuser/eclipse-workspace/TestNGFramework_2020/"
					+ "src/main/java/config/hubspot/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	

}
