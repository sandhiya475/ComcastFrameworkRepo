package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	public  OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerinfo;
	
	@FindBy(xpath = "//span[@id='dtlview_Phone']")
	private WebElement phoneNuminfo;
	
	@FindBy(id = "mouseArea_Industry")
	private WebElement industryDropdowninfo;
	
	@FindBy(id = "mouseArea_Type")
	private WebElement typeDropdowninfo;
	

	public WebElement getPhoneNuminfo() {
		return phoneNuminfo;
	}


	public WebElement getIndustryDropdowninfo() {
		return industryDropdowninfo;
	}


	public WebElement getTypeDropdowninfo() {
		return typeDropdowninfo;
	}


	public WebElement getHeaderinfo() {
		return headerinfo;
	}
	
}
