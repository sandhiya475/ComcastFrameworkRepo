package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectMilestoneInfoPage {
	WebDriver driver;
	public ProjectMilestoneInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement milestoneInfo;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMilestoneInfo() {
		return milestoneInfo;
	}
	
}
