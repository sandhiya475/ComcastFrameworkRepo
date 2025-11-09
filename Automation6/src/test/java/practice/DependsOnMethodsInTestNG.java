package practice;

import org.testng.annotations.Test;

public class DependsOnMethodsInTestNG {
	@Test
	public void createAccount() {
		System.out.println("account created successfully");
	}

	@Test
	public void editAccount() {
		System.out.println("account edited successfully");
	}

	@Test
	public void deleteAccount() {
		System.out.println("account deleted successfully");
	}
	
	@Test(dependsOnMethods = "deleteAccount")
	public void addAccount() {
		System.out.println("account added successfully");
	}
	
	
	
}
