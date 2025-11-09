package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
  @FindBy(xpath="//span[@class='dvHeaderText']")
  private WebElement contactInfo;
 
  @FindBy(id="dtlview_Support Start Date")
  private WebElement supportStartDateInfo;
  
  @FindBy(id="dtlview_Support End Date")
  private WebElement supportEndDateInfo;
  public WebDriver getDriver() {
	return driver;
  }

  public WebElement getContactInfo() {
	return contactInfo;
  }

  public WebElement getSupportStartDateInfo() {
	return supportStartDateInfo;
  }

  public WebElement getSupportEndDateInfo() {
	return supportEndDateInfo;
  }
	
}
