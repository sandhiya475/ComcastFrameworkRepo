package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyPage {
	WebDriver driver=null;
    public SpotifyPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
	@FindBy(xpath="//div=@class='hb8C1VAjyUg0VMxrwpix']")
	private WebElement artist1songs;
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getArtist1songs() {
		return artist1songs;
	}
	
}
