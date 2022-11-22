package com.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.db.DatabaseConnector;

public class EmployeeDAO extends DatabaseConnector {
	
	private final static String EMP_ID = "EMP_ID";
	private final static String FIRST_NAME = "FIRST_NAME";
	private final static String LAST_NAME = "LAST_NAME";
	private final static String ADDRESS = "ADDRESS";
	private final static String CITY = "CITY";
	
	private final String SELECT_ALL_EMLOYEES_QRY = "SELECT * FROM EMPLOYEE";

	public List<Map<String, Object>> getAllEmployee() throws ClassNotFoundException, SQLException {
		Connection conn = getDatabaseConnection();
		PreparedStatement pStmt = conn.prepareStatement(SELECT_ALL_EMLOYEES_QRY);
		ResultSet rs = pStmt.executeQuery();
		
		List<Map<String, Object>> employeeList = new ArrayList<Map<String, Object>>();
		while (rs.next()) {
			Map<String, Object> employee = new HashMap<String, Object>();
			employee.put("EMP_ID", rs.getInt(EMP_ID));
			employee.put("FIRST_NAME", rs.getString(FIRST_NAME));
			employee.put("LAST_NAME", rs.getString(LAST_NAME));
			employee.put("ADDRESS", rs.getString(ADDRESS));
			employee.put("CITY", rs.getString(CITY));
			employeeList.add(employee);
		}
		return employeeList;
	}
}
