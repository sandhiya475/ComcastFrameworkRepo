package practice;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToWriteDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Organization");
		
	    Row row = sh.getRow(1);
	    Cell cel = row.createCell(5);
	    //cel.setCellType(CellType.STRING);
	    cel.setCellValue("Pass");
	    
	    FileOutputStream fos=new FileOutputStream("./testData/Book1.xlsx");
	    wb.write(fos);
	    wb.close();
	    System.out.println("====Executed====");

	}

}
