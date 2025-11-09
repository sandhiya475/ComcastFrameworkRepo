package practice;

import java.util.Random;

public class ToGenerateRandomNumber {

	public static void main(String[] args) {
		Random r=new Random();
		int randomnum = r.nextInt(1000);
		System.out.println(randomnum);
	}

}
