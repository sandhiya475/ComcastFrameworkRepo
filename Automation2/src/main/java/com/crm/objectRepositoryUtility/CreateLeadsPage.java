package com.crm.objectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadsPage {
	WebDriver driver;
	public CreateLeadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "lastname")
	private WebElement lastnameTextfield;
	
	@FindBy(name = "company")
	private WebElement companyTextfield;
	
	
	
	@FindBy(name = "button")
	private WebElement savebutton;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastnameTextfield() {
		return lastnameTextfield;
	}

	public WebElement getCompanyTextfield() {
		return companyTextfield;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}

		}
	

