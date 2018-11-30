package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.impl.FindUserInfoImpl;
import dao.impl.UserInformationImpl;
import model.UserInformation;

public class UserInformationDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static UserInformation findUserInfo(Connection con, int userId) {
		return FindUserInfoImpl.findUserInfo(con, userId);
	}

	public static UserInformation findUserInfoByEmail(Connection con, String email) {
		return FindUserInfoImpl.findUserInfoByEmail(con, email);
	}

	public static List<UserInformation> searchUserInfo(Connection con, String name, int userRoleId) {
		return UserInformationImpl.searchUserInfo(con, name, userRoleId);
	}

	public static void insertUserInfo(Connection con, UserInformation user) {
		UserInformationImpl.insertUserInfo(con, user);
	}

	public static void updateUserInfo(Connection con, int userId, UserInformation user) {
		UserInformationImpl.updateUserInfo(con, userId, user);
	}

	public static List<UserInformation> getAllUserInfo(Connection con) {
		
		return UserInformationImpl.getAllUserInfo(con);
	}
}
