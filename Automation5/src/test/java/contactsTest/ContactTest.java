package contactsTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.basetest.BaseClass1;
import com.crm.generic.webdriverUtility.JavaUtility;
import com.crm.generic.webdriverUtility.UtilityClassObject;
import com.crm.objectRepositoryUtility.ContactInfoPage;
import com.crm.objectRepositoryUtility.ContactsPage;
import com.crm.objectRepositoryUtility.CreateContactWithOrgPage;
import com.crm.objectRepositoryUtility.CreateNewContactPage;
import com.crm.objectRepositoryUtility.HomePage;

@Listeners(com.crm.listenerutility.ListImpClass.class)
public class ContactTest extends BaseClass1 {
	@Test(groups="SmokeTest")
	public void CreateContactTest() throws Throwable {
	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
	//Read testscript data from Excel file
    String contactName = eutil.getDataFromExcel("Contacts",1,3);

	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	ContactsPage cp=new ContactsPage(driver);
    cp.getCreateContactLookupimgIcon().click();
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.getLastnameTextfield().sendKeys(contactName);
	cncp.getSaveButton().click();
	Assert.fail();
	System.out.println("Contact created successfully");
	
	ContactInfoPage cip=new ContactInfoPage(driver);
	String actContactsName =cip.getContactInfo().getText();
	boolean status = actContactsName.contains(contactName);
	Assert.assertEquals(status,true);
	}
	
	@Test(groups = "RegressionTest")
	public void createContactWithOrganizationTest() throws Throwable {
	String contactName = eutil.getDataFromExcel("Contacts",1,3);
	String childWindow = eutil.getDataFromExcel("Contacts",7,3);
	String parrentWindow = eutil.getDataFromExcel("Contacts",7,4);
	String orgName1 = eutil.getDataFromExcel("Contacts",7,2);
		
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	ContactsPage cp=new ContactsPage(driver);
    cp.getCreateContactLookupimgIcon().click();
    CreateNewContactPage cncp=new CreateNewContactPage(driver);
    cncp.getLastnameTextfield().sendKeys(contactName);
    cncp.getCreateContactWithOrgIcon().click();
    wutil.toHandleWindowByTitle(driver, childWindow);
    CreateContactWithOrgPage ccwop=new CreateContactWithOrgPage(driver);
    ccwop.getSearchTextfield().click();
    ccwop.getSearchTextfield().sendKeys(orgName1);
    ccwop.getSearchButton().click();
    ccwop.getOrgNameClickBtn().click();
    wutil.toHandleWindowByTitle(driver, parrentWindow);
    cncp.getSaveButton().click();
    System.out.println("Contact name with organization created successfully");

	ContactInfoPage cip=new ContactInfoPage(driver);
	String actContactsName1 = cip.getContactInfo().getText();
	boolean status = actContactsName1.contains(contactName);
	Assert.assertEquals(status, true);
	}
	
	@Test(groups = "RegressionTest")
	public void CreateContactWithSupportDateTest() throws Throwable {
	String contactName = eutil.getDataFromExcel("Contacts",1,3);
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	ContactsPage cp=new ContactsPage(driver);
    cp.getCreateContactLookupimgIcon().click();
    CreateNewContactPage cncp=new CreateNewContactPage(driver);
    cncp.getLastnameTextfield().sendKeys(contactName);
	
	JavaUtility jutil=new JavaUtility();
	String currentDate = jutil.currentDate();
	String dateAfter30days = jutil.requriredDate(30);

	cncp.getContactsupportstartdateTextfield().clear();
	cncp.getContactsupportstartdateTextfield().sendKeys(currentDate);
	cncp.getContactsupportenddateTextfield().clear();
	cncp.getContactsupportenddateTextfield().sendKeys(dateAfter30days);
	cncp.getSaveButton().click();
	Reporter.log("Contact created with support Date successfully",true);
	
	ContactInfoPage cip=new ContactInfoPage(driver);
	String actContactsName =cip.getContactInfo().getText();
	boolean status = actContactsName.contains(contactName);
	Assert.assertEquals(status, true);
	
	String actualcurrentDate = cip.getSupportStartDateInfo().getText();
	Assert.assertEquals(currentDate, actualcurrentDate);
    
	String actdateAfter30days=cip.getSupportEndDateInfo().getText();
	SoftAssert ref=new SoftAssert();
	ref.assertEquals(dateAfter30days, actdateAfter30days);
	ref.assertAll();
	}
	
}
