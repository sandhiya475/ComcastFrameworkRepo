package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadMultipleDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/Assignment.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Amazon");
		
		int rowcount = sh.getLastRowNum();
		
		for(int i=0;i<rowcount;i++) {
			Row row = sh.getRow(i);
			String coloumn1Data = row.getCell(0).toString();
			String coloumn2Data = row.getCell(1).toString();
			System.out.println(coloumn1Data+"\t"+coloumn2Data);
		}
      wb.close();
	}

}
