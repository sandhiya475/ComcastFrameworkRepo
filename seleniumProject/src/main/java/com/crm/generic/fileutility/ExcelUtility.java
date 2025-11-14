package com.crm.generic.fileutility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelUtility {
	
 public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
	 FileInputStream fis=new FileInputStream("./testData/Book1.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	 return data;
	  }
 
 public int getRowCount(String sheetName) throws Throwable {
	 FileInputStream fis=new FileInputStream("./testData/Book1.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 int rowcount=wb.getSheet(sheetName).getLastRowNum();
	 return rowcount;
 }
 
 public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
	 FileInputStream fis=new FileInputStream("./testData/Book1.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 Cell cell = wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
	// cell.setCellType(CellType.STRING);
	 cell.setCellValue(data);
	 FileOutputStream fos=new FileOutputStream("./testData/Book1.xlsx");
	 wb.write(fos);
	 wb.close();
	}
 
 public void setDataIntoExcel1(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
	 FileInputStream fis=new FileInputStream("./testData/Book1.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	   Sheet sh = wb.getSheet(sheetName);
       Row row = sh.getRow(rowNum);

      if (row == null) {
      row = sh.createRow(rowNum);
      }
      row.createCell(cellNum).setCellValue(data);
      FileOutputStream fos=new FileOutputStream("./testData/Book1.xlsx");
 	 wb.write(fos);
 	 wb.close();
 }
 
 public void setDataIntoExcelSpotify(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
	 File file = new File("./testdata/Book1.xlsx");

	    Workbook wb;
	    Sheet sheet;

	    // If file already exists, open it
	    if (file.exists()) {
	        FileInputStream fis = new FileInputStream(file);
	        wb = WorkbookFactory.create(fis);
	        fis.close();
	    } else {
	        // If file doesn't exist, create a new workbook
	        wb = new XSSFWorkbook();
	    }

	    // Get or create sheet
	    sheet = wb.getSheet(sheetName);
	    if (sheet == null) {
	        sheet = wb.createSheet(sheetName);
	    }

	    // Get or create row
	    Row row = sheet.getRow(rowNum);
	    if (row == null) {
	        row = sheet.createRow(rowNum);
	    }

	    // Get or create cell
	    Cell cell = row.getCell(cellNum);
	    if (cell == null) {
	        cell = row.createCell(cellNum);
	    }

	    // Write data
	    cell.setCellValue(data);

	    // Write changes to file
	    FileOutputStream fos = new FileOutputStream(file);
	    wb.write(fos);
	    wb.close();
	}
}