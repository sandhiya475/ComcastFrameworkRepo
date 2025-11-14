package pac2;

import org.testng.annotations.Test;

public class CreateOrgTest {
	@Test(groups = "RegressionTest")
	public void createOrgTest() {
		System.out.println("org created successfully");
	}

	@Test(groups = "SmokeTest")
	public void modifyOrgTest() {
		System.out.println("org modified successfully");
	}
}
