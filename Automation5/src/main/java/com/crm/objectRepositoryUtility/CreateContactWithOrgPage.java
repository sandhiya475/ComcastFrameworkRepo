package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactWithOrgPage {
	WebDriver driver;
	public CreateContactWithOrgPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "search_text")
	private WebElement searchTextfield;
	
	@FindBy(name = "search")
	private WebElement searchButton;
	
	@FindBy(xpath =  "//a[text()='Tek pyramid']")
	private WebElement orgNameClickBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getOrgNameClickBtn() {
		return orgNameClickBtn;
	}
	
}
