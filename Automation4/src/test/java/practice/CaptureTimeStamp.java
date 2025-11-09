package practice;

import java.util.Date;

public class CaptureTimeStamp {
public static void main(String[] args) {
	String time1 = new Date().toString();
	System.out.println(time1); //Thu Oct 30 16:09:05 IST 2025
	String time = new Date().toString().replace(" ", "_").replace(":", "_");
	System.out.println(time);  //Thu_Oct_30_16_10_40_IST_2025
}
}
