package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {
	WebDriver driver;
	public ServicesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewservicesLookUpImageIcon;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateNewservicesLookUpImageIcon() {
		return createNewservicesLookUpImageIcon;
	}
	
}
