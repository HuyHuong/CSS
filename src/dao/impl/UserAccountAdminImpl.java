package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserAccount;

public class UserAccountAdminImpl {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static void insertUserAccount(Connection con, UserAccount user) {
		String insertUserAccount = "insert into user_account(user_info_id, username, password) values(?, ?, ?)";
		try {
			preStmt = con.prepareStatement(insertUserAccount);
			preStmt.setInt(1, user.getUserInfoId());
			preStmt.setString(2, user.getUsername());
			preStmt.setString(3, user.getPassword());
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void setPassword(Connection con, int userInfoId, String newPassword) {
		String setPassword = "update user_account set password=? where user_info_id=?";
		try {
			preStmt = con.prepareStatement(setPassword);
			preStmt.setString(1, newPassword);
			preStmt.setInt(2, userInfoId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
