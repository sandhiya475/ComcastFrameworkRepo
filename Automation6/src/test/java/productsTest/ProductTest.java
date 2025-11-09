package productsTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.basetest.BaseClass;
import com.crm.generic.webdriverUtility.JavaUtility;
import com.crm.objectRepositoryUtility.CreateNewProductPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.ProductInfoPage;
import com.crm.objectRepositoryUtility.ProductsPage;
@Listeners(com.crm.listenerutility.ListImpClass.class)
public class ProductTest extends BaseClass {
@Test(groups="SmokeTest")
public void  createNewProductTest() throws Throwable {
    String productsName = eutil.getDataFromExcel("Products",1,2);
	
	//Click on the products link
	HomePage hp=new HomePage(driver);
	hp.getProductsLink().click();
	
	//Click on the look up image
	ProductsPage pp=new ProductsPage(driver);
	pp.getCreateProductLookupimgIcon().click();
	CreateNewProductPage cnpp=new CreateNewProductPage(driver);
	cnpp.getProductnameTextfield().sendKeys(productsName);
    cnpp.getSavebutton().click();	
    Reporter.log("Product Created Successfully",true);
	
	ProductInfoPage pip=new ProductInfoPage(driver);
	String actProductName =pip.getProductInfo().getText();
	boolean status = actProductName.contains(productsName);
	Assert.assertEquals(status, true);
 }

@Test(groups = "RegressionTest")
public void CreateProductWithSupportDateTest() throws Throwable {
	String productsName = eutil.getDataFromExcel("Products",1,2);
	//Click on the products link
	HomePage hp=new HomePage(driver);
	hp.getProductsLink().click();
	
	//Click on the look up image
	ProductsPage pp=new ProductsPage(driver);
	pp.getCreateProductLookupimgIcon().click();
	
	CreateNewProductPage cnpp=new CreateNewProductPage(driver);
	cnpp.getProductnameTextfield().sendKeys(productsName);
	Reporter.log("Product Created Successfully",true);
	
	JavaUtility jutil=new JavaUtility();
	String currentDate = jutil.currentDate();
	String dateAfter30days = jutil.requriredDate(30);
	
	cnpp.getStart_dateInfo().clear();
	cnpp.getStart_dateInfo().sendKeys(currentDate);
	cnpp.getExpiry_dateInfo().clear();
	cnpp.getExpiry_dateInfo().sendKeys(dateAfter30days);
	cnpp.getSavebutton().click();
    Reporter.log("Product Created with support date Successfully",true);
    
	ProductInfoPage pip=new ProductInfoPage(driver);
	String actualcurrentDate = pip.getStartDateInfo().getText();
	Assert.assertEquals(actualcurrentDate, currentDate);
  
	String dateAfter30days1 =pip.getEndDateInfo().getText();
	Assert.assertEquals(dateAfter30days, dateAfter30days1);
}
}
