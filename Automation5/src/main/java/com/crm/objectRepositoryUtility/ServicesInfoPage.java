package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesInfoPage {
	WebDriver driver;
	public ServicesInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement servicenameInfo;
	
	@FindBy(id="dtlview_Website")
	private WebElement websiteInfo;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateInfo;
	
	@FindBy(id="mouseArea_Support Expiry Date")
	private WebElement endDateInfo;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getServicenameInfo() {
		return servicenameInfo;
	}

	public WebElement getWebsiteInfo() {
		return websiteInfo;
	}

	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getEndDateInfo() {
		return endDateInfo;
	}
	
	
}
