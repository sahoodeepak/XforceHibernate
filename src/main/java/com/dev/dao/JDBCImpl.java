package com.dev.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.dev.beans.Userinfo;


public class JDBCImpl implements UserInfoDAO {

	@Override
	public boolean createProfile(Userinfo data) {

		Connection con = null;
		PreparedStatement pstmt1 = null;
		FileReader reader = null;
		String dbUrl = "jdbc:mysql://localhost:3306/xforce_db";
		String query1 = " insert into user_info values(?,?,?,?,? ) ";
		try {

			// 1.Load the driver....
			// Driver class : com.mysql.jdbc.Driver

			// creating the properties instance...
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("C:\\Users\\Deepak\\Desktop\\connection.properties");

			Properties properties = new Properties();
			properties.load(reader);
			con = DriverManager.getConnection(dbUrl, properties);
			// String driver_class_name =
			// properties.getProperty("driver_class");
			// Driver driver = (Driver)
			// Class.forName(driver_class_name).newInstance();
			// DriverManager.registerDriver(driver);
			// String dburl = properties.getProperty("url");
			// con = DriverManager.getConnection(dburl, properties);

			// 3.issue the sql queries via connection
			pstmt1 = con.prepareStatement(query1);

			pstmt1.setInt(1, data.getUser_id());
			pstmt1.setString(2, data.getFirstName());
			pstmt1.setString(3, data.getLastName());
			pstmt1.setString(4, data.getEmail_id());
			pstmt1.setString(5, data.getPassword());

			pstmt1.executeUpdate();

			return true;

		} // try

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// 5 close all jdbc object
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} // end finally

		return true;
	}

	@Override
	public Userinfo login(int User_id, String Password) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FileReader reader = null;
		String dbUrl = "jdbc:mysql://localhost:3306/xforce_db";
		String query = "select * from user_info where user_id=? and password=?";

		Userinfo user = new Userinfo();
		try {
			// 1.Load the driver....
			// Driver class : com.mysql.jdbc.Driver

			// creating the properties instance...
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("C:\\Users\\Deepak\\Desktop\\connection.properties");

			Properties properties = new Properties();
			properties.load(reader);
			con = DriverManager.getConnection(dbUrl, properties);

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, User_id);
			pstmt.setString(2, Password);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				int user_id = rs.getInt("user_id");
				user.setUser_id(user_id);
				String FirstName = rs.getString("first_name");
				user.setFirstName(FirstName);
				String LastName = rs.getString("last_name");
				user.setLastName(LastName);
				String Email_id = rs.getString("email");
				user.setEmail_id(Email_id);
				String password = rs.getString("password");
				user.setPassword(Password);

				return user;

			} // end if loop
			else {
				return null;
				// System.out.println("Login Failed");
			}
		} // end try block

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} // end inside try block

			catch (Exception e) {
				e.printStackTrace();
			}

		} // end finally

		return user;
	}

}
