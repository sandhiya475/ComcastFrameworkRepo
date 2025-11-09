package com.crm.objectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorsPage {
	WebDriver driver;
	public CreateNewVendorsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="vendorname")
	private WebElement vendornameTextfield;
	
	@FindBy(id="email")
	private WebElement emailTextfield;
	
	@FindBy(id="phone")
	private WebElement phoneTextfield;
	
	@FindBy(name="button")
	private WebElement savebutton;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getVendornameTextfield() {
		return vendornameTextfield;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getPhoneTextfield() {
		return phoneTextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
}
