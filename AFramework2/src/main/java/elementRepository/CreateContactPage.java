package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	//Constructor
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastnameTextfield;

	
	@FindAll({@FindBy(name = "button"),@FindBy(xpath  ="//input[@class='crmButton small save']")})
	private WebElement savebutton;
	
	
	@FindBy(xpath = "(//a[@class='listFormHeaderLinks'])[1]")
	private WebElement organizationNameLink;

	@FindBy(linkText = "TCS")
	private WebElement organizationName;


	public WebElement getOrganizationName() {
		return organizationName;
	}


	public void setOrganizationName(WebElement organizationName) {
		this.organizationName = organizationName;
	}


	public WebElement getOrganizationNameLink() {
		return organizationNameLink;
	}


	public WebElement getLastnameTextfield() {
		return lastnameTextfield;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}

}
