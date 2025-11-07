package organizationTest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
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
public class ToCreateOrgTest extends BaseClass {
@Test(groups="Regression")
public void ToCreateOrg_002() throws EncryptedDocumentException, IOException {
	//Navigate to Organization Link
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
	
	//Save and Verify
	cop.getSavebutton().click();
	 //fail
	 //Assert.fail();
	
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String organizationName = oip.getOrganizationInfo().getText();
	Assert.assertTrue(organizationName.contains(ORGNAME));
}
}
