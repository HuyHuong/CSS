package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DataAccess;
import model.UserInformation;

public class UserInformationImpl {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static List<UserInformation> searchUserInfo(Connection con, String name, int userRoleId) {
		List<UserInformation> userInfoList = new ArrayList<>();
		UserInformation userInfo = null;
		String searchUserInfo = "SELECT * FROM user_information WHERE user_role_id like '%" + userRoleId
				+ "%' and (first_name like '%" + name + "%' or last_name like '%" + name + "%' or phone_number like '%"
				+ name + "%' or email like '%" + name + "%' or address like '%" + name + "%' or company like '%" + name
				+ "%')";
		try {
			preStmt = con.prepareStatement(searchUserInfo);
			rs = preStmt.executeQuery();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					userInfo = new UserInformation(rs.getInt("id"), rs.getInt("user_role_id"),
							rs.getString("first_name"), rs.getString("last_name"), rs.getInt("phone_number"),
							rs.getString("email"), rs.getString("address"), rs.getString("company"));
					userInfoList.add(userInfo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	public static void insertUserInfo(Connection con, UserInformation user) {
		String insertUser = "insert into user_information (user_role_id, first_name, last_name, phone_number, email, address, company, created) values(?, ?, ?, ?, ?, ?, ?, NOW())";
		try {
			preStmt = con.prepareStatement(insertUser);
			preStmt.setInt(1, user.getUserRoleId());
			preStmt.setString(2, user.getFirstName());
			preStmt.setString(3, user.getLastName());
			preStmt.setInt(4, user.getPhoneNumber());
			preStmt.setString(5, user.getEmail());
			preStmt.setString(6, user.getAddress());
			preStmt.setString(7, user.getCompany());
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateUserInfo(Connection con, int userId, UserInformation user) {
		String updateUser = "update user_information set user_role_id=?, first_name=?, last_name=?, phone_number=?, email=?, address=?, company=?, created=NOW() where id=?";
		try {
			preStmt = con.prepareStatement(updateUser);
			preStmt.setInt(1, user.getUserRoleId());
			preStmt.setString(2, user.getFirstName());
			preStmt.setString(3, user.getLastName());
			preStmt.setInt(4, user.getPhoneNumber());
			preStmt.setString(5, user.getEmail());
			preStmt.setString(6, user.getAddress());
			preStmt.setString(7, user.getCompany());
			preStmt.setInt(8, userId);
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<UserInformation> getAllUserInfo(Connection con) {
		List<UserInformation> userInfoList = new ArrayList<>();
		UserInformation userInfo = null;
		String getAllUserInfo = "select * from user_information where user_role_id=?";

		try {
			preStmt = con.prepareStatement(getAllUserInfo);
			preStmt.setInt(1, 1);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				userInfo = new UserInformation(rs.getInt("id"), rs.getInt("user_role_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getInt("phone_number"), rs.getString("email"),
						rs.getString("address"), rs.getString("company"), rs.getTimestamp("created"));
				userInfoList.add(userInfo);
			}
		} catch (SQLException e) {
			DataAccess.closeQuietly(con);
			e.printStackTrace();
		}
		return userInfoList;
	}
}
