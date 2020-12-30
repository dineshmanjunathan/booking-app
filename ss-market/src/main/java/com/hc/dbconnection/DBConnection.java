package com.hc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements ConnectionProvider {

	static Connection con=null;
	
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(conURL, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
