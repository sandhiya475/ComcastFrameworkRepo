package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class WorkingWithDDTFrom_ExcelSheet {
public static void main(String[] args) throws IOException {
		
		
		//Read testscript data from Excel file
		FileInputStream fis1=new FileInputStream("./testData/Assignment.xlsx");
		
		//Open the workbook
		Workbook wb=WorkbookFactory.create(fis1);
		
		Sheet sh = wb.getSheet("Amazon");
		int rowcount = sh.getLastRowNum();
		for(int i=0;i<=rowcount;i++) {
			String colnData1 = sh.getRow(i).getCell(1).toString();
			String colnData2 = sh.getRow(i).getCell(2).toString();
			System.out.println(colnData1+"\t"+colnData2);
		}
		wb.close();
		
		 //Read testscript data from Excel file
		FileInputStream fis=new FileInputStream("./testData/Assignment.xlsx");
		
		//Open the workbook
		Workbook wb1=WorkbookFactory.create(fis);
		
		Sheet Flipkartsh = wb1.getSheet("Flipkart");
		int rowcount1 = Flipkartsh.getLastRowNum();
		for(int i=0;i<=rowcount1;i++) {
			String colnData1 = Flipkartsh.getRow(i).getCell(1).toString();
			String colnData2 = Flipkartsh.getRow(i).getCell(2).toString();
			System.out.println(colnData1+"\t"+colnData2);
		}
		wb1.close();
}
}
