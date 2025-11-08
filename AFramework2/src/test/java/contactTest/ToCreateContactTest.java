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
@Listeners(genericUtility.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass {
  @Test(groups="Smoke")
  public void toCreateContact_001() throws EncryptedDocumentException, IOException, InterruptedException {
	  //Navigate to contacts link
	  HomePage hp=new HomePage(driver);
	  hp.getContactsLink().click();
			  
	  //Click on create contact look up image
	  ContactsPage cp=new ContactsPage(driver);
	  cp.getContactLookupImageIcon().click();
	  
	  //Create contact with mandatory fields
	  ExcelFileUtility eutil=new ExcelFileUtility();
	  String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
	  CreateContactPage ccp=new CreateContactPage(driver);
	  ccp.getLastnameTextfield().sendKeys(LASTNAME);
	  
	  //Save and Verify
	  ccp.getSavebutton().click();
	  //fail
	  //Assert.fail();
	  ContactInfoPage cip=new ContactInfoPage(driver);
	  String lastname = cip.getContactInfonfo().getText();
	  Assert.assertTrue(lastname.contains(LASTNAME));
	  /*if(lastname.contains(LASTNAME)) {
		  System.out.println(lastname+"----Passed");
	  }else {
		  System.out.println(lastname+"----Failed");
	  }*/
	  
	  
	  
  }
	
}
