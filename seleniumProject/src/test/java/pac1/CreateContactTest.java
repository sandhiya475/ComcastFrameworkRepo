package pac1;

import org.testng.annotations.Test;

import com.crm.basetest.BaseClass1;

public class CreateContactTest extends BaseClass1 {
@Test(groups = "SmokeTest")
public void createContactTest() {
	System.out.println("contact created successfully");
	String BROWSER = System.getProperty("browser");
	String URL = System.getProperty("url");
	String USERENAME = System.getProperty("username");
	String PASSWORD = System.getProperty("password");
	System.out.println(BROWSER);
	System.out.println(URL);
	System.out.println(USERENAME);
	System.out.println(PASSWORD);
}

@Test(groups = "RegressionTest")
public void modifyContactTest() {
	System.out.println("contact modified successfully");
}
}
