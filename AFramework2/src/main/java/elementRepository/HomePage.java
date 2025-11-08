package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationslink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutEle;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;

	/**
	 * @return the contactsLink
	 */
	public WebElement getContactsLink() {
		return contactsLink;
	}

	/**
	 * @return the organizationslink
	 */
	public WebElement getOrganizationslink() {
		return organizationslink;
	}

	/**
	 * @return the logoutEle
	 */
	public WebElement getLogoutEle() {
		return logoutEle;
	}

	/**
	 * @return the signoutLink
	 */
	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	
}
