package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DataAccess;
import model.UserInformation;

public class FindUserInfoImpl {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static UserInformation findUserInfo(Connection con, int userId) {
		UserInformation user = null;
		String findUser = "select * from user_information where id=?";
		try {
			preStmt = con.prepareStatement(findUser);
			preStmt.setInt(1, userId);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				user = new UserInformation(rs.getInt("id"), rs.getInt("user_role_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getInt("phone_number"), rs.getString("email"),
						rs.getString("address"), rs.getString("company"));
			}
		} catch (SQLException e) {
			DataAccess.closeQuietly(con);
			e.printStackTrace();
		}
		return user;
	}
	
	public static UserInformation findUserInfoByEmail(Connection con, String email) {
		String findUserInfoByEmail = "select * from user_information where email=?";
		UserInformation userInfo = null;
		try {
			preStmt = con.prepareStatement(findUserInfoByEmail);
			preStmt.setString(1, email);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				userInfo = new UserInformation(rs.getInt("id"), rs.getInt("user_role_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getInt("phone_number"), rs.getString("email"),
						rs.getString("address"), rs.getString("company"));
			}
		} catch (SQLException e) {
			DataAccess.closeQuietly(con);
			e.printStackTrace();
		}
		return userInfo;
	}
}
