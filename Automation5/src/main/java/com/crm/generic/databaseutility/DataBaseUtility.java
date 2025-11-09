package com.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
public void getDBconnection() throws Throwable {
	try {
	Driver ref=new Driver();
	DriverManager.registerDriver(ref);
    conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza-hrm","root@%","root");
	}catch(Exception e){
		
	}
}

public void closeDBconnection() throws Throwable {
	try {
	conn.close();
	}catch(Exception e) {
		
	}
}

public ResultSet executeSelectQuery(String query) throws Throwable {
	ResultSet result=null;
	try {
	Statement stat = conn.createStatement();
    result = stat.executeQuery(query);
}catch(Exception e) {
	
}
	return result;
}

public int executeNonselectQuery(String query) throws SQLException {
	int data=0;
	try {
	Statement stat = conn.createStatement();
	data = stat.executeUpdate(query);
	
	}catch(Exception e) {
	}
	return data;
	}
}