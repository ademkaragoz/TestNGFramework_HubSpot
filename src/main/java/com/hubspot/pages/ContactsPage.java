package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;


public class ContactsPage  extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Locator
	By createContactButton = By.xpath("//span[contains(text(), 'Create contact')]");
	By email = By.xpath("//input[@name= 'textInput']");
	By firstname = By.xpath("//input[@class= 'form-control private-form__control' and @data-field='firstname']");
	By lastName = By.xpath("//input[@class= 'form-control private-form__control' and @data-field='lastname']");
	By jobTitle = By.xpath("//input[@class= 'form-control private-form__control' and @data-field='jobtitle']");
	By createContacFromtBtn = By.xpath("//span[@class='private-loading-button__content private-button--internal-spacing'][contains(text(),'Create contact')]");

	public String getContactsPageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}
	
	public void createNewContact(String emailID, String FN, String LN, String jobT) throws InterruptedException {
		
		elementUtil.doClick(createContactButton);
		Thread.sleep(2000);
		elementUtil.doSendKeys(email, emailID);
		Thread.sleep(2000);
		elementUtil.doSendKeys(firstname, FN);
		Thread.sleep(2000);
		elementUtil.doSendKeys(lastName, LN);
		Thread.sleep(2000);
		elementUtil.doSendKeys(jobTitle, jobT);
		Thread.sleep(2000);
		elementUtil.doClick(createContacFromtBtn);
		Thread.sleep(1000);
		
		
	}
	
	
}
