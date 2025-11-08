package genericUtility;


import java.util.Date;
import java.util.Random;

/**
 * This class consist of methods related to Java
 */
public class JavaUtility {
	
	/**
	 * This method is used to generate random integer number between the range 1-1000
	 * @return
	 */

	public int toGenerateRandomNumber() {
		Random r=new  Random();
		int randomvalue = r.nextInt(1000);
		return randomvalue;
	}
	
	/**
	 * This method is used to get system Date and Time in format
	 */
	public String toGetSystemDateandTime() {
		Date d=new Date();
		System.out.println(d);//Thu Oct 02 21:52:17 IST 2025
		

		
		String date[]=d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		
		String finalDate = day+" "+month+" "+date1+" "+time+" "+year;//Thu Oct 02 21-52-17 2025
		return finalDate;
	}
	
}

