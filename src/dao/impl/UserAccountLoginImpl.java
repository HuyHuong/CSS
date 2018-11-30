package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserAccount;

public class UserAccountLoginImpl {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static UserAccount findUserAccountByUserInfoId(Connection con, int userInfoId) {
		UserAccount user = null;
		String findUserAccountByUserInfoId = "select * from user_account where user_info_id=?";
		try {
			preStmt = con.prepareStatement(findUserAccountByUserInfoId);
			preStmt.setInt(1, userInfoId);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				user = new UserAccount(rs.getInt("user_info_id"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static UserAccount checkUserAccount(Connection con, String username, String password) {
		UserAccount user = null;
		String checkUserAccount = "select * from user_account where username = ? and password = ?";
		try {
			preStmt = con.prepareStatement(checkUserAccount);
			preStmt.setString(1, username);
			preStmt.setString(2, password);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				user = new UserAccount(rs.getInt("user_info_id"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static boolean checkUsername(Connection con, String username) {
		boolean result = true;
		UserAccount user = null;
		String checkUsername = "select * from user_account where username=?";
		try {
			preStmt = con.prepareStatement(checkUsername);
			preStmt.setString(1, username);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				user = new UserAccount(rs.getInt("user_info_id"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user != null) {
			result = false;
		}
		return result;
	}
}
