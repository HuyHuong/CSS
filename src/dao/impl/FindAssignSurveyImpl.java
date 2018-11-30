package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AssignSurvey;

public class FindAssignSurveyImpl {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;
	// private static int STATUS = 1; // Unfinish

	public static List<AssignSurvey> findSurveyListByUserInfoId(Connection con, int userInfoId) {
		List<AssignSurvey> assignSurveyList = new ArrayList<>();
		AssignSurvey assignSurvey = null;
		String findSurveyListByUserInfoId = "select * from assign_survey where user_info_id=? and status=?";
		try {
			preStmt = con.prepareStatement(findSurveyListByUserInfoId);
			preStmt.setInt(1, userInfoId);
			preStmt.setInt(2, 1);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				assignSurvey = new AssignSurvey(rs.getInt("id"), rs.getInt("survey_id"), rs.getInt("project_id"),
						rs.getInt("user_info_id"), rs.getInt("status"), rs.getTimestamp("updated"));
				assignSurveyList.add(assignSurvey);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assignSurveyList;
	}

	public static AssignSurvey findAssignSurvey(Connection con, int assignSurveyId) {
		AssignSurvey assignSurvey = null;
		String findAssignSurvey = "select * from assign_survey where id=?";
		try {
			preStmt = con.prepareStatement(findAssignSurvey);
			preStmt.setInt(1, assignSurveyId);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				assignSurvey = new AssignSurvey(rs.getInt("id"), rs.getInt("survey_id"), rs.getInt("project_id"),
						rs.getInt("user_info_id"), rs.getInt("status"), rs.getTimestamp("updated"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assignSurvey;
	}
}
