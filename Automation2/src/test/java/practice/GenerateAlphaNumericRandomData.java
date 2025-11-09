/**
 * 
 */
package practice;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {

		int n=20;
		String alphanumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<n;i++) {
			int index=(int)(alphanumericString.length()*Math.random());
			sb.append(alphanumericString.charAt(index));
		}
		System.out.println(sb);
		
	}

}
