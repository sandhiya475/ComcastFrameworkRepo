package practice;

import java.util.Date;

public class ToLearnSystemDateAndTime {

	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(d);//Thu Oct 02 21:52:17 IST 2025
		
		
		String date[]=d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		
		String finalDate = day+" "+month+" "+date1+" "+time+" "+year;
		System.out.println(finalDate);//Thu Oct 02 21-52-17 2025
	
	}
	}


