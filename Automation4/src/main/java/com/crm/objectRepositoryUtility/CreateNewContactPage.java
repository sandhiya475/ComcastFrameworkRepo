package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
  @FindBy(name = "lastname")
  private WebElement lastnameTextfield;
  
  @FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
  private WebElement createContactWithOrgIcon;
  
  @FindBy(name = "support_start_date")
  private WebElement contactsupportstartdateTextfield;
  
  @FindBy(name = "support_end_date")
  private WebElement contactsupportenddateTextfield;
  
  @FindBy(name = "button")
  private WebElement saveButton;
  
  public WebDriver getDriver() {
	return driver;
  }

  public WebElement getLastnameTextfield() {
	return lastnameTextfield;
  }

  public WebElement getCreateContactWithOrgIcon() {
	return createContactWithOrgIcon;
  }

  public WebElement getContactsupportstartdateTextfield() {
	return contactsupportstartdateTextfield;
  }

  public WebElement getContactsupportenddateTextfield() {
	return contactsupportenddateTextfield;
  }

  public WebElement getSaveButton() {
	return saveButton;
  }

  
}
