package servicesTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.basetest.BaseClass;
import com.crm.objectRepositoryUtility.CreateNewServicesPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.ServicesInfoPage;
import com.crm.objectRepositoryUtility.ServicesPage;
@Listeners(com.crm.listenerutility.ListImpClass.class)
public class ServicesTest extends BaseClass {
	@Test(groups="SmokeTest")
	public void CreateServicesTest() throws Throwable {
		String servicename = eutil.getDataFromExcel("Services",1,2);
		String websitename = eutil.getDataFromExcel("Services",1,3);
		HomePage hp=new HomePage(driver);
		hp.getMoreLink().click();
		hp.getServicesLink().click();
		
		ServicesPage sp=new ServicesPage(driver);
		sp.getCreateNewservicesLookUpImageIcon().click();
		
		CreateNewServicesPage cnsp=new CreateNewServicesPage(driver);
		cnsp.getServicenameTextfield().sendKeys(servicename);
		cnsp.getWebsiteTextfield().sendKeys(websitename);
		cnsp.getServicestartDateTextfield().clear();
		String currentDate = jutil.currentDate();
		cnsp.getServicestartDateTextfield().sendKeys(currentDate);
		cnsp.getServiceendDateTextfield().clear();
		String reqDate = jutil.requriredDate(30);
		cnsp.getServiceendDateTextfield().sendKeys(reqDate);
		cnsp.getSavebutton().click();
		Reporter.log("Support end date created successfully",true);
		
		ServicesInfoPage sip=new ServicesInfoPage(driver);
		String actualServiceName =sip.getServicenameInfo().getText();
		boolean status = actualServiceName.contains(servicename);
		Assert.assertEquals(status, true);
		
		String actualwebsiteName = sip.getWebsiteInfo().getText();
		boolean webname = actualwebsiteName.contains(websitename);
		Assert.assertEquals(webname, true);
		
		String actualsupportStartDate =sip.getStartDateInfo().getText();
		boolean supStartDate = actualsupportStartDate.contains(currentDate);
		Assert.assertEquals(supStartDate, true);
		
		String actualsupportendDate =sip.getEndDateInfo().getText();
		boolean supportendDate = actualsupportendDate.contains(reqDate);
		Assert.assertEquals(supportendDate, true);
		 }
}