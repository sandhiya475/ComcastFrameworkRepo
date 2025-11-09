package com.crm.objectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MilestoneWindowPage {
	WebDriver driver;
	public MilestoneWindowPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="search_txt")
	private WebElement search_txtTextfield;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(linkText = "CRM")
	private WebElement projectNameTextfield;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearch_txtTextfield() {
		return search_txtTextfield;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getProjectNameTextfield() {
		return projectNameTextfield;
	}
	
}
