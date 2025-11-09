package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {

	WebDriver driver;
	public LeadInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath  = "//span[@class='dvHeaderText']")
	private WebElement leadInfo;
	
	@FindBy(name="Edit")
	private WebElement editLink;
	
	@FindBy(name="Delete")
	private WebElement deleteLink;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLeadInfo() {
		return leadInfo;
	}

	public WebElement getEditLink() {
		return editLink;
	}

	public WebElement getDeleteLink() {
		return deleteLink;
	}
	
	
}
