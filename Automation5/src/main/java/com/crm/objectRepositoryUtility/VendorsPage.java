package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	WebDriver driver;
	public VendorsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createnewvendorlookupimgIcon;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreatenewvendorlookupimgIcon() {
		return createnewvendorlookupimgIcon;
	}
	
}
