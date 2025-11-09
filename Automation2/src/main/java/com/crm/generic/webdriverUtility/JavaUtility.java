package com.crm.generic.webdriverUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int toGenerateRandomNumber() {
		Random rno=new Random();
		int ranvalue = rno.nextInt(5000);
		return ranvalue;    
	}
	
	
	public String toGenerateAlphaNumericRandomNum() {
		int n=20;
		String alphanumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb=new StringBuffer(n);
		for(int i=0;i<n;i++) {
			int index = (int)(alphanumericString.length()*Math.random());//62* 0.0/1.0
			sb.append(alphanumericString.charAt(index));
		}
		return sb.toString();
	}
	
	public String currentDate() {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sim.format(d);
		return currentDate;
	}
	
	public String requriredDate(int days) {
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(d);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String dateAfter30days = sim.format(cal.getTime());
		return dateAfter30days;
		
	} 
}
