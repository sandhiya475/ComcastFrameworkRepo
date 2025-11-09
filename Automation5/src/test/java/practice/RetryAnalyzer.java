package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzer {

	@Test(retryAnalyzer =com.crm.listenerutility.RetryListenerImp.class )
	public void activateSim() {
		System.out.println("Execute createInvoiceTest");
		Assert.assertEquals("", "login");
		System.out.println("Step_1");
		System.out.println("Step_2");
		System.out.println("Step_3");
		System.out.println("Step_4");
	}
}
