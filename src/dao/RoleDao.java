package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Role;
import model.UserAccount;

public class RoleDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static Role findUserRole(Connection con, String userRoleName) {
		String findUserRoleId = "select * from role where name=?";
		Role userRole = null;
		try {
			preStmt = con.prepareStatement(findUserRoleId);
			preStmt.setString(1, userRoleName);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				userRole = new Role(rs.getInt("id"), userRoleName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DataAccess.closeQuietly(con);
		}
		return userRole;
	}

	public static Role checkUserRole(Connection con, String username, String password) {
		Role userRole = null;
		UserAccount user = UserAccountDao.checkUserAccount(con, username, password);
		if (user != null) {
			int userInfoId = user.getUserInfoId();
			int userRoleId = UserInformationDao.findUserInfo(con, userInfoId).getUserRoleId();
			String checkUserRole = "select * from role where id=?";
			try {
				preStmt = con.prepareStatement(checkUserRole);
				preStmt.setInt(1, userRoleId);
				rs = preStmt.executeQuery();
				while (rs.next()) {
					userRole = new Role(rs.getInt("id"), rs.getString("name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				DataAccess.closeQuietly(con);
			}
		}
		return userRole;
	}
}
