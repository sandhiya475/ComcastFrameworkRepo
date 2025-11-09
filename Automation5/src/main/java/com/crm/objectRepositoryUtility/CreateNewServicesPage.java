package com.crm.objectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewServicesPage {
	WebDriver driver;
	public CreateNewServicesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="servicename")
	private WebElement servicenameTextfield;
	
	@FindBy(name="website")
	private WebElement websiteTextfield;
	
	@FindBy(id="jscal_field_start_date")
	private WebElement servicestartDateTextfield;
	
	@FindBy(id="jscal_field_expiry_date")
	private WebElement serviceendDateTextfield;
	
	@FindBy(name="button")
	private WebElement savebutton;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getServicenameTextfield() {
		return servicenameTextfield;
	}

	public WebElement getWebsiteTextfield() {
		return websiteTextfield;
	}

	public WebElement getServicestartDateTextfield() {
		return servicestartDateTextfield;
	}

	public WebElement getServiceendDateTextfield() {
		return serviceendDateTextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
}
