package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseSelectQuerry {

	public static void main(String[] args) throws SQLException {
		Driver ref=new Driver();
		DriverManager.registerDriver(ref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%", "root");
        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery("select * from project");
        result.next();
        System.out.println(result.getString(1));
        conn.close();
	}

}
