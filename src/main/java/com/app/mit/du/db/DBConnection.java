package com.app.mit.du.db;

import com.app.mit.du.user.RegularUser;
import com.app.mit.du.user.User;
import com.app.mit.du.utils.RandomNumberGenerator;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBConnection {

	private Connection transConnection;
	RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

	// Define SQL sentences
	private static final String SQL_SELECT = "SELECT id, username, password FROM User";
	private static final String SQL_SELECT_ONE = "SELECT id, username, password FROM User WHERE id = ?";
	private static final String SQL_SELECT_BY_USERNAME = "SELECT id, username, password FROM User WHERE username = ?";
	private static final String SQL_INSERT_USER = "INSERT INTO User(id, username, password) VALUES (?,?,?)";
	private static final String SQL_UPDATE_USER = "UPDATE User SET name=?,price=?,quantity=?, description=? WHERE id = ?";
	private static final String SQL_DELETE_USER = "DELETE FROM User WHERE id = ?";

	public DBConnection(Connection conn){
		this.transConnection = conn;
	}

	public DBConnection() {

	}


	public ArrayList<User> getAllUser() throws SQLException{
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		ArrayList<User> Users = new ArrayList<>();

		try {
			conn = this.transConnection !=null?this.transConnection:getFileFromResources();
			pStatement = conn.prepareStatement(SQL_SELECT);
			rs = pStatement.executeQuery();
			while (rs.next()){
				Users.add(new RegularUser(
						rs.getString("id"),
						rs.getString("username"),
						rs.getString("password")
				));
			}
		}catch (SQLSyntaxErrorException ex){
			System.err.println("Error: "+ex.getMessage());
		}catch (CommunicationsException ex){
			System.err.println("Error: Can't connect with database server");
		}
		finally {
			if(rs != null)close(rs);
			if(pStatement != null)close(pStatement);
			if(conn != null) {
                if(this.transConnection == null )close(conn);
            }
		}
		return Users;
	}



	public User getUserByID(String userID) throws SQLException{
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		User User = null;
		try {
			conn = this.transConnection !=null?this.transConnection:getFileFromResources();
			pStatement = conn.prepareStatement(SQL_SELECT_ONE);
			pStatement.setString(1,userID);
			rs = pStatement.executeQuery();
			while (rs.next()){
				User = new RegularUser(
						rs.getString("id"),
						rs.getString("username"),
						rs.getString("password")
				);
			}
		}catch (SQLSyntaxErrorException ex){
			System.err.println("Error: "+ex.getMessage());
		}catch (CommunicationsException ex){
			System.err.println("Error: Can't connect with database server");
		}
		finally {
			if(rs != null)close(rs);
			if(pStatement != null)close(pStatement);
			if(conn != null) {
                if(this.transConnection == null) close(conn);
            }

		}
		return User;
	}

	public User getUserByName(String userName) throws SQLException{
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		User User = null;
		try {
			conn = this.transConnection !=null?this.transConnection:getFileFromResources();
			pStatement = conn.prepareStatement(SQL_SELECT_BY_USERNAME);
			pStatement.setString(1,userName);
			rs = pStatement.executeQuery();
			while (rs.next()){
				User = new RegularUser(
						rs.getString("id"),
						rs.getString("username"),
						rs.getString("password")
				);
			}
		}catch (SQLSyntaxErrorException ex){
			System.err.println("Error: "+ex.getMessage());
		}catch (CommunicationsException ex){
			System.err.println("Error: Can't connect with database server");
		}
		finally {
			if(rs != null)close(rs);
			if(pStatement != null)close(pStatement);
			if(conn != null) {
				if(this.transConnection == null) close(conn);
			}

		}
		return User;
	}

	public User insert(User user) throws SQLException{
		// validate username
		if(user.getUsername() == null) {
			return user;
		}
		Connection conn = null;
		PreparedStatement pStatement = null;
		int result = 0;
		try {
			conn = this.transConnection !=null?this.transConnection:getFileFromResources();
			pStatement = conn.prepareStatement(SQL_INSERT_USER);
			pStatement.setString(1,randomNumberGenerator.generateRandomAlphanumeric(10));
			pStatement.setString(2,user.getUsername());
			pStatement.setString(3,user.getPassword());
			result = pStatement.executeUpdate();

		}catch (SQLSyntaxErrorException ex){
			System.err.println("Error: "+ex.getMessage());
		}catch (CommunicationsException ex){
			System.err.println("Error: Can't connect with database server");
		}
		finally {
			if(pStatement != null)close(pStatement);
			if(conn != null) {
                if(this.transConnection == null) close(conn);
            }

		}
		return user;
	}

/*
	public int update(User User) throws SQLException{
		Connection conn = null;
		PreparedStatement pStatement = null;
		int result = 0;
		try {
			conn = this.transConnection !=null?this.transConnection:getConnection();
			pStatement = conn.prepareStatement(SQL_UPDATE_USER);
			pStatement.setString(1,User.getName());
			pStatement.setDouble(2,User.getprice());
			pStatement.setInt(3,User.getQuantity());
			pStatement.setString(4,User.getDescription());
			pStatement.setInt(5,User.getIdUser());
			result = pStatement.executeUpdate();
		}catch (SQLSyntaxErrorException ex){
			System.err.println("Error: "+ex.getMessage());
		}catch (CommunicationsException ex){
			System.err.println("Error: Can't connect with database server");
		}
		finally {
			try {
				if(pStatement != null)close(pStatement);
				if(conn != null) {
					if(this.transConnection == null) close(conn);
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}

		}
		return result;
	}
*/

	public void delete(String userID) throws SQLException{
		Connection conn = null;
		PreparedStatement pStatement = null;
		int result = 0;
		try {
			conn = this.transConnection !=null?this.transConnection:getFileFromResources();
			pStatement = conn.prepareStatement(SQL_DELETE_USER);
			pStatement.setString(1, userID);
			result = pStatement.executeUpdate();
		}catch (SQLSyntaxErrorException ex){
			System.err.println("Error: "+ex.getMessage());
		}catch (CommunicationsException ex){
			System.err.println("Error: Can't connect with database server");
		}
		finally {
			if(pStatement != null)close(pStatement);
			if(conn != null) {
                if(this.transConnection == null) close(conn);
            }

		}
	}

	public Connection getFileFromResources() {

		Properties prop = new Properties();
		try {

			prop.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));

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
