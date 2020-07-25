package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.ElementUtil;
import com.itextpdf.text.Element;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Locator
	By header = By.xpath("//h1[@class='private-header__heading']");
	By accountName = By.xpath("//a[@id='account-menu']");
	By contactMainTab = By.id("nav-primary-contacts-branch");
	By contactChildTab = By.id("nav-secondary-contacts");
	
	
	//Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
		
	}
	
	public String getHomePageHeader() {
		return driver.findElement(header).getText();
		
	}
	
	public boolean verifyLoggedInAccountName() {
		return driver.findElement(accountName).isDisplayed();
	}
	
	public void clickOnContacts() {
		elementUtil.doClick(contactMainTab);
		elementUtil.doClick(contactChildTab);
	}
	
	public ContactsPage gotoContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
		
		
	}
	

}
