package com.crm.objectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProjectsPage {
	WebDriver driver;
	public CreateNewProjectsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="projectname")
	private WebElement projectnameTextfield;
	
	@FindBy(name="button")
	private WebElement savebutton;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProjectnameTextfield() {
		return projectnameTextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	
}
