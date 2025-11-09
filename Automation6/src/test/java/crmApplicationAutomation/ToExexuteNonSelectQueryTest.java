package crmApplicationAutomation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class ToExexuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%","root");
		Statement state = conn.createStatement();
		int result = state.executeUpdate("insert into project values('fb_PROJ_20425','deepak','04/27/2023','you_tube90','on Going','100')");
		System.out.println(result);
		conn.close();
		
	}

}
