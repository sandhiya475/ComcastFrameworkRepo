package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadEditPage {
	WebDriver driver;
	
	public LeadEditPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement emailTextfield;

	@FindBy(name="button")
	private WebElement savebutton;
	
	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
		
	}

}
