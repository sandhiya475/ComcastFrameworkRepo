package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RequiredDateandTime {
public static void main(String[] args) {
	Date ref=new Date();
	System.out.println(ref);
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	String currentDate = sim.format(ref);
	System.out.println(currentDate);
	
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,30);
	String dateAfter30days = sim.format(cal.getTime());
	System.out.println("dateAfter30days "+dateAfter30days);
	
}
}
