package organizationTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.basetest.BaseClass;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.crm.objectRepositoryUtility.OrganizationsPage;
@Listeners(com.crm.listenerutility.ListImpClass.class)
public class OrganizationTest extends BaseClass{
@Test(groups="SmokeTest")
public void CreateOganizationTest() throws Throwable {
	int rno = jutil.toGenerateRandomNumber();
	String orgName = eutil.getDataFromExcel("Organization",1,2)+rno;
	 
	//Navigate to organization module
	HomePage hp=new HomePage(driver);
	hp.getOrganizationsLink().click();

	//Click on create organization link
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getOrgLookupimgIconBtn().click();
	
	//Enter all details and create new organization 
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.getOrgNameTextfield().sendKeys(orgName);
	cnop.getSaveButton().click();
	
	//Verify Header msg Expected Result
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String headerInfo =	oip.getHeaderinfo().getText();
	boolean status = headerInfo.contains(orgName);
	Assert.assertEquals(status, true);
}

@Test(groups = "RegressionTest")
public void CreateOrganizationWithIndustryAndTypeTest() throws Throwable {
	int rno = jutil.toGenerateRandomNumber();
	ExcelUtility eutil=new ExcelUtility();
	String Organization = eutil.getDataFromExcel("Organization",1,3)+rno;
	String type= eutil.getDataFromExcel("Organization",4,4);	
	String industry = eutil.getDataFromExcel("Organization",4,3);
	
	//Navigate to organization module
	HomePage hp=new HomePage(driver);
	hp.getOrganizationsLink().click();
	
	//Click on create organixzation link
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getOrgLookupimgIconBtn().click();
	
	//Enter all details and create new organization 
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.getOrgNameTextfield().sendKeys(Organization);
    WebElement indus = cnop.getIndustryDropdownElement();
    Select select=new Select(indus);
    select.selectByValue(industry);
    WebElement typedd=cnop.getTypeDropdownElement();
    Select ref=new Select(typedd);
    ref.selectByValue(type);
	
    cnop.getSaveButton().click();
    Reporter.log("Organization created with industry and type dropdown",true);
 
	//Verify industry and type info
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String actIndus = oip.getIndustryDropdowninfo().getText();
	Assert.assertEquals(actIndus, industry);
	
	String actType = oip.getTypeDropdowninfo().getText();
	Assert.assertEquals(actType, type);
}

@Test(groups = "RegressionTest")
public void CreateOrganizationWithPhoneNumberTest() throws Throwable {
	int rno = jutil.toGenerateRandomNumber();
	String Organization = eutil.getDataFromExcel("Organization",1,2)+rno;
	String phno = eutil.getDataFromExcel("Organization",7,3);
	//Navigate to organization module
	HomePage hp=new HomePage(driver);
	hp.getOrganizationsLink().click();
	
	//Click on create organixzation link
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getOrgLookupimgIconBtn().click();
	
	//Enter all details and create new organization 
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.getOrgNameTextfield().sendKeys(Organization);
	cnop.getPhonetextfield().sendKeys(phno);
	cnop.getSaveButton().click();
	Reporter.log("Organization name Created with Phone number",true);
	
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String actPhno = oip.getPhoneNuminfo().getText();
	Assert.assertEquals(phno, actPhno);
}
}
