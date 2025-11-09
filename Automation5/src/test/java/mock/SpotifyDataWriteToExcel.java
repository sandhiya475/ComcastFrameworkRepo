package mock;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.basetest.BaseClass1;

public class SpotifyDataWriteToExcel extends BaseClass1 {
	public static void main(String[] args) throws Throwable {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://open.spotify.com/artist/1mYsTxnqsietFxj1OgoGbG");
	
	List<WebElement> artist1songs = driver.findElements(By.xpath("//div[@class='hb8C1VAjyUg0VMxrwpix']"));

	FileInputStream fis=new FileInputStream("./testData/Book1.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
    // Sheet sh = wb.getSheet("spotify");

     int rowNum = 0;
	 for (WebElement song : artist1songs) {
         String songName = song.getText();
         wb.getSheet("spotify").createRow(rowNum++).createCell(0).setCellValue(songName);
         System.out.println("Fetched: " + songName);
     }

     FileOutputStream fos = new FileOutputStream("./testData/Book1.xlsx");
     wb.write(fos);
     wb.close();
     fos.close();

     driver.quit();
}
}