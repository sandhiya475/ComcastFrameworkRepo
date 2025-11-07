package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import elementRepository.ContactInfoPage;
import elementRepository.ContactsPage;
import elementRepository.CreateContactPage;
import elementRepository.HomePage;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;

@Listeners(genericUtility.ListenersImplementation.class)
public class ToCreateContactWithOrgTest extends BaseClass {
@Test(groups="Smoke")
public void toCreateContactWithOrg_005() throws EncryptedDocumentException, IOException, InterruptedException {
	//Navigate to contacts link
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	
	//Click on Create contact look up image
	ContactsPage cp=new ContactsPage(driver);
	cp.getContactLookupImageIcon().click();
	
	//Create contact with mandatory fields
	CreateContactPage ccp=new CreateContactPage(driver);
	ExcelFileUtility eutil=new ExcelFileUtility();
	String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
	ccp.getLastnameTextfield().sendKeys(LASTNAME);
	
	//Select the Organization from Organization look up image
	cp.getOrganizationLookUpImage().click();
	WebDriverUtility wutil=new WebDriverUtility();
	//wutil.toHandleWindows(driver);
	wutil.toSwitchWindow(driver, "accounts");
	//driver.findElement(By.linkText("TCS")).click();
	ccp.getOrganizationName().click();
	wutil.toSwitchWindow(driver, "Contacts");
	
	
	//Save and Verify
	 ccp.getSavebutton().click();
	 ContactInfoPage cip=new ContactInfoPage(driver);
	 String lastname = cip.getContactInfonfo().getText();
	 Assert.assertTrue(lastname.contains(LASTNAME));
	  
	  
}
	
	
}

