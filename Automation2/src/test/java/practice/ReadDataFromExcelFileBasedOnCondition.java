package practice;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFileBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String expData="TC_02";
        String data1=" ";
        String data2=" ";
        String data3=" ";
        String data4=" ";
        boolean flag=false;
            //To read data from excel file
            FileInputStream fis1=new FileInputStream(".\\testData\\Book1.xlsx");
      		Workbook wb=WorkbookFactory.create(fis1);
      		Sheet sh = wb.getSheet("Organization");
      		
      		int rowcount = sh.getLastRowNum();
      		for(int i=0;i<rowcount;i++) {
      			String data=" ";
      			try {
      				data=sh.getRow(i).getCell(0).toString();
      				if(data.contains(expData)) {
      					flag=true;
      					data1=sh.getRow(i).getCell(1).toString();
      					data2=sh.getRow(i).getCell(2).toString();
      					data3=sh.getRow(i).getCell(3).toString();
      					data4=sh.getRow(i).getCell(4).toString();
      				}
      			}
      			catch(Exception e) { }
      			  
      	}
      		if(flag==true) {
      			System.out.println(data1);
      			System.out.println(data2);
      			System.out.println(data3);
      			System.out.println(data4);
      		}
      			else {
      				System.out.println(expData+" not available in excel file");
      			}
   
      		}
      	
}
