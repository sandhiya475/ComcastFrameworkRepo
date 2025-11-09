package com.crm.objectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewMilestonePage {
	WebDriver driver;
	public CreateNewMilestonePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="projectmilestonename")
	private WebElement projectmilestonenameTextfield;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement createprojectmilestonenamelookUpIcon;
	
	@FindBy(name="button")
	private WebElement saveButton;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProjectmilestonenameTextfield() {
		return projectmilestonenameTextfield;
	}

	public WebElement getCreateprojectmilestonenamelookUpIcon() {
		return createprojectmilestonenamelookUpIcon;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}

