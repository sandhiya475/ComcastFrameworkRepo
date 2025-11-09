package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUpdateQurrey {

	public static void main(String[] args) throws SQLException {
		Driver ref=new Driver();
		DriverManager.registerDriver(ref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%", "root");
        Statement stat = conn.createStatement();
        int result = stat.executeUpdate("insert into project values('fb_PROJ_2095','deepak','04/27/2023','you_tube_01','on Going','100')");
        System.out.println(result);
        conn.close();
	}

}
