package vendorTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.basetest.BaseClass;
import com.crm.objectRepositoryUtility.CreateNewVendorsPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.VendorInfoPage;
import com.crm.objectRepositoryUtility.VendorsPage;
@Listeners(com.crm.listenerutility.ListImpClass.class)
public class VendorsTest extends BaseClass {
@Test(groups="SmokeTest")
public void CreateVendorsTest() throws Throwable {
	int rno = jutil.toGenerateRandomNumber();
	String vendorname = eutil.getDataFromExcel("Vendors",1,2)+rno;
	String email = eutil.getDataFromExcel("Vendors",1,3);
	String phno = eutil.getDataFromExcel("Vendors",1,4);
	
	HomePage hp=new HomePage(driver);
	hp.getMoreLink().click();
	hp.getVendorsLink().click();
	
	VendorsPage vp=new VendorsPage(driver);
	vp.getCreatenewvendorlookupimgIcon().click();
	
	CreateNewVendorsPage cnvp=new CreateNewVendorsPage(driver);
	cnvp.getVendornameTextfield().sendKeys(vendorname);
	cnvp.getEmailTextfield().sendKeys(email);
	cnvp.getPhoneTextfield().sendKeys(phno);
	cnvp.getSavebutton().click();
	Reporter.log("vendor name created successfully",true);
	
	VendorInfoPage vip=new VendorInfoPage(driver);
	String actualvendorname =vip.getVendorNameInfo().getText();
	boolean status = actualvendorname.contains(vendorname);
    Assert.assertEquals(status, true);
}
}
