package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Services")
	private WebElement servicesLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;
	
	@FindBy(linkText = "Project Milestones")
	private WebElement projectMilestonesLink;
	
	@FindBy(linkText = "Projects")
	private WebElement projectsLink;
	
	@FindBy(xpath  = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrationLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getAdministrationLink() {
		return administrationLink;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getServicesLink() {
		return servicesLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getProjectMilestonesLink() {
		return projectMilestonesLink;
	}

	public WebElement getProjectsLink() {
		return projectsLink;
	}
	
	public void logout() {
		Actions action=new Actions(driver); 
		WebElement ele =administrationLink;
		action.moveToElement(ele).perform();
		signoutLink.click();
	}
	
}
