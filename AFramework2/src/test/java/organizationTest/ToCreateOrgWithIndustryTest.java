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

@Listeners(genericUtility.ListenersImplementation.class)
public class ToCreateOrgWithIndustryTest extends BaseClass {
@Test(groups="Regression")
public void toCreateOrgWithIndustry_003() throws EncryptedDocumentException, IOException{
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
	WebElement dropdown = cop.getIndustryDropdown();
	String Chemicals = eutil.toReadDataFromExcelFile("Organization", 1,3 );
	wutil.toHandleDropdown(dropdown, Chemicals);
	
	//Save and Verify
	cop.getSavebutton().click();
	
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String organizationName = oip.getOrganizationInfo().getText();
	Assert.assertTrue(organizationName.contains(ORGNAME));
}
}

