package com.app.mit.du.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	public Connection getFileFromResources() {

		Properties prop = new Properties();
		try {

			prop.load(getClass().getResourceAsStream("application.properties"));

			String dname = (String)prop.get("ds.driver");

			String dbConnUrl = (String)prop.get("ds.url");
			String dbUserName = (String)prop.get("ds.username");
			String dbPassword = (String)prop.get("ds.password");

			Class.forName(dname);
			Connection dbConn = DriverManager.getConnection(dbConnUrl,
															dbUserName, dbPassword);

			if (dbConn != null) {
				System.out.println("Connection Successful");
			}
			else {
				System.out.println("Failed to make connection!");
			}
			return dbConn;
		}
		catch (IOException e) {

			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn)
	{
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				System.out.println("SQL Exception in close connection method");
			}
		}
	}

	public static void close(Statement stmt)
	{
		if (stmt != null) {
			try {
				stmt.close();
			}
			catch (SQLException e) {
				System.out.println("SQL Exception in close statement method");
			}
		}
	}

	public static void close(ResultSet rSet)
	{
		if (rSet != null) {
			try {
				rSet.close();
			}
			catch (SQLException e) {
				System.out.println("SQL Exception in close resultset method");
			}
		}
	}
}
