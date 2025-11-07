package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class ContactsPage {

	//Constructor
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contactLookupImageIcon;
	
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
		private WebElement organizationLookUpImage;


	public WebElement getContactLookupImageIcon() {
		return contactLookupImageIcon;
	}


	public WebElement getOrganizationLookUpImage() {
		return organizationLookUpImage;
	}



	
	
	
}
