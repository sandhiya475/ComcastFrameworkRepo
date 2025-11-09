package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPage {
	WebDriver driver=null;
public FlipkartPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(name="q")
private WebElement searchTF;
public WebDriver getDriver() {
	return driver;
}

public WebElement getSearchTF() {
	return searchTF;
}

}
