package com.crm.objectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	WebDriver driver;
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productInfo;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateInfo;
	
	@FindBy(id="dtlview_Support Expiry Date")
	private WebElement endDateInfo;
	
	
	
	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getEndDateInfo() {
		return endDateInfo;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductInfo() {
		return productInfo;
	}
	

}
