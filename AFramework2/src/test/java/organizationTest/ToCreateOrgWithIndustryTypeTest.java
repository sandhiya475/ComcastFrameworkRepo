package organizationTest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import elementRepository.CreateOrganizationPage;
import elementRepository.HomePage;
import elementRepository.OrganizationInfoPage;
import elementRepository.OrganizationPage;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

@Listeners(genericUtility.ListenersImplementation.class)
public class ToCreateOrgWithIndustryTypeTest extends BaseClass {
	@Test(groups="Regression")
	public void toCreateOrgWithIndustryAndType_004() throws EncryptedDocumentException, IOException{
		//Navigate to Organization link
		HomePage hp=new HomePage(driver);
		hp.getOrganizationslink().click();
		
		//Click on Create Organization look up image
		OrganizationPage op=new OrganizationPage(driver);
		op.getOrganizationLookUpImage().click();
		
		//Create Organization with mandatory fields
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		
		JavaUtility jutil=new JavaUtility();
		String ORGNAME = eutil.toReadDataFromExcelFile("Organization", 1, 2)+jutil.toGenerateRandomNumber();
		
		cop.getOrganizationNameTextfield().sendKeys(ORGNAME);
		
		//Select Chemicals in the industry dropdown
		WebElement inddropdown = cop.getIndustryDropdown();
		String Chemicals = eutil.toReadDataFromExcelFile("Organization", 1,3 );
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.toHandleDropdown(inddropdown, Chemicals);
		
		//Select Customer in the Type dropdown
		WebElement typedropdown = cop.getTypeDropdown();
		String Customer = eutil.toReadDataFromExcelFile("Organization", 1, 4);
		wutil.toHandleDropdown(typedropdown, Customer);
		
		//Save and Verify
		cop.getSavebutton().click();
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String organizationName = oip.getOrganizationInfo().getText();
		Assert.assertTrue(organizationName.contains(ORGNAME));
	}

}
