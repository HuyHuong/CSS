package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.impl.UserAccountAdminImpl;
import dao.impl.UserAccountLoginImpl;
import model.UserAccount;

public class UserAccountDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static void insertUserAccount(Connection con, UserAccount user) {
		UserAccountAdminImpl.insertUserAccount(con, user);
	}

	public static void setPassword(Connection con, int userInfoId, String newPassword) {
		UserAccountAdminImpl.setPassword(con, userInfoId, newPassword);
	}

	public static UserAccount findUserAccountByUserInfoId(Connection con, int userInfoId) {
		return UserAccountLoginImpl.findUserAccountByUserInfoId(con, userInfoId);
	}

	public static UserAccount checkUserAccount(Connection con, String username, String password) {
		return UserAccountLoginImpl.checkUserAccount(con, username, password);
	}

	public static boolean checkUsername(Connection con, String username) {
		return UserAccountLoginImpl.checkUsername(con, username);
	}

}
