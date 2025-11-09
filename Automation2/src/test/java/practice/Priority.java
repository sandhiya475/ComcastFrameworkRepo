package practice;

import org.testng.annotations.Test;

public class Priority {
@Test(priority = 1)
public void createAccunt() {
	System.out.println("account created successfully");
}

@Test(priority = 2)
public void editAccount() {
	System.out.println("account edited successfully");
}

@Test(priority = 3)
public void deleteAccount() {
	System.out.println("account deleted successfully");
}
}
