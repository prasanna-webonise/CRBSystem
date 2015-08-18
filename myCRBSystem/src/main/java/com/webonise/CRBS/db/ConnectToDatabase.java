package com.webonise.CRBS.db;

import java.sql.*;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

@Component
public class ConnectToDatabase {

	private final static String driver;
	private final static String user;
	private final static String url;
	private final static String password;

	static {
		ResourceBundle resource = ResourceBundle
				.getBundle("com.webonise.CRBS.db.database");
		driver = resource.getString("driver");
		url = resource.getString("url");
		user = resource.getString("user");
		password = resource.getString("password");
	}

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
