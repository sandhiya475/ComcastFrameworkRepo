package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
 
	public  CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameTextfield;
	
	@FindBy(name = "industry")
	private WebElement industryDropdownElement;
	

	@FindBy(name = "accounttype")
	private WebElement typeDropdownElement;
	
	@FindBy(id="phone")
	private WebElement phonetextfield;
	
	@FindBy(name = "button")
	private WebElement saveButton;
	
	
	public WebElement getOrgNameTextfield() {
		return orgNameTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getIndustryDropdownElement() {
		return industryDropdownElement;
	}

	public WebElement getTypeDropdownElement() {
		return typeDropdownElement;
	}

	public WebElement getPhonetextfield() {
		return phonetextfield;
	}

	public void indusDropdown(String value) {
		Select select=new Select(industryDropdownElement);
		select.deselectByValue(value);
	}
	
	public void typeDropdown(String value) {
		Select select=new Select(typeDropdownElement);
		select.deselectByValue(value);
	}
}
