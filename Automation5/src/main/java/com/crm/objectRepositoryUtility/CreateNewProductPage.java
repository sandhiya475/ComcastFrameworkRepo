package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	WebDriver driver;
	public CreateNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productnameTextfield;
	
	@FindBy(name="button")
	private WebElement savebutton;
	
	@FindBy(name="start_date")
	private WebElement start_dateInfo;
	
	@FindBy(name="expiry_date")
	private WebElement expiry_dateInfo;
	

	public WebElement getStart_dateInfo() {
		return start_dateInfo;
	}

	public WebElement getExpiry_dateInfo() {
		return expiry_dateInfo;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductnameTextfield() {
		return productnameTextfield;
	}

	
	
	
	
}
