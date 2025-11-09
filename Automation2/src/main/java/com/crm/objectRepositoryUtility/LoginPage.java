package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
    public LoginPage(WebDriver driver) {
    this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(name="user_name")
	private WebElement usernameTextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfield;;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	//getters method==>It give the access to one element
	public WebElement getUsernameEdt() {
		return usernameTextfield;
	}

	public WebElement getPasswordEdt() {
		return passwordTextfield;
	}

	public WebElement getLoginBtn() {
		return loginButton;
	}
	
	//Business method==> It give the access to multiple elements in a single method
	public void loginToApp(String url,String username,String password) {
		driver.get(url);
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginButton.click();
	}
	
}
