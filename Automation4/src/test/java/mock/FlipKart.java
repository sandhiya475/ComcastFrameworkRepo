package mock;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.objectRepositoryUtility.FlipkartPage;

public class FlipKart {
public static void main(String[] args) throws Throwable {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://www.flipkart.com/");
	FlipkartPage fp=new FlipkartPage(driver);
	fp.getSearchTF().click();
	ExcelUtility eutil=new ExcelUtility();
	fp.getSearchTF().sendKeys(eutil.getDataFromExcel("Flipkart", 1, 1),Keys.ENTER);
    WebElement data = driver.findElement(By.xpath("(//div[@class='tUxRFH']/descendant::div[text()='₹1,19,900'])[1]"));
	eutil.setDataIntoExcel("FlipKart", 1, 2, data.getText());
    System.out.println("data inserted");
   
    fp.getSearchTF().clear();
    Thread.sleep(5000);
    fp.getSearchTF().click();
    fp.getSearchTF().sendKeys(eutil.getDataFromExcel("Flipkart", 2, 1),Keys.ENTER);
    WebElement shoes = driver.findElement(By.xpath("//a[text()='BLACK SHOES PREMIUM QUALITY MEN Sneakers Casuals (Black...']/../../..//div[text()='₹371']"));
    eutil.setDataIntoExcel("FlipKart", 2, 2, shoes.getText());
    System.out.println("data inserted");
    
    fp.getSearchTF().clear();
    Thread.sleep(5000);
    fp.getSearchTF().click();
    fp.getSearchTF().sendKeys(eutil.getDataFromExcel("Flipkart", 3, 1),Keys.ENTER);
    WebElement laptops = driver.findElement(By.xpath("//a[text()='BLACK SHOES PREMIUM QUALITY MEN Sneakers Casuals (Black...']/../../..//div[text()='₹371//div[text()='Samsung Galaxy Book5 AI Metal Intel Core Ultra 5 225U - (16 GB/512 GB SSD/Windows 11 Home) NP750XHD Th...']/following::div[text()='₹72,140']']"));
    eutil.setDataIntoExcel("FlipKart", 3, 2, laptops.getText());
    System.out.println("data inserted");
    
  

}
}
