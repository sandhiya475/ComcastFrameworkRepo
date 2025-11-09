package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateAndTime {

	public static void main(String[] args) {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sim.format(d);
		System.out.println(currentDate);
	}

}
