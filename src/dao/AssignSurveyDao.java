package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.impl.FindAssignSurveyImpl;
import model.AssignSurvey;

public class AssignSurveyDao {
	static PreparedStatement preStmt = null;
	static ResultSet rs = null;
	private static int STATUS = 1; // Unfinish

	public static void insertAssignSurvey(Connection con, AssignSurvey assignSurvey) {
		String insertAssignSurvey = "insert into assign_survey (survey_id, project_id, user_info_id, status) values(?, ?, ?, ?)";
		try {
			preStmt = con.prepareStatement(insertAssignSurvey);
			preStmt.setInt(1, assignSurvey.getSurveyId());
			preStmt.setInt(2, assignSurvey.getProjectId());
			preStmt.setInt(3, assignSurvey.getUserInfoId());
			preStmt.setInt(4, assignSurvey.getStatus());
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertAssignSurveyList(Connection con, int surveyId, List<Integer> projectIdList) {
		AssignSurvey assignSurvey = null;
		for (Integer projectId : projectIdList) {
			assignSurvey = new AssignSurvey(surveyId, projectId,
					ProjectDao.findProjectById(con, projectId).getUserInfoId(), STATUS);
			insertAssignSurvey(con, assignSurvey);
		}
	}

	public static List<AssignSurvey> selectAllAssignSurvey(Connection con) {
		List<AssignSurvey> assignSurveyList = new ArrayList<>();
		AssignSurvey assignSurvey = null;
		String selectAllAssignSurvey = "select * from assign_survey";
		try {
			preStmt = con.prepareStatement(selectAllAssignSurvey);
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

	public static void updateAssignSurvey(Connection con, int assignSurveyId) {
		String updateAssignSurvey = "update assign_survey set status=0, updated=NOW() where id=?";
		try {
			preStmt = con.prepareStatement(updateAssignSurvey);
			preStmt.setInt(1, assignSurveyId);
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<AssignSurvey> findSurveyListByUserInfoId(Connection con, int userInfoId) {
		return FindAssignSurveyImpl.findSurveyListByUserInfoId(con, userInfoId);
	}

	public static AssignSurvey findAssignSurvey(Connection con, int assignSurveyId) {
		return FindAssignSurveyImpl.findAssignSurvey(con, assignSurveyId);
	}
}
