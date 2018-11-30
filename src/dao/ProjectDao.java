package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;

public class ProjectDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;

	public static List<Project> getAllProject(Connection con) {
		List<Project> projectList = new ArrayList<>();
		Project project = null;
		String getAllProject = "select * from project";
		try {
			preStmt = con.prepareStatement(getAllProject);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				project = new Project(rs.getInt("id"), rs.getInt("user_info_id"), rs.getString("name"),
						rs.getString("description"), rs.getString("status"));
				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
	}

	public static Project findProjectById(Connection con, int projectId) {
		Project project = null;
		String findProjectById = "select * from project where id=?";
		try {
			preStmt = con.prepareStatement(findProjectById);
			preStmt.setInt(1, projectId);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				project = new Project(rs.getInt("id"), rs.getInt("user_info_id"), rs.getString("name"),
						rs.getString("description"), rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}
}
