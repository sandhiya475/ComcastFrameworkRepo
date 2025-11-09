package crmApplicationAutomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DDTfromDataBase {

	public static void main(String[] args) throws SQLException {
		
        Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%", "root");
	    Statement stat = conn.createStatement();
	    ResultSet resultset = stat.executeQuery("select * from project");
	    resultset.next();
	    System.out.println( resultset.getString(2));
	   
	    conn.close();
	    
	}

}
