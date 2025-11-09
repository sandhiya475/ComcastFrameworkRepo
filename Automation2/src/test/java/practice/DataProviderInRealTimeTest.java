package practice;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.generic.fileutility.ExcelUtility;

public class DataProviderInRealTimeTest {
@Test(dataProvider = "getData")
public void getProductInfoTest(String brandname,String productname)throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.amazon.in/");
	
	driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
	String x="//span[text()='"+productname+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span[1]/span/span[2]";
	String price = driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	driver.quit();
}

@DataProvider
public Object[][] getData() throws Throwable{
	ExcelUtility eutil=new ExcelUtility();
	 int rowcount = eutil.getRowCount("DP");
	Object[][] objArr=new Object[rowcount][2];
	for(int i=0;i<rowcount;i++) {
		objArr[i][0]=eutil.getDataFromExcel("DP", i+1, 0);
		objArr[i][1]=eutil.getDataFromExcel("DP", i+1, 1);
	}
	return objArr;
}
}
