package com.klasscode.gestPark.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/gestParking";
	private String jdbcUsername = "python-admin";
	private String jdbcPassword = "@pythonwork";
	
	private static Connection connection;

	private JDBCUtils() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			try {
				connection.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {

		if(connection == null) {
			new JDBCUtils();
		}
		
		return connection;
	}
}
