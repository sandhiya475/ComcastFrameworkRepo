package leadsTest;
import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.basetest.BaseClass1;
import com.crm.objectRepositoryUtility.CreateLeadsPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.LeadEditPage;
import com.crm.objectRepositoryUtility.LeadInfoPage;
import com.crm.objectRepositoryUtility.LeadsPage;
@Listeners(com.crm.listenerutility.ListImpClass.class)
public class LeadsTest extends BaseClass1 {
@Test(groups="SmokeTest")
public void createLeadsTest() throws Throwable {
	//Read testscript data from Excel file
    int rno = jutil.toGenerateRandomNumber();
    String companyName = eutil.getDataFromExcel("Leads",1,2)+rno;
    String leadName = eutil.getDataFromExcel("Leads",1,3);
    String email = eutil.getDataFromExcel("Leads",1,4);
    
	HomePage hp=new HomePage(driver);
	hp.getLeadsLink().click();
	LeadsPage lep=new LeadsPage(driver);
	lep.getLeadLookUpImgIcon().click();
	CreateLeadsPage clp=new CreateLeadsPage(driver);
	clp.getLastnameTextfield().sendKeys(leadName);
	clp.getCompanyTextfield().sendKeys(companyName);
	clp.getSavebutton().click();
	Reporter.log("Lead details created successfully",true);
		
	//To verify Lead name
	LeadInfoPage lip=new LeadInfoPage(driver);
	String actualLeadName = lip.getLeadInfo().getText();
	boolean expectedName = actualLeadName.contains(leadName);
	Assert.assertEquals(expectedName, true);
		
	lip.getEditLink().click();
	LeadEditPage lep1=new LeadEditPage(driver);
	lep1.getEmailTextfield().sendKeys(email);
	lep1.getSavebutton().click();
	Reporter.log("Lead details updated successfully",true);
	
	lip.getDeleteLink().click();
	wutil.toHandleAlertByAccept(driver);
	Reporter.log("Lead details deleted successfully",true);
 }
}


