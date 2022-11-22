package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	
	private final String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/office";
	private final String MYSQL_USERNAME = "root";
	private final String MYSQL_PASSWORD = "root";
	private final String MYSQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	public Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName(MYSQL_DRIVER_NAME);
		Connection conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
		return conn;
	}
}
