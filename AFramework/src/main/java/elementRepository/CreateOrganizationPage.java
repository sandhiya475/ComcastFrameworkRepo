package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
  //Constructor
  public CreateOrganizationPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  
  @FindBy(name = "accountname")
  private WebElement organizationNameTextfield;
  
  @FindBy(name = "industry")
  private WebElement industryDropdown;
  
  @FindBy(name="accounttype")
  private WebElement typeDropdown;
  
  @FindBy(name="button")
  private WebElement savebutton;
  
  
public WebElement getOrganizationNameTextfield() {
	return organizationNameTextfield;
}

public WebElement getIndustryDropdown() {
	return industryDropdown;
}

public WebElement getTypeDropdown() {
	return typeDropdown;
}

public WebElement getSavebutton() {
	return savebutton;
}
  
  
  
  
  
  
  
  
  
}
