package com.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setup() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void verifyHomePageHeader() {
		String header = homePage.getHomePageHeader();
		System.out.println("Home page header is: " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	
	@Test
	public void verifLoggedInUserAccount() {
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
