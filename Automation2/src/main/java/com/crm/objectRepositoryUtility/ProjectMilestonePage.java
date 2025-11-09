package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectMilestonePage {
	WebDriver driver;
	public ProjectMilestonePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement projectMilestoneLookupImgIcon;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProjectMilestoneLookupImgIcon() {
		return projectMilestoneLookupImgIcon;
	}
	
}
