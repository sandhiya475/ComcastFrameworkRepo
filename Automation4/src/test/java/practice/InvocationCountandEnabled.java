package practice;

import org.testng.annotations.Test;

public class InvocationCountandEnabled {
	
		@Test(invocationCount = 10)
		public void createAccunt() {
			System.out.println("account created successfully");
		}

		@Test(enabled=false)
		public void editAccount() {
			System.out.println("account edited successfully");
		}

		@Test(dependsOnMethods = "createAccunt")
		public void deleteAccount() {
			System.out.println("account deleted successfully");
		}
}
