package practice;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotationInTestNg {
@Test(dataProvider  ="getData")
public void createContactTest(String firstname,String lastname) {
	System.out.println("FirstName:"+firstname+",LastName:"+lastname);
}
@DataProvider
public Object[][] getData(){
	
	Object[][] objRef=new Object[3][2];
	objRef[0][0]="Deepak";
	objRef[0][1]="Hr";
	
	objRef[1][0]="sam";
	objRef[1][1]="sh";
	
	objRef[2][0]="Jhon";
	objRef[2][1]="Smith";
	
	return objRef;
}

}
